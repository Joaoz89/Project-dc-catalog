package com.devsuperior.dscatalog.dto;

import com.devsuperior.dscatalog.entities.Enrollment;

public class DeliverInsertDTO {

	private String uri;
	private Long lessonId;
	
	public DeliverInsertDTO() {}

	public DeliverInsertDTO(String uri, Long lessonId) {
		super();
		this.uri = uri;
		this.lessonId = lessonId;
	}

	public Long getLessonId() {
		return lessonId;
	}

	public void setLessonId(Long lessonId) {
		this.lessonId = lessonId;
		
	}



	public DeliverInsertDTO(String uri, Long lesonId, Enrollment enrollment) {
		super();
		this.uri = uri;

	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
}
