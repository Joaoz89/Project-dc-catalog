package com.devsuperior.dscatalog.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.dscatalog.entities.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
	
	@Query(nativeQuery = true, value = """
			SELECT * 
			FROM tb_topic
			WHERE (LOWER(tb_topic.title IS NULL OR tb_topic.title LIKE CONCAT('%',:name,'%')))
			AND (:lessonId IS NULL OR tb_topic.lesson_id IN (:lessonId))
			""")
	Page<Topic> searchTopics(String name, Long lessonId, Pageable pageable);
}
