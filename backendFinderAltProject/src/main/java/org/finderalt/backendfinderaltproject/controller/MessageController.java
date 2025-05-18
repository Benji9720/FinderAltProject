package org.finderalt.backendfinderaltproject.controller;

import lombok.RequiredArgsConstructor;
import org.finderalt.backendfinderaltproject.dto.MessageDto;
import org.finderalt.backendfinderaltproject.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping
    public ResponseEntity<MessageDto> sendMessage(@RequestBody MessageDto dto) {
        return ResponseEntity.ok(messageService.sendMessage(dto));
    }
}
