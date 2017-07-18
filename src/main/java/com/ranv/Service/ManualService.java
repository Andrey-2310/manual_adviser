package com.ranv.Service;

import com.ranv.Model.Manual;
import com.ranv.Repository.ManualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Андрей on 17.07.2017.
 */
@Service

public class ManualService {
    @Autowired
    private ManualRepository manualRepository;

    public List<Manual> findAll(){
        return manualRepository.findAll();
    }



}
