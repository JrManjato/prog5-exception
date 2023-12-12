package com.example.schoolapigroupone.service;
import com.example.schoolapigroupone.model.Picture;
import com.example.schoolapigroupone.model.exception.BadRequestException;
import com.example.schoolapigroupone.repository.PictureRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Getter
@Setter
public class PictureService {

  private final PictureRepository pictureRepository;
  private static final Logger LOGGER = Logger.getLogger(PictureService.class.getName());

  public Picture savePicture(Picture picture) {
    ArrayList<String> extensions = new ArrayList<>();
    extensions.add("png");
    extensions.add("webp");
    extensions.add("jpeg");
    extensions.add("gif");
    extensions.add("jfif");

    List<String> picturesName = pictureRepository.findAll().stream().map((pic) -> pic.getLabel()).collect(Collectors.toList());

    if(!extensions.contains(picture.getExtension())){
      throw new BadRequestException("The file extension is not accepted.");
    }else if(picturesName.contains(picture.getLabel())){
      throw new BadRequestException("The file already exists");
    }else if(!validateStringFilenameUsingRegex(picture.getLabel())){
      throw new BadRequestException("The filename is invalid, it should contains only alphanumeric characters, underscores, hyphens, and dots");
    }else{
      return pictureRepository.save(picture);
    }
}

  public Picture getPictureById(Long id) {
    return pictureRepository.findById(id).orElse(null);
  }

  public static final String REGEX_PATTERN = "^[A-Za-z0-9._-]{1,255}$";

  public static boolean validateStringFilenameUsingRegex(String filename) {
    if (filename == null) {
      return false;
    }
    return filename.matches(REGEX_PATTERN);
  }

}
