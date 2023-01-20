package com.mtit.microservice.documentservice.documentservice.service;

import com.mtit.microservice.documentservice.documentservice.dto.ClaimsResponse;
import com.mtit.microservice.documentservice.documentservice.util.Claim;
import com.mtit.microservice.documentservice.documentservice.repository.ClaimRepositroy;
import com.mtit.microservice.documentservice.documentservice.dto.ClaimsRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class ClaimService {

    @Autowired
    private ClaimRepositroy claimRepositroy;
    @Autowired
    private WebClient.Builder webClient;

    public void newTransaction (ClaimsRequest paymentRequest){
        Claim claim = Claim.builder()
                //.id(paymentRequest.getId())
                .name(paymentRequest.getName())
                .email(paymentRequest.getEmail())
                .amount(paymentRequest.getAmount())
                .date(paymentRequest.getDate())
                .claimId(paymentRequest.getClaimId())
                .status(paymentRequest.getStatus())
                .build();


            claimRepositroy.save(claim);
            log.info("Claim " + claim.getId() + " is saved");

    }

    public List<Claim> getAllClaims(){
        List<Claim> paymentList = claimRepositroy.findAll();

        return paymentList;

        //return paymentList.stream().map(this::mapToClaimResponse).toList();
    }

    private ClaimsResponse mapToClaimResponse(Claim payment) {
        log.info("Claim " + payment.getId() + " was retrieved");

        return ClaimsResponse.builder()
                .id(payment.getId())
                .name(payment.getName())
                .email(payment.getEmail())
                .amount(payment.getAmount())
                .date(payment.getDate())
                .claimId(payment.getClaimId())
                .status(payment.getStatus())
                .build();
    }

    public ClaimsResponse getClaimByID(int id){
        //int finalId = Integer.parseInt(id);
        Optional<Claim> paymentList = claimRepositroy.findById(id);
        //return (ClaimsResponse) paymentList.stream().map(this::mapToClaimResponse).toList();
        return paymentList.map(this::mapToClaimResponse).orElse(null);
    }

    public Claim updateProductsByFields(int id, Map<String, Object> fields) {
        Optional<Claim> existingClaim = claimRepositroy.findById(id);
        if(existingClaim.isPresent()){
        fields.forEach((key,value) ->{
            Field field = ReflectionUtils.findField(Claim.class, key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, existingClaim.get(), value);
        });
        return claimRepositroy.save(existingClaim.get());
    }
        return null;
    }
}
