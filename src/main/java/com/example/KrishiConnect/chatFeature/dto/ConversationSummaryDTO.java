package com.example.KrishiConnect.chatFeature.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ConversationSummaryDTO {
    private int conversationId;
    private int otherUserId;
    private String otherUserName;
    private String otherUserProfilePicUrl;
//    private String listingTitle; // Nullable if buyer request-based
    private Integer listingId;
    private Integer buyerRequestId;
    private LocalDateTime lastMessageTime;

    public ConversationSummaryDTO(int conversationId, int otherUserId, String otherUserName, String otherUserProfilePicUrl, Integer listingId, Integer buyerRequestId, LocalDateTime lastMessageTime) {
        this.conversationId = conversationId;
        this.otherUserId = otherUserId;
        this.otherUserName = otherUserName;
        this.otherUserProfilePicUrl = otherUserProfilePicUrl;
        this.listingId = listingId;
        this.buyerRequestId = buyerRequestId;
        this.lastMessageTime = lastMessageTime;
    }

    public ConversationSummaryDTO() {
    }
}
