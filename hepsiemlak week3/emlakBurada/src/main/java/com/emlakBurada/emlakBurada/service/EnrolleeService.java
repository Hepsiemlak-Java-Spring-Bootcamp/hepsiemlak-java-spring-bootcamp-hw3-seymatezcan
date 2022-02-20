package com.emlakBurada.emlakBurada.service;

import com.emlakBurada.emlakBurada.dto.requests.EnrolleeRequest;
import com.emlakBurada.emlakBurada.dto.responses.EnrolleeResponse;
import com.emlakBurada.emlakBurada.model.Advert;
import com.emlakBurada.emlakBurada.model.Enrollee;
import com.emlakBurada.emlakBurada.repository.AdvertRepository;
import com.emlakBurada.emlakBurada.repository.EnrolleeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class EnrolleeService {
    private static int enrolleeId = 38164784;

    @Autowired
    EnrolleeRepository enrolleeRepository;

    @Autowired
    private AdvertRepository advertRepository;

    public List<EnrolleeResponse> getAllEnrollees(){
        List<EnrolleeResponse>enrolleeList=new ArrayList<>();
        for(Enrollee enrollee:enrolleeRepository.fetchAllEnrollees()){
            enrolleeList.add(convertToEnrolleeResponse(enrollee));
        }
        return enrolleeList;
    }

    private EnrolleeResponse convertToEnrolleeResponse(Enrollee savedEnrollee){
        EnrolleeResponse enrolleeResponse=new EnrolleeResponse();
        enrolleeResponse.setEmail(enrolleeResponse.getEmail());
        return enrolleeResponse;

    }

    public EnrolleeResponse saveEnrollee(EnrolleeRequest enrolleeRequest){
        Enrollee savedEnrollee=enrolleeRepository.saveEnrollee(convertToEnrollee(enrolleeRequest));
        return convertToEnrolleeResponse(savedEnrollee);
    }

    private Enrollee convertToEnrollee(EnrolleeRequest request){
        Enrollee enrollee=new Enrollee(new Enrollee(),new String[1]);
        enrolleeId++;
        enrollee.setEnrolleePhoto(request.getEnrolleePhoto());
        enrollee.setEmail(request.getEmail());
        enrollee.setEnrolleeDescription(request.getEnrolleeDescription());
        return enrollee;
    }

    public List<Advert> getAllFavorites(int enrolleeId){
        Enrollee enrollee=enrolleeRepository.getEnrolleeById(enrolleeId);
        return (List<Advert>) enrollee.getFavoriteAdverts();
    }

    public EnrolleeResponse getEnrolleeById(int enrolleeId){
        Enrollee enrollee=enrolleeRepository.getEnrolleeById(enrolleeId);
        return convertToEnrolleeResponse(enrollee);
    }


}
