package com.example.schoolapigroupone.controller;

import com.example.schoolapigroupone.model.Picture;
import com.example.schoolapigroupone.model.exception.*;
import com.example.schoolapigroupone.model.exception.ServiceUnavailableException;
import com.example.schoolapigroupone.service.PictureService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PictureController {
  private final PictureService pictureService;

  @GetMapping("/ping")
  public String ping() {
    return "pong";
  }

  @PostMapping("/picture")
  public ResponseEntity<String> uploadPicture(@RequestBody Picture picture) {
    try {
      return pictureService.uploadPicture(picture);
    } catch (TooManyRequestException e) {
      return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
              .body(e.getHttpStatus() + ": " + e.getMessage());
    } catch (SensitiveFileException e) {
      return new ResponseEntity<>(e.getHttpStatus() + ": " + e.getMessage(), HttpStatus.BAD_REQUEST);
    } catch (NotAuthorizedException e) {
      return new ResponseEntity<>(e.getHttpStatus() + ": " + e.getMessage(), HttpStatus.FORBIDDEN);
    } catch (BadFileTypeException e) {
      return new ResponseEntity<>(e.getHttpStatus() + ": " + e.getMessage(), HttpStatus.BAD_REQUEST);
    } catch (FileNameInvalidException e) {
      return new ResponseEntity<>(e.getHttpStatus() + ": " + e.getMessage(), HttpStatus.BAD_REQUEST);
    } catch (DuplicateFileException e) {
      return new ResponseEntity<>(e.getHttpStatus() + ": " + e.getMessage(), HttpStatus.BAD_REQUEST);
    } catch (LargeFileException e) {
      return new ResponseEntity<>(e.getHttpStatus() + ": " + e.getMessage(), HttpStatus.REQUEST_HEADER_FIELDS_TOO_LARGE);
    } catch (Exception e) {
      return new ResponseEntity<>("Unexpected error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/picture/{label}")
  public ResponseEntity<?> getPictureByLabel(@PathVariable String label) throws Exception {
    Picture picture = pictureService.getPictureByLabel(label);
      try {
        return ResponseEntity.ok(picture);
      } catch (TooManyRequestException e) {
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
                .body(e.getHttpStatus() + ": " + e.getMessage());
      }catch (ForLegalReasonException e) {
        return new ResponseEntity<>(e.getHttpStatus() + ": " + e.getMessage(), HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
      } catch (NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(e.getHttpStatus() + ": " + e.getMessage());
      } catch (Exception e) {
        return new ResponseEntity<>("Unexpected error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
      }

  }

  @GetMapping("/pictures")
  public ResponseEntity<?> getPictures() {
    try {
      throw new NotImplementedException();
    } catch (TooManyRequestException e) {
      return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
              .body(e.getHttpStatus() + ": " + e.getMessage());
    }catch (NotImplementedException e) {
      return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
              .body(HttpStatus.NOT_IMPLEMENTED + ": " + e.getMessage());
    }
  }
  @DeleteMapping("/pictures/{id}")
  public ResponseEntity<?> deletePictureById (@PathVariable Long id){
    try {
      pictureService.deletePictureById(id);
      return ResponseEntity.ok("Picture with ID " + id + " has been deleted.");
    } catch (ServiceUnavailableException e) {
      return new ResponseEntity<>(e.getHttpStatus() + ": " + e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
    }
  }

}
