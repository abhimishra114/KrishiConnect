package com.example.KrishiConnect.repo;

import com.example.KrishiConnect.model.Listings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListingRepo extends JpaRepository<Listings, Integer> {

    List<Listings> getListingByFarmerId(int farmerId);

    @Query("SELECT l FROM Listings l WHERE " +
            "LOWER(l.title) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(l.description) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(l.location) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(l.category) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Listings> searchListings(String keyword);
}
