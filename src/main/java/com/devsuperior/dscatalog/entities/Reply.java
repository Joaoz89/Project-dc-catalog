package com.devsuperior.dscatalog.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_reply")
public class Reply implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String body;
	private Instant moment;
		
	@OneToMany
	private List<User> user = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "topic_id")
	private Topic topic;
	
	@ManyToMany
	@JoinTable(name = "tb_reply_user",
	joinColumns = @JoinColumn(name = "reply_id"),
	inverseJoinColumns = @JoinColumn(name = "user_id"))
	private Set<User> likes = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "author_id")
	private User author;
	
	public Reply() {}

	public Reply(Long id, String body, Instant moment) {
		super();
		this.id = id;
		this.body = body;
		this.moment = moment;
	}

	public List<User> getUser() {
		return user;
	}

	public Topic getTopic() {
		return topic;
	}

	public Set<User> getLikes() {
		return likes;
	}

	public User getAuthor() {
		return author;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		Reply other = (Reply) obj;
		return Objects.equals(id, other.id);
	};
}
