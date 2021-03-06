package com.ranv.repository;

import com.ranv.model.DB.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findAllByUser_Id(Long userId);

    List<Rating> findAllByUser_IdAndManual_User_Id(Long userId, Long authorId);
}
