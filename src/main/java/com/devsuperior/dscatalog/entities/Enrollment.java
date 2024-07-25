package com.devsuperior.dscatalog.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.devsuperior.dscatalog.entities.pk.EnrollmentPK;
import com.devsuperior.dscatalog.projections.EnrollmentProjection;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_enrollment")
public class Enrollment implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EnrollmentPK id = new EnrollmentPK(); //chave primaria
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant enrollMoment;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE") //Segurar que vai ser salva no bd UTC
	private Instant refundMoment;
	private Boolean available; //matricula ativada
	private Boolean onlyUpdate; //matricula regular ou so atualizaçao
	
	
	@ManyToMany(mappedBy = "enrollmentsDone")
	private Set<Lesson> lessonsDone = new HashSet<>();
	
	@OneToMany(mappedBy = "enrollment")
	private List<Deliver> deliveries = new ArrayList<>();
	
	public Enrollment() {}

	public Enrollment(User user, Offer offer, Instant enrollMoment, Instant refundMoment, Boolean available,
			Boolean onlyUpdate) {
		
		id.setUser(user);
		id.setOffer(offer);
		this.enrollMoment = enrollMoment;
		this.refundMoment = refundMoment;
		this.available = available;
		this.onlyUpdate = onlyUpdate;
	}
	
	public Enrollment(EnrollmentProjection p) {
		this.id = new EnrollmentPK(p);
		this.enrollMoment = p.getEnrollMoment();
		this.refundMoment = p .getRefundMoment();
		this.available = p.getAvailable();
		this.onlyUpdate = p.getOnlyUpdate();

	}

	public Enrollment(List<EnrollmentProjection> result) {
		this.enrollMoment = result.get(0).getEnrollMoment();
//		this.refundMoment = result.get(0).getRefoundMoment();
//		this.lessonsDone = result.get(0).getLessonsDone();
//		this.deliveries = result.get(0).getDeliveries();
	
	}

	public User getStudent() {
		return id.getUser();
	}
	
	public void setStudent(User user) {
		id.setUser(user);
	}
	
	public Offer getOffer() {
		return id.getOffer();
	}

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

	public void setOffer(Offer offer) {
		id.setOffer(offer);
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
	};
}
