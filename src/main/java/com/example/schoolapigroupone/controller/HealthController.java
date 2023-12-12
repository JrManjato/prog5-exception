package com.example.schoolapigroupone.controller;

import com.example.schoolapigroupone.model.Picture;
import com.example.schoolapigroupone.service.PictureService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class HealthController {
    private final PictureService pictureService;
    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @PostMapping("/picture")
    public ResponseEntity<String> uploadPicture(@RequestBody Picture picture) {
        // Save the picture using the PictureService
        Picture savedPicture = pictureService.savePicture(picture);

        // Check if the picture was successfully saved
        if (savedPicture != null) {
            return new ResponseEntity<>("Picture uploaded successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to upload picture", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
