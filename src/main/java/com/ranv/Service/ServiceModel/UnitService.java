package com.ranv.Service.ServiceModel;

import com.ranv.Model.ModelDB.Unit;
import com.ranv.Repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitService {
    @Autowired
    private UnitRepository unitRepository;

    public Long saveUnit(Unit unit){ return unitRepository.save(unit).getId();}

    public void updateUnit(Unit unit){ unitRepository.save(unit);}

    public void delete(Long id) {
        unitRepository.delete(id);
    }

    public Unit findById(Long id){return unitRepository.findOne(id);}
}
