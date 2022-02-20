package com.emlakBurada.emlakBurada.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Enrollee {

    int enrolleeId;
    String enrolleeType;
    String name;
    String email;
    String enrolleePhoto;
    String enrolleeDescription;
    int countBannerOrder;
    Set<Advert> favoriteAdverts = new HashSet<Advert>();
    List<Advert> publishedAdverts = new ArrayList<Advert>();
    List<Message> messageBox;

    public Enrollee(Enrollee enrollee) {
    }

    public Enrollee(Enrollee enrollee, String[] strings) {
    }
}
