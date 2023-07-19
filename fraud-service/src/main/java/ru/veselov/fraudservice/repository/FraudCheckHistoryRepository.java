package ru.veselov.fraudservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.veselov.fraudservice.entity.FraudCheckHistoryEntity;

import java.util.UUID;

@Repository
public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistoryEntity, UUID> {
}
