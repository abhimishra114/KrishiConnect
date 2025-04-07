package com.example.KrishiConnect.repo;

import com.example.KrishiConnect.model.BuyerRequests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyerRequestsRepo extends JpaRepository<BuyerRequests, Integer> {
    List<BuyerRequests> findByStatus(BuyerRequests.Status status);

    List<BuyerRequests> findAllByBusinessId(int businessId);
}
