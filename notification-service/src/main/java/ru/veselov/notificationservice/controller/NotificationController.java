package ru.veselov.notificationservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.veselov.clientsservice.notification.NotificationRequest;
import ru.veselov.notificationservice.service.NotificationService;

@RestController
@RequestMapping("api/v1/notification")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest notificationRequest) {
        notificationService.send(notificationRequest);
    }

}
