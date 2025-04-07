package com.example.KrishiConnect.controller;

import com.example.KrishiConnect.dto.BuyerRequestDTO;
import com.example.KrishiConnect.model.BuyerRequests;
import com.example.KrishiConnect.service.BuyerRequestsService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authenticated")
public class BuyerRequestsController {

    @Autowired
    private BuyerRequestsService buyerRequestsService;

    @Operation(summary = "Get a buyer request by id")
    @GetMapping("/buyer-requests/{id}")
    public ResponseEntity<BuyerRequestDTO> getBuyerRequestById(@PathVariable int id) {
        return new ResponseEntity<>(buyerRequestsService.getBuyerRequestById(id), HttpStatus.OK);
    }

    @Operation(summary = "Get a list of all buyer requests")
    @GetMapping("/buyer-requests")
    public ResponseEntity<List<BuyerRequestDTO>> getAllBuyerRequests() {
        return new ResponseEntity<>(buyerRequestsService.getAllBuyerRequests(), HttpStatus.OK);
    }

    @Operation(summary = "Get a list of all buyer requests with id instead of business name")
    @GetMapping("/buyer-requests/all")
    public ResponseEntity<List<BuyerRequests>> getAllBuyerRequestsAlongWithId() {
        return new ResponseEntity<>(buyerRequestsService.getAllBuyerRequestsAlongWithId(), HttpStatus.OK);
    }
    @Operation(summary = "Get a list of all OPEN buyer requests")
    @GetMapping("/buyer-requests/open")
    public ResponseEntity<List<BuyerRequestDTO>> getAllOpenBuyerRequests() {
        return new ResponseEntity<>(buyerRequestsService.getAllOpenBuyerRequests(), HttpStatus.OK);
    }

    @Operation(summary = "Get a list of all CLOSED buyer requests")
    @GetMapping("/buyer-requests/closed")
    public ResponseEntity<List<BuyerRequestDTO>> getAllClosedBuyerRequests() {
        return new ResponseEntity<>(buyerRequestsService.getAllClosedBuyerRequests(), HttpStatus.OK);
    }

    @Operation(summary = "add a buyer request")
    @PostMapping("/buyer-requests")
    public ResponseEntity<BuyerRequests> addBuyerRequest(@RequestBody BuyerRequests buyerRequest) {
        return new ResponseEntity<>(buyerRequestsService.addBuyerRequest(buyerRequest), HttpStatus.CREATED);
    }

    @Operation(summary = "get buyer request of a specific user")
    @GetMapping("/buyer-requests/business/{businessId}")
    public ResponseEntity<List<BuyerRequests>> getAllBuyerRequestsFromBusinessId(@PathVariable int businessId) {
        List<BuyerRequests> list = buyerRequestsService.getAllBuyerRequestFromBusinessId(businessId);
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(list,HttpStatus.OK);
    }

}
