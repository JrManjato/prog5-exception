package com.example.schoolapigroupone.controller;

import com.example.schoolapigroupone.model.Picture;
import com.example.schoolapigroupone.model.exception.BadFileTypeException;
import com.example.schoolapigroupone.model.exception.DuplicateFileException;
import com.example.schoolapigroupone.model.exception.FileNameInvalidException;
import com.example.schoolapigroupone.model.exception.NotAuthorizedException;
import com.example.schoolapigroupone.model.exception.SensitiveFileException;
import com.example.schoolapigroupone.service.PictureService;
import com.example.schoolapigroupone.service.ValidationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    try {
      return pictureService.uploadPicture(picture);
    } catch (SensitiveFileException e) {
      return new ResponseEntity<>(e.getHttpStatus() + ": " + e.getMessage(), HttpStatus.BAD_REQUEST);
    } catch (NotAuthorizedException e) {
      return new ResponseEntity<>(e.getHttpStatus() + ": " + e.getMessage(), HttpStatus.FORBIDDEN);
    } catch (BadFileTypeException e) {
      return new ResponseEntity<>(e.getHttpStatus() + ": " + e.getMessage(), HttpStatus.BAD_REQUEST);
    } catch (FileNameInvalidException e) {
      return new ResponseEntity<>(e.getHttpStatus() + ": " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }catch (DuplicateFileException e) {
      return new ResponseEntity<>(e.getHttpStatus() + ": " + e.getMessage(), HttpStatus.BAD_REQUEST);
    } catch (Exception e) {
      return new ResponseEntity<>("Unexpected error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
