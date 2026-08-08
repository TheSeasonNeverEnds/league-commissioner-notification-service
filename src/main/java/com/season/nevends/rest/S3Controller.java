package com.season.nevends.rest;

import com.season.nevends.service.S3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/s3")
@RequiredArgsConstructor
@Slf4j
public class S3Controller {

    private final S3Service s3Service;

    /*
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        return ResponseEntity.ok(s3Service.uploadFile(file));
    }


    @GetMapping("/download/{fileName}")
    public ResponseEntity<byte[]> downloadFile(@RequestParam String fileName) {
        log.info("Retrieving file {}", fileName);
        return ResponseEntity.ok(s3Service.downloadFile(fileName));
    }


    @GetMapping("/list")
    public ResponseEntity<List<String>> listFiles() {
        return ResponseEntity.ok(s3Service.listFiles());
    }


    @DeleteMapping("/delete/{fileName}")
    public ResponseEntity<String> deleteFile(@PathVariable String fileName) {
        return ResponseEntity.ok(s3Service.deleteFile(fileName));
    }

     */

    @GetMapping("/download/image")
    public ResponseEntity<byte[]> downloadImage(@RequestParam String fileName) {
        try {

            ResponseBytes<GetObjectResponse> s3ObjectBytes = s3Service.getImageObject(fileName);
            byte[] data = s3ObjectBytes.asByteArray();


            String contentType = s3ObjectBytes.response().contentType();
            MediaType mediaType = MediaType.parseMediaType(contentType != null ? contentType : "image/png");

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(mediaType);
            headers.setContentLength(data.length);

            return new ResponseEntity<>(data, headers, HttpStatus.OK);

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
