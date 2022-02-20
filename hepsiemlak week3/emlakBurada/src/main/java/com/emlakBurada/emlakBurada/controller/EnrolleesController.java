package com.emlakBurada.emlakBurada.controller;

import com.emlakBurada.emlakBurada.dto.requests.EnrolleeRequest;
import com.emlakBurada.emlakBurada.dto.responses.EnrolleeResponse;
import com.emlakBurada.emlakBurada.service.EnrolleeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EnrolleesController {

    @Autowired
    private EnrolleeService enrolleeService;

    @GetMapping(value="/enrollees")
    public ResponseEntity<List<EnrolleeResponse>> getAllEnrollees(){
        return new ResponseEntity<>(enrolleeService.getAllEnrollees(), HttpStatus.OK);
    }

    @PostMapping(value="/enrollees")
    ResponseEntity<EnrolleeResponse> createEnrollee(@RequestBody EnrolleeRequest enrolleeRequest){
        return new ResponseEntity<>(enrolleeService.saveEnrollee(enrolleeRequest),HttpStatus.CREATED);
    }

    @GetMapping(value="/enrollee")
    ResponseEntity<EnrolleeResponse> getEnrolleeById(@RequestBody int enrolleeId){
        return new ResponseEntity<>(enrolleeService.getEnrolleeById(enrolleeId),HttpStatus.OK);
    }
}
