package com.example.KrishiConnect.chatFeature.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChatResponseDTO {
    private Integer senderId;
    private String content;
    private LocalDateTime sentAt;

    public ChatResponseDTO(Integer senderId, String content, LocalDateTime sentAt) {
        this.senderId = senderId;
        this.content = content;
        this.sentAt = sentAt;
    }
}
