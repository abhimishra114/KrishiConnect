package com.example.KrishiConnect.chatFeature.service;

import com.example.KrishiConnect.chatFeature.dto.ChatMessageDTO;
import com.example.KrishiConnect.chatFeature.dto.ChatResponseDTO;
import com.example.KrishiConnect.chatFeature.entities.Messages;
import com.example.KrishiConnect.chatFeature.repo.MessageRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public ChatMessageDTO saveMessage(ChatMessageDTO dto){
        Messages message = new Messages(
                dto.getSenderId(),
                dto.getConversationId(),
                dto.getContent(),
                LocalDateTime.now()
        );
        messageRepository.save(message);
        return dto;
    }

    public List<ChatResponseDTO> getMessagesByConversationId(Integer conversationId){
        List<Messages> messages = messageRepository.findByConversationIdOrderBySentAtAsc(conversationId);
        return messages.stream()
                .map(msg -> new ChatResponseDTO(
                        msg.getSenderId(),
                        msg.getContent(),
                        msg.getSentAt()
                ))
                .collect(Collectors.toList());
    }
}
