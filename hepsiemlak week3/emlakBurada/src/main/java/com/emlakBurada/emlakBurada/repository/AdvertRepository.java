package com.emlakBurada.emlakBurada.repository;

import com.emlakBurada.emlakBurada.client.request.BannerRequest;
import com.emlakBurada.emlakBurada.model.Advert;
import com.emlakBurada.emlakBurada.model.Enrollee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AdvertRepository {

    private static List<Advert> advertList=new ArrayList<>();

    public Advert saveAdvert(Advert advert ){
        advertList.add(advert);
        System.out.println(advert.toString());
        return advert;

    }

    public List<Advert> fetchAllAdverts() {
        return advertList;
    }

    public Advert findAdvertByAdvertId(int advertId){
        return advertList.stream().filter(advert->advert.getAdvertId()==advertId).findAny().orElse(new Advert());

    }

    //hocam discordda bu methodu çağıran controller yapısının
    //postman' de hata verdiğini söylemiştim, request attığımızda cast hatası almıştık
    //burada bu yüzden yeni bir liste tanımladım ve repoya bu listeyi return edip hatayı giderdim
    public List<Advert> getFavoritesById(int enrolleeId){
        List<Advert> adverts=new ArrayList<>();
        adverts.add( advertList.stream().filter(advert -> advert.getEnrolleeId()==enrolleeId).findAny().orElse(new Advert()));
        return adverts;
    }

}
