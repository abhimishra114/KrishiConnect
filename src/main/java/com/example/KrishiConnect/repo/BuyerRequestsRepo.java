package com.example.KrishiConnect.repo;

import com.example.KrishiConnect.model.BuyerRequests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyerRequestsRepo extends JpaRepository<BuyerRequests, Integer> {
    List<BuyerRequests> findByStatus(BuyerRequests.Status status);

    List<BuyerRequests> findAllByBusinessId(int businessId);

    @Query("SELECT l FROM BuyerRequests l WHERE " +
            "LOWER(l.title) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(l.description) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(l.location) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(l.category) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<BuyerRequests> searchBuyerRequests(String keyword);
}
