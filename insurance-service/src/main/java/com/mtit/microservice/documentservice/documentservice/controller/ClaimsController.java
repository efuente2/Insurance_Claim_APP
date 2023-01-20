package com.mtit.microservice.documentservice.documentservice.controller;

import com.mtit.microservice.documentservice.documentservice.dto.ClaimsResponse;
import com.mtit.microservice.documentservice.documentservice.dto.ClaimsRequest;
import com.mtit.microservice.documentservice.documentservice.service.ClaimService;
import com.mtit.microservice.documentservice.documentservice.util.Claim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClaimsController {

    @Autowired
    private ClaimService paymentService;

    @GetMapping("/login")
    public String login(){
        return "Welcome to Claims Service";
    }

    @PostMapping("/Claim")
    @ResponseStatus(HttpStatus.CREATED)
    public void newClaim(@RequestBody ClaimsRequest paymentRequest){
            paymentService.newTransaction(paymentRequest);
    }
    
    @GetMapping("/Claim")
    @ResponseStatus(HttpStatus.OK)
    public List<Claim> getAllClaims(){
        return paymentService.getAllClaims();
    }

    @GetMapping("/Claim/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClaimsResponse getClaimById(@PathVariable("id") int id){
        return paymentService.getClaimByID(id);
    }

    @PatchMapping("/Claim/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @ResponseStatus(HttpStatus.OK)
    public Claim updateProductsByFields(@PathVariable("id") int id, @RequestBody Map<String, Object> fields){
        return paymentService.updateProductsByFields(id, fields);
    }


}
