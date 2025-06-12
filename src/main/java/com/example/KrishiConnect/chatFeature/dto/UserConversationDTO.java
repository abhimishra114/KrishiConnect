package com.example.KrishiConnect.chatFeature.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserConversationDTO {
    private Integer conversationId;
    private Integer otherUserId;
    private String lastMessage;
    private LocalDateTime lastMessageTime;
    private Integer listingId;        // optional
    private Integer buyerRequestId;   // optional

    public UserConversationDTO(Integer conversationId, Integer otherUserId, String lastMessage, LocalDateTime lastMessageTime, Integer listingId, Integer buyerRequestId) {
        this.conversationId = conversationId;
        this.otherUserId = otherUserId;
        this.lastMessage = lastMessage;
        this.lastMessageTime = lastMessageTime;
        this.listingId = listingId;
        this.buyerRequestId = buyerRequestId;
    }

    public UserConversationDTO() {
    }
}
