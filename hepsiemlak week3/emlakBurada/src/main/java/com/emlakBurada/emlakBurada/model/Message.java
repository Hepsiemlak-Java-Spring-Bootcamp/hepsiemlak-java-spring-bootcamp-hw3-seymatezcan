package com.emlakBurada.emlakBurada.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Message {

    int messageId;
    Enrollee sendBy;
    Enrollee sendTo;
    String messageTitle;
    String messageContent;
    Date date;
    Time time;
    Boolean isSeen;
    Date seenTime;
    Date seenDate;

    public Message(Enrollee enrollee, Enrollee enrollee1, String s, String s1) {
    }
}
