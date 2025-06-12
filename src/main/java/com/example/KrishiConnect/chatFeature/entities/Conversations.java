package com.example.KrishiConnect.chatFeature.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Conversations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int conversationId;
    private Integer listingId;
    private Integer buyerRequestId;
    private LocalDateTime createdAt;


    public Conversations(Integer listingId, Integer buyerRequestId, LocalDateTime createdAt) {
        this.listingId = listingId;
        this.buyerRequestId = buyerRequestId;
        this.createdAt = createdAt;
    }

    public Conversations() {
    }
}
