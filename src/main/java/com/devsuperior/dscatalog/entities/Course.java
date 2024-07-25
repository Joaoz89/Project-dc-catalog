package com.devsuperior.dscatalog.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String imgUri;
	private String imgGrayUri;
	
	@OneToMany(mappedBy = "course")
	private List<Offer> offers = new ArrayList<>();
	
	public Course() {};

	public Course(Long id, String name, String imgUrl, String imgGrayUr) {
		this.id = id;
		this.name = name;
		this.imgUri = imgUrl;
		this.imgGrayUri = imgGrayUr;
	}

	public void setOffer(List<Offer> offer) {
		this.offers = offer;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgUrl() {
		return imgUri;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUri = imgUrl;
	}

	public String getImgGrayUr() {
		return imgGrayUri;
	}

	public void setImgGrayUr(String imgGrayUr) {
		this.imgGrayUri = imgGrayUr;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(id, other.id);
	}		
}
