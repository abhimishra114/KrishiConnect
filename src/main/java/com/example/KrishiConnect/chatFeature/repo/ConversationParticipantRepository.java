package com.example.KrishiConnect.chatFeature.repo;

import com.example.KrishiConnect.chatFeature.entities.ConversationParticipants;
import com.example.KrishiConnect.chatFeature.entities.ConversationParticipantsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConversationParticipantRepository extends JpaRepository<ConversationParticipants, ConversationParticipantsId> {

    List<ConversationParticipants> findByUserId(Integer userId);

    List<ConversationParticipants> findByConversationId(Integer conversationId);

    Optional<ConversationParticipants> findByConversationIdAndUserIdNot(int conversationId, int userId);

}
