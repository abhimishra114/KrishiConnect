package com.example.KrishiConnect.chatFeature.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
public class ChatMessageDTO {
    private Integer conversationId;
    private Integer senderId;
    private String content;



}
