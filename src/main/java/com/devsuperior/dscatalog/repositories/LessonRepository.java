package com.devsuperior.dscatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.dscatalog.entities.Lesson;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long>{
	
	

}
