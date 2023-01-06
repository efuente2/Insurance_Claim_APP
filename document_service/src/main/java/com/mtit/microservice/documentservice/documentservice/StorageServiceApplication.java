package com.mtit.microservice.documentservice.documentservice;

import com.mtit.microservice.documentservice.documentservice.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
@RestController
//@RequestMapping("/image")
public class StorageServiceApplication {

	@Autowired
	private StorageService service;

	@PostMapping("/upload")
	public ResponseEntity<?> uploadImage(@RequestParam("file")MultipartFile file) throws IOException {
		String uploadFile = service.uploadfile(file);
		return ResponseEntity.status(HttpStatus.OK)
				.body(uploadFile);
	}

	@GetMapping("/getByFileName/{fileName}")
	public ResponseEntity<?> downloadImage(@PathVariable("filename") String fileName) throws IOException {
		byte[] downloadFile = service.downloadFile(fileName);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("application/pdf"))
				.contentType(MediaType.valueOf("application/'msword'"))
				.body(downloadFile);
	}
	public static void main(String[] args) {



		SpringApplication.run(StorageServiceApplication.class, args);
	}



}
