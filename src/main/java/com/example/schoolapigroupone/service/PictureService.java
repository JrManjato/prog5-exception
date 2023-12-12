package com.example.schoolapigroupone.service;
import com.example.schoolapigroupone.model.Picture;
import com.example.schoolapigroupone.model.exception.BadFileTypeException;
import com.example.schoolapigroupone.model.exception.DuplicateFileException;
import com.example.schoolapigroupone.model.exception.FileNameInvalidException;
import com.example.schoolapigroupone.model.exception.NotAuthorizedException;
import com.example.schoolapigroupone.model.exception.SensitiveFileException;
import com.example.schoolapigroupone.repository.PictureRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Getter
@Setter
public class PictureService {

  private final PictureRepository pictureRepository;
  private final ValidationService validationService;
  public ResponseEntity<String> uploadPicture(Picture picture) {
    if (!validationService.isValidLabel(picture.getLabel())) {
      throw new SensitiveFileException();
    } else if (!validationService.isValidDirectory(picture.getDirectory())) {
      throw new NotAuthorizedException();
    } else if (!validationService.isValidFileType(picture.getExtension())) {
      throw new BadFileTypeException();
    } else if (!validationService.isValidFileName(picture.getLabel())) {
      throw new FileNameInvalidException();
    }  else if (!validationService.isNotDuplicated(picture.getBase64())) {
      throw new DuplicateFileException();
    }

    Picture savedPicture = savePicture(picture);

    if (savedPicture != null) {
      return new ResponseEntity<>("Picture uploaded successfully", HttpStatus.OK);
    } else {
      return new ResponseEntity<>("Failed to upload picture", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  public Picture savePicture(Picture picture) {
    return pictureRepository.save(picture);
  }

  public Picture getPictureById(Long id) {
    return pictureRepository.findById(id).orElse(null);
  }

}
