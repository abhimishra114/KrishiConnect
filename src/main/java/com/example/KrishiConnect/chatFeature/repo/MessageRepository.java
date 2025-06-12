package com.example.KrishiConnect.chatFeature.repo;

import com.example.KrishiConnect.chatFeature.entities.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessageRepository extends JpaRepository<Messages,Integer> {

    List<Messages> findByConversationIdOrderBySentAtAsc(Integer conversationId);

    Optional<Messages> findTopByConversationIdOrderBySentAtDesc(Integer conversationId);
}
