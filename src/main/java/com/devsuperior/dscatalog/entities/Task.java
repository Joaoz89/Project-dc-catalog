package com.devsuperior.dscatalog.entities;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_task")
public class Task extends Lesson {
	private static final long serialVersionUID = 1L;
	
	private String description;
	private Integer questionCount;
	private Integer approvalCount;
	private Double weight;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dueDate;

	public Task() {};

	public Task(Long id, String title, Integer position, Section section, String description, Integer questionCount,
			Integer approvalCourt, Instant dueDate) {
		super(id, title, position, section);
		this.description = description;
		this.questionCount = questionCount;
		this.approvalCount = approvalCourt;
		this.dueDate = dueDate;
	}

	
	
	public Integer getApprovalCount() {
		return approvalCount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQuestionCount() {
		return questionCount;
	}

	public void setQuestionCount(Integer questionCount) {
		this.questionCount = questionCount;
	}

	public Integer getApprovalCourt() {
		return approvalCount;
	}

	public void setApprovalCourt(Integer approvalCourt) {
		this.approvalCount = approvalCourt;
	}

	public Instant getDueDate() {
		return dueDate;
	}

	public void setDueDate(Instant dueDate) {
		this.dueDate = dueDate;
	}

	public Double getWeight() {
		return weight;
	}
	
	public void setWeight(Double weight) {
		this.weight = weight;
	}
}
