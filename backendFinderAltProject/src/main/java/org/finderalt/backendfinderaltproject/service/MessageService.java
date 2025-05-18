package org.finderalt.backendfinderaltproject.service;

import lombok.RequiredArgsConstructor;
import org.finderalt.backendfinderaltproject.dto.MessageDto;
import org.finderalt.backendfinderaltproject.model.Message;
import org.finderalt.backendfinderaltproject.model.User;
import org.finderalt.backendfinderaltproject.repository.MessageRepository;
import org.finderalt.backendfinderaltproject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    public MessageDto sendMessage(MessageDto dto) {
        Optional<User> sender = userRepository.findById(dto.getSenderId());
        Optional<User> receiver = userRepository.findById(dto.getReceiverId());

        if (sender.isEmpty() || receiver.isEmpty()) return null;

        Message msg = Message.builder()
                .sender(sender.get())
                .receiver(receiver.get())
                .content(dto.getContent())
                .sentAt(LocalDateTime.now())
                .build();

        return toDto(messageRepository.save(msg));
    }

    private MessageDto toDto(Message m) {
        return MessageDto.builder()
                .id(m.getId())
                .senderId(m.getSender().getId())
                .receiverId(m.getReceiver().getId())
                .content(m.getContent())
                .sentAt(m.getSentAt())
                .build();
    }
}
