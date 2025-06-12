package com.example.KrishiConnect.chatFeature.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer messageId;
    private Integer conversationId;
    private Integer senderId;
    private String content;
    private LocalDateTime sentAt;

    public Messages() {
    }

    public Messages(Integer senderId, Integer conversationId, String content, LocalDateTime sentAt) {
        this.senderId = senderId;
        this.conversationId = conversationId;
        this.content = content;
        this.sentAt = sentAt;
    }
}
