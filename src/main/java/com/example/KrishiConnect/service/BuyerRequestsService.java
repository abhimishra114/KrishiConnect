package com.example.KrishiConnect.service;

import com.example.KrishiConnect.dto.BuyerRequestDTO;
import com.example.KrishiConnect.model.BuyerRequests;
import com.example.KrishiConnect.model.Users;
import com.example.KrishiConnect.repo.BuyerRequestsRepo;
import com.example.KrishiConnect.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuyerRequestsService {

    @Autowired
    private BuyerRequestsRepo buyerRequestsRepo;
    @Autowired
    private UserRepo usersRepository;

    public List<BuyerRequestDTO> getAllBuyerRequests() {
        List<BuyerRequests> requests = buyerRequestsRepo.findAll();
        return requests.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<BuyerRequestDTO> getAllOpenBuyerRequests() {
        List<BuyerRequests> requests = buyerRequestsRepo.findByStatus(BuyerRequests.Status.OPEN);
        return requests.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }
    public List<BuyerRequestDTO> getAllClosedBuyerRequests() {
        List<BuyerRequests> requests = buyerRequestsRepo.findByStatus(BuyerRequests.Status.CLOSED);
        return requests.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public BuyerRequestDTO getBuyerRequestById(int id) {
        BuyerRequests request = buyerRequestsRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Buyer request not found"));
        return mapToDTO(request);
    }

    public BuyerRequests addBuyerRequest(BuyerRequests buyerRequest) {
        return buyerRequestsRepo.save(buyerRequest);
    }

    private BuyerRequestDTO mapToDTO(BuyerRequests request) {
        Users user = usersRepository.findById(request.getBusinessId())
                .orElseThrow(() -> new RuntimeException("Business user not found"));

        BuyerRequestDTO dto = new BuyerRequestDTO();
        dto.setRequestId(request.getRequestId());
        dto.setBusinessName(user.getName());
        dto.setTitle(request.getTitle());
        dto.setDescription(request.getDescription());
        dto.setCategory(request.getCategory());
        dto.setRequiredQuantity(request.getRequiredQuantity());
        dto.setUnit(request.getUnit());
        dto.setMaxPrice(request.getMaxPrice());
        dto.setLocation(request.getLocation());
        dto.setStatus(request.getStatus());
        dto.setCreatedAt(request.getCreatedAt());
        return dto;
    }

    public List<BuyerRequestDTO> getAllBuyerRequestFromBusinessId(int businessId) {
        List<BuyerRequests> request = buyerRequestsRepo.findAllByBusinessId(businessId);
        return request.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<BuyerRequests> getAllBuyerRequestsAlongWithId() {
        return buyerRequestsRepo.findAll();
    }
}
