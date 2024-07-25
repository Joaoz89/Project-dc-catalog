package com.devsuperior.dscatalog.dto;

import java.time.Instant;

import com.devsuperior.dscatalog.entities.Notification;

public class NotificationDTO {
	
	private Long id;
	private String text;
	private Instant moment;
	private Boolean read;
	private String route;
	
	private Long userId;
	
	public NotificationDTO() {
	}
	
	public NotificationDTO(Long id, String text, Instant moment, Boolean read, String route, Long userId) {
		super();
		this.id = id;
		this.text = text;
		this.moment = moment;
		this.read = read;
		this.route = route;
		this.userId = userId;
	}

	public NotificationDTO(Notification x) {
		this.id = x.getId();
		this.text = x.getText();
		this.moment = x.getMoment();
		this.read = x.isRead();
		this.route = x.getRoute();
		this.userId = x.getUser().getId();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getRead() {
		return read;
	}

	public void setRead(Boolean read) {
		this.read = read;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
