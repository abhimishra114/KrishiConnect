package com.example.KrishiConnect.chatFeature.repo;

import com.example.KrishiConnect.chatFeature.entities.Conversations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConversationRepository extends JpaRepository<Conversations, Integer> {


    @Query("SELECT c FROM Conversations c JOIN ConversationParticipants cp1 ON cp1.conversationId = c.conversationId " +
            "JOIN ConversationParticipants cp2 ON cp2.conversationId = c.conversationId " +
            "WHERE c.listingId = :listingId AND cp1.userId = :senderId AND cp2.userId = :receiverId")
    Optional<Conversations> findByListingIdAndUsers(int listingId, int senderId, int receiverId);

    @Query("SELECT c FROM Conversations c JOIN ConversationParticipants cp1 ON cp1.conversationId = c.conversationId " +
            "JOIN ConversationParticipants cp2 ON cp2.conversationId = c.conversationId " +
            "WHERE c.buyerRequestId = :buyerRequestId AND cp1.userId = :senderId AND cp2.userId = :receiverId")
    Optional<Conversations> findByBuyerRequestIdAndUsers(int buyerRequestId, int senderId, int receiverId);


}
