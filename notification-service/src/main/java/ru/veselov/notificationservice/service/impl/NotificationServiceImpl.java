package ru.veselov.notificationservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.veselov.clientsservice.notification.NotificationRequest;
import ru.veselov.notificationservice.entity.NotificationEntity;
import ru.veselov.notificationservice.repository.NotificationRepository;
import ru.veselov.notificationservice.service.NotificationService;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    @Override
    public void send(NotificationRequest notificationRequest) {
        NotificationEntity entity = NotificationEntity.builder()
                .toCustomerId(notificationRequest.getToCustomerId())
                .message(notificationRequest.getMessage())
                .toCustomerEmail(notificationRequest.getToCustomerName())
                .sender("Lassie")
                .sentAt(LocalDateTime.now())
                .build();
        notificationRepository.save(entity);
        log.info("Notification for [{}] saved ", entity.getToCustomerId());
    }
}
