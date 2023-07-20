package ru.veselov.fraudservice.service;

import java.util.UUID;

public interface FraudCheckService {

    boolean isFraudulentCustomer(UUID customerId);

}
