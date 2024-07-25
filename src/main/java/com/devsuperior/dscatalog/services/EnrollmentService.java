package com.devsuperior.dscatalog.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscatalog.dto.EnrollmentDTO;
import com.devsuperior.dscatalog.entities.Enrollment;
import com.devsuperior.dscatalog.entities.User;
import com.devsuperior.dscatalog.projections.EnrollmentProjection;
import com.devsuperior.dscatalog.repositories.EnrollmentRepository;

@Service
public class EnrollmentService {

	@Autowired
	private EnrollmentRepository repository;
	
	@Autowired
	private AuthService authService;
	
	@Transactional(readOnly = true)
	public EnrollmentProjection getEnrollment (){
		User user = authService.authenticated();
		EnrollmentProjection result = repository.getEnrollment(user.getId());		
		
		return result;
	}
	
	
}
