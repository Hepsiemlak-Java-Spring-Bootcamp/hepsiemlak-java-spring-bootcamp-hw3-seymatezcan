package com.emlakBurada.emlakBurada.client.response;

import com.emlakBurada.emlakBurada.client.request.AddressRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class BannerResponse {

    private int advertId;
    private String phoneNumber;
    private int total;
    private AddressRequest address;
}
