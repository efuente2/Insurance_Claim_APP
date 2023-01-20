package com.mtit.microservice.documentservice.documentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClaimsRequest {
    private int id;
    private String name;
    private String email;
    private String amount;
    private String date;
    private String claimId;
    private String status;
}
