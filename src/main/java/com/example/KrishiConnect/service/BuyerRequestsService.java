package com.example.KrishiConnect.service;

import com.example.KrishiConnect.model.BuyerRequests;
import com.example.KrishiConnect.repo.BuyerRequestsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerRequestsService {

    @Autowired
    private BuyerRequestsRepo buyerRequestsRepo;

    public List<BuyerRequests> getAllBuyerRequests() {
        return buyerRequestsRepo.findAll();
    }

    public BuyerRequests addBuyerRequest(BuyerRequests buyerRequest) {
        return buyerRequestsRepo.save(buyerRequest);
    }

    public BuyerRequests getBuyerRequestById(int id) {
        return buyerRequestsRepo.findById(id).orElse(null);
    }
}
