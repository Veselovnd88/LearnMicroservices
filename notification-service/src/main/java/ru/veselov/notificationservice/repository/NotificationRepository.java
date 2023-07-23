package ru.veselov.notificationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.veselov.notificationservice.entity.NotificationEntity;

import java.util.UUID;

@Repository
public interface NotificationRepository  extends JpaRepository<NotificationEntity, UUID> {
}
