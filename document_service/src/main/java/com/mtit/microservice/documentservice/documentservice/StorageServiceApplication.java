package com.mtit.microservice.documentservice.documentservice;

import com.mtit.microservice.documentservice.documentservice.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@CrossOrigin("*")
//@RequestMapping("/image")
public class StorageServiceApplication {

	@Autowired
	private StorageService service;

	@PostMapping("/upload")
	public ResponseEntity<List<String>> uploadImage(@RequestParam("files")List<MultipartFile> files) throws IOException {
		List<String> filename = new ArrayList<>();
		String arr[] = new String[files.size()];
		for (MultipartFile file : files) {
			String fName = StringUtils.cleanPath(file.getOriginalFilename());
			String status = service.uploadfile(file);
			filename.add(fName+ " " + status);
		}

		return ResponseEntity.status(HttpStatus.OK)
				.body(filename);
	}

	@GetMapping("/{fileName}")
	public ResponseEntity<?> downloadImage(@PathVariable String fileName) throws IOException {
		byte[] downloadFile = service.downloadFile(fileName);
		HttpHeaders headers = new HttpHeaders();
		headers.add("File-Name", fileName);
		headers.add(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=" + fileName);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("application/pdf"))
				.headers(headers)
				.body(downloadFile);
	}

	public static void main(String[] args) {



		SpringApplication.run(StorageServiceApplication.class, args);
	}



}
