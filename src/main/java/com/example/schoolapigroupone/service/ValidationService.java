package com.example.schoolapigroupone.service;
import com.example.schoolapigroupone.model.Picture;
import com.example.schoolapigroupone.repository.PictureRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Getter
@Setter
public class ValidationService {

  private final PictureRepository pictureRepository;
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

  public boolean isValidFileName(String fileName) {
    if (fileName == null || fileName.isEmpty()) {
      return false;
    }
    // Check if the file name matches the pattern: [a-zA-Z0-9_-]+\.[a-zA-Z]{3,4}
    return fileName.matches("[a-zA-Z0-9_-]+\\.[a-zA-Z]{3,4}");
  }

  public boolean isNotDuplicated(String label) {
    if (label == null || label.isEmpty()) {
      return false;
    }

    List<String> picturesLabel = pictureRepository.findAll().stream()
            .map(Picture::getLabel)
            .toList();

    return !picturesLabel.contains(label);
  }
  public boolean isUnavailableForLegalReason(String label){
    Picture picture1 = Picture.builder()
            .label("hacked_file.png").build();
    Picture picture2 = Picture.builder()
            .label("tapped_file.jpeg").build();
    List<String> unavailablePicturesLabel = List.of(picture1.getLabel(), picture2.getLabel());
    return unavailablePicturesLabel.contains(label);
  }

  public boolean isLargeFile(String base64) {
    if (base64 == null || base64.isEmpty()) {
      return false;
    }

    // Decode the base64 string to binary data
    byte[] binaryData = Base64Utils.decodeFromString(base64);

    // Check if the size of the binary data is over 8MB
    return binaryData.length > 8 * 1024 * 1024; // 8MB in bytes
  }

}
