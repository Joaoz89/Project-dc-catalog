package com.devsuperior.dscatalog.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscatalog.dto.DeliverDTO;
import com.devsuperior.dscatalog.dto.DeliverInsertDTO;
import com.devsuperior.dscatalog.entities.Content;
import com.devsuperior.dscatalog.entities.Deliver;
import com.devsuperior.dscatalog.entities.Enrollment;
import com.devsuperior.dscatalog.entities.User;
import com.devsuperior.dscatalog.entities.enums.DeliverStatus;
import com.devsuperior.dscatalog.repositories.DeliverRepository;
import com.devsuperior.dscatalog.repositories.EnrollmentRepository;
import com.devsuperior.dscatalog.repositories.LessonRepository;
import com.devsuperior.dscatalog.repositories.UserRepository;
import com.devsuperior.dscatalog.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DeliverService {

	@Autowired
	private DeliverRepository repository;
	
	@Autowired
	private LessonRepository lessonRepository;
	
	@Autowired
	private EnrollmentRepository enrollmentRepository;
	
	@Autowired 
	private UserRepository userRepo;
	
	@Autowired
	private AuthService authService;
	
	@Transactional
	public DeliverDTO insert (DeliverInsertDTO task) {
		
		User user = authService.authenticated();
		
		//EnrollmentPK enrollment = new EnrollmentPK(enrollmentRepository.getEnrollment(user.getId()));
		Enrollment enrollments = new Enrollment(enrollmentRepository.getEnrollment(user.getId()));
		
		//Lesson lesson = lessonRepository.getReferenceById(task.getLessonId());
				
				Deliver entity = new Deliver(null, task.getUri(), Instant.now(), DeliverStatus.PENDING, null, null);
		entity.setLesson(new Content(task.getLessonId(), null, null, null, null, null));
		entity.setEnrollment(enrollments);
		
		entity = repository.save(entity);
		return new DeliverDTO(entity);
		
	}
	
	@Transactional
	public DeliverDTO update(Long id, DeliverDTO dto) {
		
		try {
			Deliver entity = repository.getReferenceById(id);
			copyDtoToEntity(entity, entity);
			entity = repository.save(entity);
			return new DeliverDTO(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}
	
	private void copyDtoToEntity(Deliver dto, Deliver entity) {
		entity.setUri(dto.getUri());
		entity.setCorrectCount(dto.getCorrectCount());
		entity.setFeedback(dto.getFeedback());
		entity.setStatus(dto.getStatus());
		entity.setMoment(dto.getMoment());
	}
	
	
}
