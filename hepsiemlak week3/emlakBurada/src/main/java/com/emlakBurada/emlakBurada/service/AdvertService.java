package com.emlakBurada.emlakBurada.service;

import com.emlakBurada.emlakBurada.client.BannerClient;
import com.emlakBurada.emlakBurada.client.request.BannerRequest;
import com.emlakBurada.emlakBurada.client.response.BannerResponse;
import com.emlakBurada.emlakBurada.dto.requests.AdvertRequest;
import com.emlakBurada.emlakBurada.dto.responses.AdvertResponse;
import com.emlakBurada.emlakBurada.model.Advert;
import com.emlakBurada.emlakBurada.model.Enrollee;
import com.emlakBurada.emlakBurada.model.RealEstate;
import com.emlakBurada.emlakBurada.repository.AdvertRepository;
import com.emlakBurada.emlakBurada.repository.EnrolleeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdvertService {

    private static int advertId = 38164784;

    @Autowired
    BannerClient bannerClient;

    @Autowired
    private AdvertRepository advertRepository;


    public AdvertResponse saveAdvert(AdvertRequest advertRequest){
        Advert savedAdvert=advertRepository.saveAdvert(convertToAdvert(advertRequest));
        BannerRequest bannerRequest=new BannerRequest();
        ResponseEntity<BannerResponse> bannerResponse =bannerClient.saveBanner(bannerRequest);
        return convertToAdvertResponse(savedAdvert);
    }

    public List<AdvertResponse> getAllAdverts(){
        List<AdvertResponse>advertList = new ArrayList<>();
        for(Advert advert:advertRepository.fetchAllAdverts()){
            advertList.add(convertToAdvertResponse(advert));
        }
        return advertList;
    }

    private Advert convertToAdvert(AdvertRequest advertRequest){
        Advert advert=new Advert(new RealEstate(),new Enrollee(),new String[5]);
        advertId++;

        advert.setAdvertId(advertId);
        advert.setAdvertTitle(advertRequest.getAdvertTitle());
        return advert;
    }

    private AdvertResponse convertToAdvertResponse(Advert savedAdvert){
        AdvertResponse advertResponse=new AdvertResponse();
        advertResponse.setAdvertId(savedAdvert.getAdvertId());
        advertResponse.setAdvertTitle(savedAdvert.getAdvertTitle());
        advertResponse.setPrice(savedAdvert.getPrice());
        return advertResponse;
    }

    public AdvertResponse getAdvertByAdvertId(int advertId){
        Advert advert=advertRepository.findAdvertByAdvertId(advertId);
        return convertToAdvertResponse(advert);
    }

    public List<AdvertResponse> getFavoritesById(int enrolleeId){
        List<AdvertResponse> advertList=new ArrayList<>();
        for(Advert advert:advertRepository.getFavoritesById(enrolleeId)){
            advertList.add(convertToAdvertResponse(advert));
        }
        return advertList;
    }
}
