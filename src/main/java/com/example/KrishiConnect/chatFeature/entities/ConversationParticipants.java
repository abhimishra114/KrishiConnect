package com.example.KrishiConnect.chatFeature.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@IdClass(ConversationParticipantsId.class)
public class ConversationParticipants {
    @Id
    @Column(name = "conversation_id")
    private Integer conversationId;

    @Id
    @Column(name = "user_id")
    private Integer userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conversation_id", insertable = false, updatable = false)
    private Conversations conversation;

    // getters and setters
    public Conversations getConversation() {
        return conversation;
    }

    public void setConversation(Conversations conversation) {
        this.conversation = conversation;
    }

}

