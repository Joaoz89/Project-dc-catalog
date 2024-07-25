package com.devsuperior.dscatalog.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.dscatalog.entities.Notification;
import com.devsuperior.dscatalog.entities.User;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
	
//	@Query(nativeQuery = true, value = """
//			SELECT tb_notification.text, tb_notification.moment
//			FROM tb_notification
//			WHERE tb_notification.read = :bolean
//			""")
//	List<NotificationProjection> searchNotifications (Boolean bolean);
//	
	@Query("SELECT obj FROM Notification obj WHERE "
			+ "(obj.user = :user) AND "
			+ "(:unreadOnly = false OR obj.read = false) "
			+ "ORDER BY obj.moment DESC")
	Page<Notification> find(User user, Boolean unreadOnly, Pageable pageable);
}
