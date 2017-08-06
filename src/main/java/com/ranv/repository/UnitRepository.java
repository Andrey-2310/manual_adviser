package com.ranv.repository;

import com.ranv.model.DB.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {
   List<Unit> findByStepIdOrderByOrderAsc(Long stepId);
   void deleteByStepId(Long stepId);

}
