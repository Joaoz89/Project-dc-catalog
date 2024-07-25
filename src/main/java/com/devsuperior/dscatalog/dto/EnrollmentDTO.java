package com.devsuperior.dscatalog.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.devsuperior.dscatalog.entities.Deliver;
import com.devsuperior.dscatalog.entities.Enrollment;
import com.devsuperior.dscatalog.entities.Lesson;
import com.devsuperior.dscatalog.entities.pk.EnrollmentPK;
import com.devsuperior.dscatalog.projections.EnrollmentProjection;

import jakarta.persistence.EmbeddedId;

public class EnrollmentDTO {
	
	private EnrollmentPK id = new EnrollmentPK(); //chave primaria
	
	private Instant enrollMoment;
	private Instant refundMoment;
	private Boolean available; //matricula ativada
	private Boolean onlyUpdate; //matricula regular ou so atualizaçao
	
	private Set<Lesson> lessonsDone;
	private List<Deliver> deliveries;

	public EnrollmentDTO() {};
	
	public EnrollmentDTO(EnrollmentPK id, Instant enrollMoment, Instant refundMoment, Boolean available,
			Boolean onlyUpdate, Set<Lesson> lessonsDone, List<Deliver> deliveries) {
		super();
		this.id = id;
		this.enrollMoment = enrollMoment;
		this.refundMoment = refundMoment;
		this.available = available;
		this.onlyUpdate = onlyUpdate;
		this.lessonsDone = lessonsDone;
		this.deliveries = deliveries;
	}

	public EnrollmentDTO(Enrollment entity) {
		this.id = entity.getId();
		this.enrollMoment = entity.getEnrollMoment();
		this.refundMoment = entity.getRefundMoment();
		this.available = entity.isAvailable();
		this.onlyUpdate = entity.isOnlyUpdate();
		this.lessonsDone = entity.getLessonsDone();
		this.deliveries = entity.getDeliveries();
	}
	
//	public EnrollmentDTO(List<EnrollmentProjection> result) {
//		this.enrollMoment = result.get(0).getEnrollMoment();
//		this.refundMoment = result.get(0).getRefoundMoment();
//		this.lessonsDone = result.get(0).getLessonsDone();
//		this.deliveries = result.get(0).getDeliveries();
//	
//	}
	
	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public Boolean getOnlyUpdate() {
		return onlyUpdate;
	}

	public void setOnlyUpdate(Boolean onlyUpdate) {
		this.onlyUpdate = onlyUpdate;
	}

	public EnrollmentPK getId() {
		return id;
	}

	public void setId(EnrollmentPK id) {
		this.id = id;
	}

	public Instant getEnrollMoment() {
		return enrollMoment;
	}

	public void setEnrollMoment(Instant enrollMoment) {
		this.enrollMoment = enrollMoment;
	}

	public Instant getRefundMoment() {
		return refundMoment;
	}

	public void setRefundMoment(Instant refundMoment) {
		this.refundMoment = refundMoment;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public boolean isOnlyUpdate() {
		return onlyUpdate;
	}

	public void setOnlyUpdate(boolean onlyUpdate) {
		this.onlyUpdate = onlyUpdate;
	}

	public Set<Lesson> getLessonsDone() {
		return lessonsDone;
	}

	public void setLessonsDone(Set<Lesson> lessonsDone) {
		this.lessonsDone = lessonsDone;
	}

	public List<Deliver> getDeliveries() {
		return deliveries;
	}

	public void setDeliveries(List<Deliver> deliveries) {
		this.deliveries = deliveries;
	}

}
