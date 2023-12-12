package com.example.schoolapigroupone.service;
import com.example.schoolapigroupone.model.Picture;
import com.example.schoolapigroupone.repository.PictureRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Getter
@Setter
public class ValidationService {

  public boolean isValidLabel(String label) {
    return label == null || !label.toLowerCase().contains("xx");
  }
  public static boolean validateStringFilenameUsingRegex(String filename) {
    final String REGEX_PATTERN = "^[A-Za-z0-9._-]{1,255}$";
    if (filename == null) {
      return false;
    }
    return filename.matches(REGEX_PATTERN);
  }

}
