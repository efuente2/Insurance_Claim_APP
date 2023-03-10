package com.mtit.microservice.documentservice.documentservice.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payment")
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "amount")
    private String amount;

    @Column(name = "date")
    private String date;

    @Column(name = "claimId")
    public String claimId;

    @Column(name = "name")
    public String name;

    @Column(name = "email")
    public String email;

    @Column(name = "status")
    public String status;

    //    @Column(name = "UUID")
    //    private int UUID;

    public String getStatus() {return status;}

    //public int getUUID() {return UUID;}

    public void setStatus(String status) {this.status = status;}

    public String getName() {return name;}

    public String getEmail() {return email;}

    public int getId(){return id;}

    public  String getAmount(){
        return amount;
    }

    public String getDate(){
        return date;
    }

    public String getClaimId(){return claimId;}



}
