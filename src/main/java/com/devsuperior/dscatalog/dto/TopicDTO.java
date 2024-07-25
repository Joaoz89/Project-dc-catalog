package com.devsuperior.dscatalog.dto;

import java.time.Instant;

import com.devsuperior.dscatalog.entities.Topic;

public class TopicDTO {
	
	private Long id;
	private String title;
	private String body;
	private Instant moment;
	
	private Long authorId;
	private Long offerId;
	private Long lessonId;
	
	public TopicDTO() {};

	public TopicDTO (Topic entity) {
		
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.body = entity.getBody();
		this.moment = entity.getMoment();
		this.authorId = entity.getAuthor().getId();
		this.offerId = entity.getOffer().getId();
		this.lessonId = entity.getLesson().getId();
	}

	public TopicDTO(Long id, String title, String body, Instant moment, Long authorId, Long offerId, Long lessonId) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.moment = moment;
		this.authorId = authorId;
		this.offerId = offerId;
		this.lessonId = lessonId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public Long getOfferId() {
		return offerId;
	}

	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}

	public Long getLessonId() {
		return lessonId;
	}

	public void setLessonId(Long lessonId) {
		this.lessonId = lessonId;
	}

	}

