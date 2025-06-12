package com.example.KrishiConnect.chatFeature.entities;


import java.io.Serializable;
import java.util.Objects;

public class ConversationParticipantsId implements Serializable {
    private Integer conversationId;
    private Integer userId;

    public ConversationParticipantsId() {
    }

    public ConversationParticipantsId(Integer conversationId, Integer userId) {
        this.conversationId = conversationId;
        this.userId = userId;
    }

    public Integer getConversationId() {
        return conversationId;
    }

    public void setConversationId(Integer conversationId) {
        this.conversationId = conversationId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(conversationId, userId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConversationParticipantsId that = (ConversationParticipantsId) o;
        return Objects.equals(conversationId, that.conversationId) && Objects.equals(userId, that.userId);
    }
}
