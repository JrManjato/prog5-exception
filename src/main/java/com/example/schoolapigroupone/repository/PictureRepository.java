package com.example.schoolapigroupone.repository;

import com.example.schoolapigroupone.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {
  // Additional custom queries can be added here if needed
}