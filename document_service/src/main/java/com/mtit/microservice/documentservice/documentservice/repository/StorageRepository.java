package com.mtit.microservice.documentservice.documentservice.repository;

import com.mtit.microservice.documentservice.documentservice.entity.FileData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StorageRepository extends JpaRepository<FileData, Long> {

    Optional<FileData> findByName(String name);
}
