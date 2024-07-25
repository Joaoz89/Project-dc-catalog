package com.devsuperior.dscatalog.dto;

import java.time.Instant;

import com.devsuperior.dscatalog.entities.Deliver;
import com.devsuperior.dscatalog.entities.Lesson;
import com.devsuperior.dscatalog.entities.enums.DeliverStatus;

public class DeliverDTO {
	private Long id;
	private String uri;
	private Instant moment;
	private DeliverStatus status;
	private String feedback;
	private Integer correctCount;
		
	private Lesson lesson;

	public DeliverDTO() {}

	public DeliverDTO(Long id, String uri, Instant moment, DeliverStatus status, String feedback, Integer correctCount
			) {
	
		this.id = id;
		this.uri = uri;
		this.moment = moment;
		this.status = status;
		this.feedback = feedback;
		this.correctCount = correctCount;
		//this.lesson = lesson;
	}
	
	public DeliverDTO(Deliver entity) {
		this.id = entity.getId();
		this.uri = entity.getUri();
		this.moment = entity.getMoment();
		this.status = entity.getStatus();
		this.feedback = entity.getFeedback();
		this.correctCount = entity.getCorrectCount();
		this.lesson = entity.getLesson();
	
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public DeliverStatus getStatus() {
		return status;
	}

	public void setStatus(DeliverStatus status) {
		this.status = status;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Integer getCorrectCount() {
		return correctCount;
	}

	public void setCorrectCount(Integer correctCount) {
		this.correctCount = correctCount;
	}

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	};
}
