package com.example.KrishiConnect.chatFeature.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ConversationSummaryDTO {
    private int conversationId;
    private int otherUserId;
    private String otherUserName;
    private String otherUserProfilePicUrl;
    private String listingTitle; // Nullable if buyer request-based
    private LocalDateTime lastMessageTime;

    public ConversationSummaryDTO(int conversationId, int otherUserId, String otherUserName, String otherUserProfilePicUrl, String listingTitle, LocalDateTime lastMessageTime) {
        this.conversationId = conversationId;
        this.otherUserId = otherUserId;
        this.otherUserName = otherUserName;
        this.otherUserProfilePicUrl = otherUserProfilePicUrl;
        this.listingTitle = listingTitle;
        this.lastMessageTime = lastMessageTime;
    }

    public ConversationSummaryDTO() {
    }
}
