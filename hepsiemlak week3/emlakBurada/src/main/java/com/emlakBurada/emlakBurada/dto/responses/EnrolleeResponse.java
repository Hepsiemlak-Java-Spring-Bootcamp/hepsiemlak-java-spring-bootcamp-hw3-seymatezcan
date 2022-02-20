package com.emlakBurada.emlakBurada.dto.responses;

import com.emlakBurada.emlakBurada.model.Advert;
import com.emlakBurada.emlakBurada.model.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class EnrolleeResponse {

    String enrolleeType;
    String name;
    String email;
    String enrolleePhoto;
    String enrolleeDescription;
    int countBannerOrder;
    Set<Advert> favoriteAdverts = new HashSet<Advert>();
    List<Advert> publishedAdverts = new ArrayList<Advert>();
    List<Message> messageBox;

}
