package com.emlakBurada.emlakBurada.controller;

import com.emlakBurada.emlakBurada.dto.requests.AdvertRequest;
import com.emlakBurada.emlakBurada.dto.responses.AdvertResponse;
import com.emlakBurada.emlakBurada.model.Advert;
import com.emlakBurada.emlakBurada.service.AdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Import(FeignClientProperties.FeignClientConfiguration.class)
public class AdvertsController {

    @Autowired
    AdvertService advertService;

    @PostMapping(value="/adverts")
    public ResponseEntity<AdvertResponse> createAdvert(@RequestBody AdvertRequest advertRequest){
        return new ResponseEntity<>(advertService.saveAdvert(advertRequest),HttpStatus.CREATED);

    }

    @GetMapping("/adverts/favorites/{enrolleeId}")
    public ResponseEntity<List<AdvertResponse>>getFavoritesByEnrolleeId(@PathVariable int enrolleeId){
        return new ResponseEntity<>(advertService.getFavoritesById(enrolleeId),HttpStatus.OK);
    }

    @GetMapping(value="/adverts")
    public ResponseEntity<List<AdvertResponse>> getAllAdverts(){
        return new ResponseEntity<>(advertService.getAllAdverts(),HttpStatus.OK);
    }

    @GetMapping(value="/adverts/advert/{advertId}")
    public ResponseEntity<AdvertResponse> getAdvertByAdvertId(@PathVariable int advertId){
        return new ResponseEntity<>(advertService.getAdvertByAdvertId(advertId),HttpStatus.OK);
    }
}



