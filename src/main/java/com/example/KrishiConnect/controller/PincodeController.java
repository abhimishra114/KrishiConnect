package com.example.KrishiConnect.controller;

import com.example.KrishiConnect.model.PincodeResponse;
import com.example.KrishiConnect.service.PincodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/pincode")
public class PincodeController {

    private final PincodeService pincodeService;

    public PincodeController(PincodeService pincodeService) {
        this.pincodeService = pincodeService;
    }
    @GetMapping("/{pincode}")
    public Mono<PincodeResponse> getPincodeDetails(@PathVariable String pincode) {
        return pincodeService.getPincodeDetails(pincode);
    }
}
