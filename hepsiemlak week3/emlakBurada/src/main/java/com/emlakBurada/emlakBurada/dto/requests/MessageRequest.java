package com.emlakBurada.emlakBurada.dto.requests;

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
public class MessageRequest {

    String messageTitle;
    String messageContent;

}
