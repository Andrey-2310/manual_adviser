package com.ranv.service.serviceModel;

import com.ranv.model.DB.Unit;
import com.ranv.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UnitService {

    private final UnitRepository unitRepository;

    @Autowired
    public UnitService(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    public Long saveUnit(Unit unit) {
        return unitRepository.save(unit).getId();
    }

    public void updateUnit(Unit unit) {
        unitRepository.save(unit);
    }


    public Unit findById(Long id) {
        return unitRepository.findOne(id);
    }

    public List<Unit> findUnitsByStepId(Long stepId) {
        return unitRepository.findByStepIdOrderByOrderAsc(stepId);
    }

    @Transactional
    public void delete(Long id) {
        unitRepository.delete(id);
    }

    @Transactional
    public void deleteUnitsByStepId(Long stepId) {
        unitRepository.deleteByStepId(stepId);
    }

}
