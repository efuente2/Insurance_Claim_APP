package com.mtit.microservice.documentservice.documentservice.controller;

import com.mtit.microservice.documentservice.documentservice.dto.ClaimsResponse;
import com.mtit.microservice.documentservice.documentservice.dto.ClaimsRequest;
import com.mtit.microservice.documentservice.documentservice.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ClaimsController {

    @Autowired
    private ClaimService paymentService;

    @PostMapping("/Claim")
    @ResponseStatus(HttpStatus.CREATED)
    public void newClaim(@RequestBody ClaimsRequest paymentRequest){
        paymentService.newTransaction(paymentRequest);
    }
    
    @GetMapping("/Claim")
    @ResponseStatus(HttpStatus.OK)
    public List<ClaimsResponse> getAllClaims(){
        return paymentService.getAllClaims();
    }

    @GetMapping("/Claim/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClaimsResponse getClaimById(@PathVariable("id") String id){
        return paymentService.getClaimByID(id);
    }


}
