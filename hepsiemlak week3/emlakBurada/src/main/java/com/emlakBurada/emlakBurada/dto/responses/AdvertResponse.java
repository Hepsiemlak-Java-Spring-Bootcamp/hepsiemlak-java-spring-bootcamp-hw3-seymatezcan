package com.emlakBurada.emlakBurada.dto.responses;

import com.emlakBurada.emlakBurada.model.Enrollee;
import com.emlakBurada.emlakBurada.model.RealEstate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AdvertResponse {

    int advertId;
    int enrolleeId;
    RealEstate realEstate;
    String advertTitle;
    Enrollee enrollee;
    String [] photoList=new String[5];
    BigDecimal price;
    Boolean isForegrounding;
    Boolean isResearched;
    Date publishedDate;
    Boolean isActive;

}
