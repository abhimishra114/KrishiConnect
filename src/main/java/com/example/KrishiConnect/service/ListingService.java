package com.example.KrishiConnect.service;

import com.example.KrishiConnect.dto.ListingDTO;
import com.example.KrishiConnect.model.Listings;
import com.example.KrishiConnect.repo.ListingRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListingService {

    private final ListingRepo listingRepo;
    private final UserService userService;

    public ListingService(ListingRepo listingRepo, UserService userService) {
        this.listingRepo = listingRepo;
        this.userService = userService;
    }

    public Listings createListing(Listings listing) {
        return listingRepo.save(listing);
    }

//    public List<Listings> getAllListings() {
//        return listingRepo.findAll();
//    }

    public List<ListingDTO> getAllListings() {
        List<Listings> listings = listingRepo.findAll();
        List<ListingDTO> allListing = new ArrayList<>();
        for (Listings li : listings){
            String farmerName = userService.getUserById(li.getFarmerId()).getName();
            allListing.add(new ListingDTO(
                    li.getListingId(),
                    li.getFarmerId(),
                    farmerName,
                    li.getTitle(),
                    li.getDescription(),
                    li.getCategory().toString(),
                    li.getPrice(),
                    li.getQuantity(),
                    li.getUnit().toString(),
                    li.getLocation(),
                    li.getImageUrl(),
                    li.getStatus().toString(),
                    li.getCreatedAt()
            ));
        }
        return allListing;
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
