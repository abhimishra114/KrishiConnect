package com.example.KrishiConnect.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.KrishiConnect.dto.ListingDTO;
import com.example.KrishiConnect.model.Listings;
import com.example.KrishiConnect.service.ListingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/authenticated")
public class ListingController {

    private static final Logger logger = LoggerFactory.getLogger(ListingController.class);

    private final ListingService listingService;
    private final Cloudinary cloudinary;

    public ListingController(ListingService listingService, Cloudinary cloudinary) {
        this.listingService = listingService;
        this.cloudinary = cloudinary;
    }

    @Operation(summary = "create a listing with image")
    @PostMapping("/listing")
    public ResponseEntity<Listings> createListing(@RequestPart("listing") String listing,
                                                  @RequestPart("imageUrl") MultipartFile imageUrl) {


        try {
            Listings jsonListing = new ObjectMapper().readValue(listing,Listings.class);
            Map uploadResult = cloudinary.uploader().upload(imageUrl.getBytes(), ObjectUtils.emptyMap());
            String savedImageUrl = uploadResult.get("secure_url").toString();
            jsonListing.setImageUrl(savedImageUrl);

            return new ResponseEntity<>(listingService.createListing(jsonListing), HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Error creating a listing: ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "get all listings in the db")
    @GetMapping("/listing")
    public ResponseEntity<List<ListingDTO>> getAllListings(){
        return new ResponseEntity<>(listingService.getAllListings(),HttpStatus.OK);
    }

    @Operation(summary = "get listings farmer id, to be used for individual farmers")
    @GetMapping("/listing/farmer/{farmerId}")
    public ResponseEntity<List<Listings>> getListingByFarmerId(@PathVariable int farmerId){
        return new ResponseEntity<>(listingService.getListingByFarmerId(farmerId),HttpStatus.OK);
    }

    @Operation(summary = "get listings by id primary key")
    @GetMapping("/listing/{listingId}")
    public ResponseEntity<Listings> getListingById(@PathVariable int listingId){
        return new ResponseEntity<>(listingService.getListingById(listingId),HttpStatus.OK);
    }

    @Operation(summary = "search for a listings with related keywords")
    @GetMapping("/listing/search/{keyword}")
    public ResponseEntity<?> searchListings(@PathVariable String keyword){
        System.out.println("Searching for keyword: " + keyword);
        if (keyword.length() < 3){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Keyword must be at least 3 characters long");
        }
        return ResponseEntity.ok(listingService.searchListings(keyword));
    }
}
