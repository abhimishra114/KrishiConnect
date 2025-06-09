package com.example.KrishiConnect.service;

import com.example.KrishiConnect.model.Listings;
import com.example.KrishiConnect.repo.ListingRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListingService {

    ListingRepo listingRepo;

    public ListingService(ListingRepo listingRepo) {
        this.listingRepo = listingRepo;
    }

    public Listings createListing(Listings listing) {
        return listingRepo.save(listing);
    }

    public List<Listings> getAllListings() {
        return listingRepo.findAll();
    }

    public List<Listings> getListingByFarmerId(int farmerId) {
        return listingRepo.getListingByFarmerId(farmerId);
    }

    public Listings getListingById(int listingId) {
        return listingRepo.findById(listingId)
                .orElseThrow(() -> new RuntimeException("No item found"));
    }

    public List<Listings> searchListings(String keyword) {
        return listingRepo.searchListings(keyword);
    }
}
