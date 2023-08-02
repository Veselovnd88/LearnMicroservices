package ru.veselov.notificationservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.veselov.amqp.producer.RabbitMQMessageProducer;
import ru.veselov.notificationservice.config.NotificationConfig;

@SpringBootApplication(
        scanBasePackages = {
                "ru.veselov.notificationservice",
                "ru.veselov.amqp"
        }
)
public class NotificationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }

}
