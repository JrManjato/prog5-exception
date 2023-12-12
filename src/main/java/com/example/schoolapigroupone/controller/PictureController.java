package com.example.schoolapigroupone.controller;

import com.example.schoolapigroupone.model.Picture;
import com.example.schoolapigroupone.model.exception.SensitiveFileException;
import com.example.schoolapigroupone.service.PictureService;
import com.example.schoolapigroupone.service.ValidationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class PictureController {
    private final PictureService pictureService;
    private final ValidationService validationService;
    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @PostMapping("/picture")
    public ResponseEntity<String> uploadPicture(@RequestBody Picture picture) {
        if (!validationService.isValidLabel(picture.getLabel())) {
            throw new SensitiveFileException();
        }

        Picture savedPicture = pictureService.savePicture(picture);

        if (savedPicture != null) {
            return new ResponseEntity<>("Picture uploaded successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to upload picture", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
