package com.ranv.repository;

import com.ranv.model.DB.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    public List<Rating> findAllByUser_Id(Long userId);
}
