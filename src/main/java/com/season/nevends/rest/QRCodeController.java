package com.season.nevends.rest;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.season.nevends.service.S3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import static com.season.nevends.util.Constants.QR_IMAGE;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class QRCodeController {

    private final S3Service s3Service;

    @GetMapping(value = "/qrcode", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getQRCode(
        @RequestParam String text,
        @RequestParam String venueId,
        @RequestParam(defaultValue = "350") int width,
        @RequestParam(defaultValue = "350") int height) {

        log.info("Received request to create QR code for {}", venueId);

        if (StringUtils.isBlank(text) || StringUtils.isBlank(venueId)) {
            log.error("Failed to create QR code - request text/url or venuId is empty");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            log.info("Creating QR code");
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

            ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
            byte[] imageBytes = pngOutputStream.toByteArray();

            CompletableFuture.runAsync(() -> {
                log.info("Uploading QR Code for venue: {} to S3", venueId);
                String s3FileName = venueId + QR_IMAGE;
                try {
                    s3Service.uploadImage(imageBytes, s3FileName);
                    log.info("Successfully uploaded QR code for venue: {} to S3", venueId);
                } catch (IOException e) {
                    log.error("Failed to upload QR code for venue: {}", venueId, e);
                    throw new RuntimeException(e);
                }
            });

            log.info("Successfully created QR code for venue: {}", venueId);
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_PNG)
                    .body(imageBytes);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
