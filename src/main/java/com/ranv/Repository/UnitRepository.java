package com.ranv.Repository;

import com.ranv.Model.ModelDB.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {
     List<Unit> findByStepId(int stepId);
}
