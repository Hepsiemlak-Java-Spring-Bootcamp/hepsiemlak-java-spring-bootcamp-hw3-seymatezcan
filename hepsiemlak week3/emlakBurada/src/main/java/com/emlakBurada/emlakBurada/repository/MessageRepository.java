package com.emlakBurada.emlakBurada.repository;

import com.emlakBurada.emlakBurada.model.Advert;
import com.emlakBurada.emlakBurada.model.Message;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageRepository {

    List<Message> messageList=new ArrayList<>();

    public Message saveMessage(Message message){
        messageList.add(message);
        System.out.println(message.toString());
        return message;
    }

    public Message getMessageById(int messageId){
        return messageList.stream().filter(message -> message.getMessageId()==messageId).findAny().orElse(new Message());
    }

    public List<Message> fetchAllMessages(){
        return messageList;
    }
}
