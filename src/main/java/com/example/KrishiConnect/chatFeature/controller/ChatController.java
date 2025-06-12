package com.example.KrishiConnect.chatFeature.controller;

import com.example.KrishiConnect.chatFeature.dto.*;
import com.example.KrishiConnect.chatFeature.service.ChatService;
import com.example.KrishiConnect.chatFeature.service.MessageService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService chatService;
    private final MessageService messageService;

    public ChatController(ChatService chatService, MessageService messageService) {
        this.chatService = chatService;
        this.messageService = messageService;
    }

    @Operation(summary = "start a conversation")
    @PostMapping("/conversations")
    public ResponseEntity<?> startConversation(@RequestBody ConversationRequestDTO dto) {
        try {
            int conversationId = chatService.startConversation(dto);
            return ResponseEntity.ok(new ConversationResponseDTO(conversationId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Error: " + e.getMessage());
        }
    }

    @Operation(summary = "Send a chat message to a conversation (WebSocket endpoint)")
    @MessageMapping("/chat/send/{conversationId}") // from client
    @SendTo("/topic/conversations/{conversationId}") // to subscribers
    public ChatMessageDTO sendMessages(@Payload ChatMessageDTO messageDTO,
                                       @DestinationVariable Integer conversationId){
        return messageService.saveMessage(messageDTO);
    }

    @Operation(summary = "Get all messages of a conversation ")
    @GetMapping("/conversations/{conversationId}/messages")
    public ResponseEntity<List<ChatResponseDTO>> getMessages(@PathVariable Integer conversationId) {
        List<ChatResponseDTO> messages = messageService.getMessagesByConversationId(conversationId);
        return ResponseEntity.ok(messages);
    }


    @GetMapping("/users/{userId}/conversations")
    public ResponseEntity<List<UserConversationDTO>> getUserConversations(@PathVariable Integer userId) {
        List<UserConversationDTO> list = chatService.getAllConversationsForUser(userId);
        return ResponseEntity.ok(list);
    }

    @Operation(summary = "Get all conversation which as user is part of")
    @GetMapping("users/conversations/{userId}")
    public ResponseEntity<List<ConversationSummaryDTO>> getUserConversations(
            @PathVariable int userId
    ) {

        List<ConversationSummaryDTO> conversations = chatService.getConversationsForUser(userId);
        return ResponseEntity.ok(conversations);
    }

}
