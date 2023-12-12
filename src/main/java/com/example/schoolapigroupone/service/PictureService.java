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
public class PictureService {

  private final PictureRepository pictureRepository;

  public Picture savePicture(Picture picture) {
    return pictureRepository.save(picture);
  }

  public Picture getPictureById(Long id) {
    return pictureRepository.findById(id).orElse(null);
  }

}
