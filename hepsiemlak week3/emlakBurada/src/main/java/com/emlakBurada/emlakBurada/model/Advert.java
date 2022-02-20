package com.emlakBurada.emlakBurada.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Advert {

    int advertId;
    int enrolleeId;
    Enrollee advertOwner;
    int favoriteCount;
    RealEstate realEstate;
    String usageCase;
    String advertTitle;
    String advertDescription;
    BigDecimal price;
    Boolean isForegrounding;
    Integer seenCount;
    Date publishedDate;
    Boolean isActive;
    Boolean isResearched;
    List<String> advertPhotos=new ArrayList<String>();

    public Advert(RealEstate realEstate, Enrollee enrollee, String[] strings) {
    }
}
