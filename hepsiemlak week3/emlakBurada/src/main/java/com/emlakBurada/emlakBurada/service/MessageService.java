package com.emlakBurada.emlakBurada.service;

import com.emlakBurada.emlakBurada.dto.requests.MessageRequest;
import com.emlakBurada.emlakBurada.dto.responses.MessageResponse;
import com.emlakBurada.emlakBurada.model.Enrollee;
import com.emlakBurada.emlakBurada.model.Message;
import com.emlakBurada.emlakBurada.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    private static int messageId = 38164784;

    public MessageResponse saveMessage(MessageRequest messageRequest){
        Message message=messageRepository.saveMessage(convertToMessage(messageRequest));
        return convertToMessageReponse(message);
    }

    public Message convertToMessage(MessageRequest messageRequest){
        Message message=new Message();
        message.setMessageContent(messageRequest.getMessageContent());
        message.setMessageTitle(messageRequest.getMessageTitle());
        return message;
    }

    public MessageResponse convertToMessageReponse(Message message){
        MessageResponse messageResponse=new MessageResponse();
        messageResponse.setMessageContent(message.getMessageContent());
        messageResponse.setMessageTitle(message.getMessageTitle());
        return messageResponse;
    }

    public MessageResponse getMessageById(int messageId){
        Message message=messageRepository.getMessageById(messageId);
        return convertToMessageReponse(message);
    }

    public List<MessageResponse> getAllMessages(){
        List<MessageResponse> messageList=new ArrayList<>();
        for(Message message:messageRepository.fetchAllMessages()){
            messageList.add(convertToMessageReponse(message));
        }
        return messageList;
    }
}
