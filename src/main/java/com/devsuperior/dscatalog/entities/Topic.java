package com.devsuperior.dscatalog.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.devsuperior.dscatalog.dto.TopicDTO;

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
@Table(name = "tb_topic")
public class Topic implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String body;
	private Instant moment;
	
	@ManyToOne
	@JoinColumn(name = "author_id")
	private User author;
	
	@ManyToOne
	@JoinColumn(name = "offer_id")
	private Offer offer;
	
	@ManyToOne
	@JoinColumn(name = "lesson_id")
	private Lesson lesson;
	
	@ManyToMany
	@JoinTable(name = "tb_topic_likes",
	joinColumns = @JoinColumn(name = "topic_id"),
	inverseJoinColumns = @JoinColumn(name = "user_id"))
	private Set<User> likes = new HashSet<>();
	
	@OneToMany(mappedBy = "topic")
	private List<Reply> replies = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "reply_id")
	private Reply answer;

	public Topic () {};

	public Topic(Long id, String title, String body, Instant moment) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.moment = moment;
	}
	
//	public Topic(TopicDTO dto) {
//		
//		this.id = dto.getId();
//		this.title = dto.getTitle();
//		this.body = dto.getBody();
//		this.moment = dto.getMoment();
//		this.author = dto.getAuthorId();
//		this.offer = dto.getOfferId();
//		this.lesson = dto.getLesson();
//		this.likes = dto.getLikes();
//		this.replies = dto.getReplies();
//		this.answer = dto.getAnswer();
//	}

	public Lesson getLesson() {
		return lesson;
	}

	public List<Reply> getReplies() {
		return replies;
	}

	public Offer getOffer() {
		return offer;
	}

	public Set<User> getLikes() {
		return likes;
	}
	
	public Reply getReply() {
		return answer;
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

	public User getUserS() {
		return author;
	}
	 

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Reply getAnswer() {
		return answer;
	}

	public void setAnswer(Reply answer) {
		this.answer = answer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}

	public void setLikes(Set<User> likes) {
		this.likes = likes;
	}

	public void setReplies(List<Reply> replies) {
		this.replies = replies;
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
		Topic other = (Topic) obj;
		return Objects.equals(id, other.id);
	};	
}
