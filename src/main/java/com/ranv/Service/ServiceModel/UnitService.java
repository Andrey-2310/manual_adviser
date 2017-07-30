package com.ranv.Service.ServiceModel;

import com.ranv.Model.ModelDB.Unit;
import com.ranv.Repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitService {
    @Autowired
    private UnitRepository unitRepository;

    public void save(Unit unit){ unitRepository.save(unit);}
    public void saveUnits(List<Unit> units){
        for(Unit unit: units){
            save(unit);
        }
    }
    public Unit findById(Long id){return unitRepository.findOne(id);}
}
