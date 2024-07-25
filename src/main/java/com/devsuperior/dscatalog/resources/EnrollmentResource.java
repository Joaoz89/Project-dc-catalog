package com.devsuperior.dscatalog.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dscatalog.projections.EnrollmentProjection;
import com.devsuperior.dscatalog.services.EnrollmentService;

@RestController
@RequestMapping(value = "/enrollment")
public class EnrollmentResource {

	@Autowired
	private EnrollmentService service;
	
	@GetMapping
	public ResponseEntity<EnrollmentProjection> getEnrollment(){
		EnrollmentProjection dto = service.getEnrollment();
		return ResponseEntity.ok().body(dto);
	}
}
