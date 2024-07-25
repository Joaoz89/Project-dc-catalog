package com.devsuperior.dscatalog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscatalog.dto.TopicDTO;
import com.devsuperior.dscatalog.entities.Role;
import com.devsuperior.dscatalog.entities.Topic;
import com.devsuperior.dscatalog.entities.User;
import com.devsuperior.dscatalog.repositories.LessonRepository;
import com.devsuperior.dscatalog.repositories.OfferRepository;
import com.devsuperior.dscatalog.repositories.TopicRepository;
import com.devsuperior.dscatalog.repositories.UserRepository;
import com.devsuperior.dscatalog.services.exceptions.DatabaseException;
import com.devsuperior.dscatalog.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository repository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OfferRepository offerRepository;
	
	@Autowired
	private LessonRepository lessonRepository;
	
	@Autowired
	private AuthService authService;
	
	public Page<TopicDTO> findAllPaged(String name, Long lessonId, Pageable pageable) {
		Page<Topic> result = repository.searchTopics(name, lessonId, pageable);
		return result.map(x -> new TopicDTO(x));
	}
	
	@Transactional
	public TopicDTO insert(TopicDTO dto) {
		Topic entity = new Topic();
		copyDtoToEntity(dto, entity);
		entity =  repository.save(entity);
		return new TopicDTO(entity);
	}
	
	@Transactional
	public TopicDTO update(Long id, TopicDTO dto) {
		 
		try {
			User user = authService.authenticated();
			Topic entity = repository.getReferenceById(id);
			
			if(!(entity.getAuthor().getId() == user.getId())) throw new IllegalArgumentException("You can't update this Topic, only the ones that you created");
			
		copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new TopicDTO(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id );
		}
	}
	
	@Transactional
	public void delete(Long id) {
		
		User user = authService.authenticated();
		
		try {
		Topic topic = repository.getReferenceById(id); 
		
		for (Role role: user.getRoles()) {
			if(!(role.getAuthority().equals("ROLE_ADMIN") || (topic.getAuthor().getId() == user.getId()))) throw new IllegalArgumentException("You can't delete this Topic, only the ones that you created");			
		}
		
		//if (!repository.existsById(id)) throw new ResourceNotFoundException("Resource not found");
			
			repository.deleteById(id);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Resource not found: " + id);
			}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Referential integrity failure");
		}
	}
	
	private void copyDtoToEntity(TopicDTO dto, Topic entity) {
		entity.setId(dto.getId());
		entity.setTitle(dto.getTitle());
		entity.setBody(dto.getBody());
		entity.setMoment(dto.getMoment());
		entity.setAuthor(userRepository.getReferenceById(dto.getAuthorId()));
		entity.setOffer(offerRepository.getReferenceById(dto.getOfferId()));
		entity.setLesson(lessonRepository.getReferenceById(dto.getLessonId()));
	}
}
