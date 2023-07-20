package ru.veselov.fraudservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.veselov.fraudservice.entity.FraudCheckHistoryEntity;
import ru.veselov.fraudservice.repository.FraudCheckHistoryRepository;
import ru.veselov.fraudservice.service.FraudCheckService;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class FraudCheckServiceImpl implements FraudCheckService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    @Override
    public boolean isFraudulentCustomer(UUID customerId) {
        FraudCheckHistoryEntity fraudCheckHistory = FraudCheckHistoryEntity.builder()
                .customerId(customerId)
                .isFraudster(false)
                .createdAt(LocalDateTime.now())
                .build();
        fraudCheckHistoryRepository.save(fraudCheckHistory);
        return false;
    }
}
