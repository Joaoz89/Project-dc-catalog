package com.devsuperior.dscatalog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscatalog.dto.NotificationDTO;
import com.devsuperior.dscatalog.entities.Notification;
import com.devsuperior.dscatalog.entities.User;
import com.devsuperior.dscatalog.repositories.NotificationRepository;

@Service
public class NotificationService {

	@Autowired
	private NotificationRepository repository;
	
	@Autowired
	private AuthService authService;
	
	@Transactional(readOnly = true)
	public Page<NotificationDTO> notificationsFromCurrentUser(Boolean unreadOnly, Pageable pageable) {

		User user = authService.authenticated();		
		Page<Notification> page = repository.find( user, unreadOnly, pageable);
		return page.map(x -> new NotificationDTO(x));
	}
}
 