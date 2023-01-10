package com.mtit.microservice.documentservice.documentservice.service;

import com.mtit.microservice.documentservice.documentservice.dto.ClaimsResponse;
import com.mtit.microservice.documentservice.documentservice.util.Claim;
import com.mtit.microservice.documentservice.documentservice.repository.ClaimRepositroy;
import com.mtit.microservice.documentservice.documentservice.dto.ClaimsRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ClaimService {

    @Autowired
    private ClaimRepositroy claimRepositroy;
    @Autowired
    private WebClient.Builder webClient;

    public void newTransaction (ClaimsRequest paymentRequest){
        Claim claim = Claim.builder()
                .name(paymentRequest.getName())
                .email(paymentRequest.getEmail())
                .amount(paymentRequest.getAmount())
                .date(paymentRequest.getDate())
                .claimId(paymentRequest.getClaimId())
                .build();
//        var resposnce  = webClient.build().get()
//                .uri("http://localhost:9080/api/inventory/Product",
//                        uriBuilder -> uriBuilder.queryParam("id", claim.getid()).build())
//                .retrieve()
//                .bodyToMono(FileResponce[].class)
//                .block();
//
//        boolean check = false;
//        int number = Integer.parseInt(paymentRequest.getClaimId());
//
//        for (int i = 0; i< resposnce.length; i++){
//            if(resposnce[i].getId() == number){
//                check = true;
//            }
//        }

            claimRepositroy.save(claim);
            log.info("Claim " + claim.getid() + " is saved");

//        else {
//            log.info("Claim was not successfully saved");
//        }
//        paymentRepositroy.save(payment);
//           log.info("Claim " + payment.getid() + " is saved");
    }

    public List<ClaimsResponse> getAllClaims(){
        List<Claim> paymentList = claimRepositroy.findAll();

        return paymentList.stream().map(this::mapToClaimResponse).toList();
    }

    private ClaimsResponse mapToClaimResponse(Claim payment) {
        return ClaimsResponse.builder()
                .id(payment.getid())
                .name(payment.getName())
                .email(payment.getEmail())
                .amount(payment.getAmount())
                .date(payment.getDate())
                .claimId(payment.getClaimId())
                .build();
    }

    public ClaimsResponse getClaimByID(String id){
        int finalId = Integer.parseInt(id);
        Optional<Claim> paymentList = claimRepositroy.findById((long)finalId);
        return (ClaimsResponse) paymentList.stream().map(this::mapToClaimResponse).toList();
    }

}
