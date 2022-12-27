package com.mtit.microservice.documentservice.documentservice.repository;

import com.mtit.microservice.documentservice.documentservice.util.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepositroy extends JpaRepository<Claim, Long> {

}
