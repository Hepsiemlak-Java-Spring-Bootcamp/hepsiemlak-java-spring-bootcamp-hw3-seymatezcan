package com.emlakBurada.emlakBurada.repository;

import com.emlakBurada.emlakBurada.model.Advert;
import com.emlakBurada.emlakBurada.model.Enrollee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EnrolleeRepository {

    private List<Enrollee> enrolleeList=new ArrayList<>();
    private List<Advert>favoritesList=new ArrayList<>();

    public List<Enrollee>fetchAllEnrollees(){
        return enrolleeList;
    }

    public Enrollee saveEnrollee(Enrollee enrollee){
        enrolleeList.add(enrollee);
        System.out.println(enrollee.toString());
        return enrollee;
    }

    public Enrollee getEnrolleeById(int enrolleeId){
        return enrolleeList.stream().filter(enrollee -> enrollee.getEnrolleeId()==enrolleeId).findAny().orElse(new Enrollee());
    }
}
