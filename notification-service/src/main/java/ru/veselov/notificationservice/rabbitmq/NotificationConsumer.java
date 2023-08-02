package ru.veselov.notificationservice.rabbitmq;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ru.veselov.clientsservice.notification.NotificationRequest;
import ru.veselov.notificationservice.service.NotificationService;

@Component
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {

    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.queues.notification}")//listen specified queue
    public void consumer(NotificationRequest notificationRequest) {
        log.info("Consumed {}  from queue", notificationRequest);
        notificationService.send(notificationRequest);

    }
}
