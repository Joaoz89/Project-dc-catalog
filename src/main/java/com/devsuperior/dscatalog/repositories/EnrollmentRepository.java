package com.devsuperior.dscatalog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.dscatalog.entities.User;
import com.devsuperior.dscatalog.projections.EnrollmentProjection;

@Repository
public interface EnrollmentRepository extends JpaRepository<User, Long> {

	@Query(nativeQuery = true, value = """
						SELECT tb_enrollment.user_id AS getUserId, tb_enrollment.offer_id AS getOfferId,tb_enrollment.available AS available, tb_enrollment.only_update AS onlyUpdate, tb_enrollment.enroll_moment AS enrollMoment, tb_offer.start_moment AS startMoment, tb_offer.end_moment AS endMoment, tb_offer.edition, tb_course.name, tb_course.img_uri AS imgUri

						FROM tb_enrollment
			INNER JOIN tb_offer ON tb_enrollment.offer_id = tb_offer.id
			INNER JOIN tb_course ON tb_offer.course_id = tb_course.id

						 WHERE tb_enrollment.user_id = :userId
						""")
	EnrollmentProjection getEnrollment(Long userId);

}
//SELECT *
//
//FROM tb_enrollment
//INNER JOIN tb_offer ON tb_enrollment.offer_id = tb_offer.id
//INNER JOIN tb_course ON tb_offer.course_id = tb_course.id

//SELECT *
//
//FROM tb_enrollment, tb_offer, tb_course
//WHERE tb_enrollment.offer_id  = tb_offer.id
//AND tb_offer.course_id = tb_course.id

//SELECT tb_enrollment.available AS available, tb_enrollment.only_update AS onlyUpdate, tb_enrollment.enroll_moment AS enrollMoment , tb_offer.start_moment ,  tb_offer.end_moment, tb_course.name
//
//FROM tb_enrollment
//INNER JOIN tb_offer ON tb_enrollment.offer_id = tb_offer.id
//INNER JOIN tb_course ON tb_offer.course_id = tb_course.id
