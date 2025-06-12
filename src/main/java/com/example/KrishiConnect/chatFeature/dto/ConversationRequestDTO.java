package com.example.KrishiConnect.chatFeature.dto;


import lombok.Data;

@Data
public class ConversationRequestDTO {
    private int senderId;
    private int receiverId;
    private Integer listingId; // nullable if not listing-based
    private Integer buyerRequestId; // nullable if not buyerRequest-based
}

