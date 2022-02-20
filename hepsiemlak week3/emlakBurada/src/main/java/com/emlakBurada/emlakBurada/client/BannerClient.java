package com.emlakBurada.emlakBurada.client;

import com.emlakBurada.emlakBurada.client.request.BannerRequest;
import com.emlakBurada.emlakBurada.client.response.BannerResponse;
import com.emlakBurada.emlakBurada.model.Advert;
import feign.RequestLine;
import org.springframework.boot.Banner;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@FeignClient(value="feign-client",url="http://localhost:8081")
public interface BannerClient {

    @PostMapping(value="/banners")
    ResponseEntity<BannerResponse> saveBanner(@RequestBody BannerRequest request);

}
