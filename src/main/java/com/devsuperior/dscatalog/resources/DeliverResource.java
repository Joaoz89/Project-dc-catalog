package com.devsuperior.dscatalog.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.dscatalog.dto.DeliverDTO;
import com.devsuperior.dscatalog.dto.DeliverInsertDTO;
import com.devsuperior.dscatalog.services.DeliverService;

@RestController
@RequestMapping(value = "/deliver")
public class DeliverResource {

	@Autowired
	private DeliverService service;
	
	@PostMapping
	public ResponseEntity<DeliverDTO> insert(@RequestBody DeliverInsertDTO dto) {
		
		DeliverDTO response = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(response.getId()).toUri();
		
		return ResponseEntity.created(uri).body(response);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping
	public ResponseEntity<DeliverDTO> update(@PathVariable Long id, @RequestBody DeliverDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
}
