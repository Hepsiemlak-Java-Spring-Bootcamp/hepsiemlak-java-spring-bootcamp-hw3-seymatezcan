package com.emlakBurada.emlakBurada.controller;

import com.emlakBurada.emlakBurada.dto.requests.MessageRequest;
import com.emlakBurada.emlakBurada.dto.responses.MessageResponse;
import com.emlakBurada.emlakBurada.model.Message;
import com.emlakBurada.emlakBurada.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessagesController {

    @Autowired
    private MessageService messageService;

    @PostMapping(value="/messages")
    ResponseEntity<MessageResponse> createMessage(@RequestBody MessageRequest messageRequest){
        return new ResponseEntity<>(messageService.saveMessage(messageRequest),HttpStatus.CREATED);
    }

    @GetMapping("/messages/{messageId}")
    MessageResponse getMessageByMessageId(@PathVariable int messageId){
        return messageService.getMessageById(messageId);
    }

    @GetMapping(value="/messages-all")
    ResponseEntity<List> getAllMessages(){
        return new ResponseEntity<>(messageService.getAllMessages(), HttpStatus.OK);
    }
}
