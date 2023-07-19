package ru.veselov.fraudservice.service;

public interface FraudCheckService {

    boolean isFraudulentCustomer(Integer customerId);

}
