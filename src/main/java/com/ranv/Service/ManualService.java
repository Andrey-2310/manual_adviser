package com.ranv.Service;

import com.ranv.Model.ModelDB.Manual;
import com.ranv.Repository.ManualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class ManualService {
    @Autowired
    private ManualRepository manualRepository;

    public List<Manual> findAll(){
        return manualRepository.findAll();
    }



}