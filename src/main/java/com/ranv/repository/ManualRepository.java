package com.ranv.repository;

import com.ranv.model.DB.Manual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ManualRepository extends JpaRepository<Manual, Long> {

    List<Manual> findTop10ByIdGreaterThanAndPublishedTrueOrderById(Long id);

    List<Manual> findByTagsNameAndPublishedTrueOrderByDate(String tagname);

    List<Manual> findByUserIdAndPublishedTrueOrderByDate(Long userId);

    List<Manual> findTop5ByPublishedTrueOrderByRatingDesc();

    List<Manual> findTop10ByIdLessThanAndPublishedTrueOrderByIdDesc(Long id);

    List<Manual> findTop10ByPublishedTrueOrderByIdDesc();
}
