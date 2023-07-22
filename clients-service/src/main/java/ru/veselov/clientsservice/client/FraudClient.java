package ru.veselov.clientsservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.veselov.clientsservice.dto.FraudCheckResponse;

import java.util.UUID;

@FeignClient(value = "fraud")
public interface FraudClient {

    @GetMapping(path = "api/v1/fraud-check/{customerId}")
    FraudCheckResponse isFraudster(
            @PathVariable("customerId") UUID customerId);

}
