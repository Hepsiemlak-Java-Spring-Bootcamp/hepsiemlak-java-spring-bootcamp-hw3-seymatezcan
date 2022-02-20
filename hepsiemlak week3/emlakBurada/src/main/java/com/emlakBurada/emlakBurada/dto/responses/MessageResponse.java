package com.emlakBurada.emlakBurada.dto.responses;

import com.emlakBurada.emlakBurada.model.Enrollee;
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
public class MessageResponse {

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
}
