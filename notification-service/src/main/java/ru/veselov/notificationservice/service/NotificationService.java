package ru.veselov.notificationservice.service;

import ru.veselov.clientsservice.notification.NotificationRequest;

public interface NotificationService {

    void send(NotificationRequest notificationRequest);

}
