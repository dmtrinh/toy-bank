package com.thedarkside.toybank.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.thedarkside.toybank.model.PaymentDB;

import java.util.List;

@Repository
public interface PaymentRepository extends MongoRepository<PaymentDB, String> {
    List<PaymentDB> findByPlatformId(String platformId, Sort sort);
}
