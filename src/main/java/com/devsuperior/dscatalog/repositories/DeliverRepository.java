package com.devsuperior.dscatalog.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.dscatalog.entities.Deliver;

@Repository
public interface DeliverRepository extends JpaRepository<Deliver, Long>{

	@Query(nativeQuery = true, value = """
			SELECT *
			FROM tb_deliver
			WHERE tb_deliver.user_id IN (:userId)
			AND :offerId IS NULL OR tb_deliver.offer_id IN (:offerId)
			AND LOWER (:lesson IS NULL OR tb_deliver.lesson_id IN ('%',:lesson,'%'))
			""")
	Page<Deliver> searchDeliveries(Long userId, Long offerId, String lesson, Pageable pageable);
	
	
	@Query(nativeQuery = true, value = """
			SELECT tb_deliver.id
			FROM tb_deliver
			WHERE tb_deliver.user_id IN tb_deliver.id
			AND tb_deliver.lesson_id IN tb_deliver.lesson_id
			""")
	Optional<Deliver> verifyDeliver();
}
