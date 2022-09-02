package com.skillstorm.project4.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.project4.models.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {

}
