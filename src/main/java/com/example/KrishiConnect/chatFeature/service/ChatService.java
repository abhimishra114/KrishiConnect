package com.example.KrishiConnect.chatFeature.service;

import com.example.KrishiConnect.chatFeature.dto.ConversationRequestDTO;
import com.example.KrishiConnect.chatFeature.dto.ConversationSummaryDTO;
import com.example.KrishiConnect.chatFeature.dto.UserConversationDTO;
import com.example.KrishiConnect.chatFeature.entities.ConversationParticipants;
import com.example.KrishiConnect.chatFeature.entities.Conversations;
import com.example.KrishiConnect.chatFeature.entities.Messages;
import com.example.KrishiConnect.chatFeature.repo.ConversationParticipantRepository;
import com.example.KrishiConnect.chatFeature.repo.ConversationRepository;
import com.example.KrishiConnect.chatFeature.repo.MessageRepository;
import com.example.KrishiConnect.model.Listings;
import com.example.KrishiConnect.model.Users;
import com.example.KrishiConnect.repo.ListingRepo;
import com.example.KrishiConnect.repo.UserRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChatService {
    private final ConversationRepository conversationRepository;
    private final ConversationParticipantRepository conversationParticipantRepository;
    private final MessageRepository messageRepository;
    private final UserRepo userRepo;
    private final ListingRepo listingRepo;

    public ChatService(ConversationRepository conversationRepository, ConversationParticipantRepository conversationParticipantRepository,
                       MessageRepository messageRepository,
                       UserRepo userRepo, ListingRepo listingRepo) {
        this.conversationRepository = conversationRepository;
        this.conversationParticipantRepository = conversationParticipantRepository;
        this.messageRepository = messageRepository;
        this.userRepo = userRepo;
        this.listingRepo = listingRepo;
    }

    public int startConversation(ConversationRequestDTO dto) {

        // check if any conversation exists
        Optional<Conversations> byListingIdAndUsers = Optional.empty();
        Optional<Conversations> byBuyerRequestIdAndUsers = Optional.empty();

        if (dto.getListingId() != null) {
            byListingIdAndUsers = conversationRepository.findByListingIdAndUsers(
                    dto.getListingId(), dto.getSenderId(), dto.getReceiverId()
            );
        }

        if (dto.getBuyerRequestId() != null) {
            byBuyerRequestIdAndUsers = conversationRepository.findByBuyerRequestIdAndUsers(
                    dto.getBuyerRequestId(), dto.getSenderId(), dto.getReceiverId()
            );
        }

        if (byListingIdAndUsers.isPresent()) {
            return byListingIdAndUsers.get().getConversationId();
        }
        if (byBuyerRequestIdAndUsers.isPresent()) {
            return byBuyerRequestIdAndUsers.get().getConversationId();
        }

        // create a conversation
        Conversations conversation = new Conversations(
                dto.getListingId(),
                dto.getBuyerRequestId(),
                LocalDateTime.now()
        );
        conversation = conversationRepository.save(conversation); // get id from this


        System.out.println("Saved conversation ID: " + conversation.getConversationId());


        // save both participants
        ConversationParticipants sender = new ConversationParticipants();
        sender.setConversationId(conversation.getConversationId());
        sender.setUserId(dto.getSenderId());

        ConversationParticipants receiver = new ConversationParticipants();
        receiver.setConversationId(conversation.getConversationId());
        receiver.setUserId(dto.getReceiverId());


        conversationParticipantRepository.save(sender);
        conversationParticipantRepository.save(receiver);

        return conversation.getConversationId();

    }

    public List<UserConversationDTO> getAllConversationsForUser(Integer userId) {
        List<ConversationParticipants> participantEntries =
                conversationParticipantRepository.findByUserId(userId);

        List<UserConversationDTO> conversations = new ArrayList<>();

        for (ConversationParticipants cp : participantEntries) {
            Integer conversationId = cp.getConversationId();

            Conversations conversation = conversationRepository.findById(conversationId)
                    .orElse(null);
            if (conversation == null) continue;

            // Get other participant
            Integer otherUserId = conversationParticipantRepository.findByConversationId(conversationId).stream()
                    .map(ConversationParticipants::getUserId)
                    .filter(id -> !id.equals(userId))
                    .findFirst().orElse(null);

            // Get latest message
            Messages latestMessage = (Messages) messageRepository.findTopByConversationIdOrderBySentAtDesc(conversationId)
                    .orElse(null);

            UserConversationDTO dto = new UserConversationDTO(
                    conversationId,
                    otherUserId,
                    latestMessage != null ? latestMessage.getContent() : null,
                    latestMessage != null ? latestMessage.getSentAt() : null,
                    conversation.getListingId(),
                    conversation.getBuyerRequestId()
            );

            conversations.add(dto);
        }

        return conversations;
    }

    public List<ConversationSummaryDTO> getConversationsForUser(int userId) {
        List<ConversationParticipants> participationList = conversationParticipantRepository.findByUserId(userId);
        List<ConversationSummaryDTO> summaries = new ArrayList<>();

        for (ConversationParticipants cp : participationList) {
            Conversations convo = cp.getConversation();

            // Get other participant
            Optional<ConversationParticipants> other = conversationParticipantRepository
                    .findByConversationIdAndUserIdNot(convo.getConversationId(), userId);
            if (other.isEmpty()) continue;

            Users otherUser = userRepo.findById(other.get().getUserId()).orElse(null);
            String listingTitle = null;
            if (convo.getListingId() != null) {
                listingTitle = listingRepo.findById(convo.getListingId())
                        .map(Listings::getTitle)
                        .orElse(null);
            }

            // Optional: fetch latest message timestamp
            LocalDateTime lastMessageTime = messageRepository
                    .findTopByConversationIdOrderBySentAtDesc(convo.getConversationId())
                    .map(Messages::getSentAt)
                    .orElse(convo.getCreatedAt());

            summaries.add(new ConversationSummaryDTO(
                    convo.getConversationId(),
                    otherUser.getUserId(),
                    otherUser.getName(),
                    otherUser.getProfilePicture(),
                    listingTitle,
                    lastMessageTime
            ));
        }

        return summaries;
    }


}
