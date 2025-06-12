package com.example.KrishiConnect.chatFeature.dto;

import lombok.Data;

@Data
public class ConversationResponseDTO {
    private int conversationId;

    public ConversationResponseDTO(int conversationId) {
        this.conversationId = conversationId;
    }
}
