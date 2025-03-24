package com.example.KrishiConnect.controller;

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
    public ResponseEntity<BuyerRequests> getBuyerRequestById(@PathVariable int id){
        return new ResponseEntity<>(buyerRequestsService.getBuyerRequestById(id), HttpStatus.OK);
    }

    @Operation(summary = "Get a list of all buyer requests")
    @GetMapping("/buyer-requests")
    public ResponseEntity<List<BuyerRequests>> getAllBuyerRequests(){
        return new ResponseEntity<>(buyerRequestsService.getAllBuyerRequests(), HttpStatus.OK);
    }

    @Operation(summary = "add a buyer request")
    @PostMapping("/buyer-requests")
    public ResponseEntity<BuyerRequests> addBuyerRequest(@RequestBody BuyerRequests buyerRequest){
        return new ResponseEntity<>(buyerRequestsService.addBuyerRequest(buyerRequest), HttpStatus.CREATED);
    }
}
