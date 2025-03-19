package com.example.KrishiConnect.repo;

import com.example.KrishiConnect.model.BuyerRequests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRequestsRepo extends JpaRepository<BuyerRequests, Integer> {
}
