package com.ranv.Repository;

import com.ranv.Model.ModelDB.Manual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ManualRepository extends JpaRepository<Manual, Long> {

    List<Manual> findTop10ByIdGreaterThanAndPublishedTrueOrderById(Long id);

    List<Manual> findByTagsNameAndPublishedTrueOrderByDate(String tagname);

    List<Manual> findByUserIdAndPublishedTrueOrderByDate(Long userId);

    List<Manual> findTop5ByPublishedTrueOrderByRatingDesc();
}
