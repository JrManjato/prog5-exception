package com.example.schoolapigroupone.service;
import com.example.schoolapigroupone.model.Picture;
import com.example.schoolapigroupone.repository.PictureRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Getter
@Setter
public class ValidationService {

  public boolean isValidLabel(String label) {
    return label == null || !label.toLowerCase().contains("xx");
  }

  public boolean isValidDirectory(String directory) {
    return directory != null && directory.equals("Pictures");
  }

  public boolean isValidFileType(String fileExtension) {
    if (fileExtension == null) {
      return false;
    }

    String lowerCaseExtension = fileExtension.toLowerCase();
    return List.of("png", "webp", "jpeg", "jpg", "gif", "jfif").contains(lowerCaseExtension);
  }

}
