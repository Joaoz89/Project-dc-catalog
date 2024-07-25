package com.devsuperior.dscatalog.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.devsuperior.dscatalog.entities.Topic;
import com.devsuperior.dscatalog.entities.User;

public class ReplyDTO {

	private Long id;

	private String body;
	private Instant moment;

	private List<User> user = new ArrayList<>();

	private Topic topic;

	private User author;

}
