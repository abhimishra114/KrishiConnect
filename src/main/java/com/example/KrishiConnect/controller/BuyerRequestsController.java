package com.example.KrishiConnect.controller;

import com.example.KrishiConnect.model.BuyerRequests;
import com.example.KrishiConnect.service.BuyerRequestsService;
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

    @GetMapping("/buyer-requests")
    public ResponseEntity<List<BuyerRequests>> getAllBuyerRequests(){
        return new ResponseEntity<>(buyerRequestsService.getAllBuyerRequests(), HttpStatus.OK);
    }

    @PostMapping("/buyer-requests")
    public ResponseEntity<BuyerRequests> addBuyerRequest(@RequestBody BuyerRequests buyerRequest){
        return new ResponseEntity<>(buyerRequestsService.addBuyerRequest(buyerRequest), HttpStatus.CREATED);
    }
}
