package com.ranv.Repository;

import com.ranv.Model.ModelDB.Step;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StepRepository extends JpaRepository<Step, Long> {
    List<Step> findByManualIdOrderByOrderAsc(Long id);
    List<Step> findByManualId(Long id);
    void deleteByManualId(Long manualId);
}
