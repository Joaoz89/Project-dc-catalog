package com.devsuperior.dscatalog.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.dscatalog.dto.TopicDTO;
import com.devsuperior.dscatalog.services.TopicService;

@RestController
@RequestMapping(value = "/topic")
public class TopicResource {
	
	@Autowired
	private TopicService service;
	
	@GetMapping
	public ResponseEntity<Page<TopicDTO>> findAllPaged(
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "lessonId", defaultValue = "") Long lessonId,
			Pageable pageable) {
		Page<TopicDTO> page = service.findAllPaged(name, lessonId, pageable);
		return ResponseEntity.ok().body(page);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_OPERATOR')")
	@PostMapping
	public ResponseEntity<TopicDTO> insert(@RequestBody TopicDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
				buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_OPERATOR')")
	@PutMapping
	public ResponseEntity<TopicDTO> update(@PathVariable Long id, @RequestBody TopicDTO dto) {
			dto = service.update(id, dto);
			return ResponseEntity.ok().body(dto);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_OPERATOR')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}	
}