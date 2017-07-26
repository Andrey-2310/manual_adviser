package com.ranv.Model.DTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


public abstract class ModelDTO<U, V> {

    @Autowired
    ModelMapper modelMapper;
    abstract protected U convertToItemDTO(V item);

    public List<U> convertItems(List<V> items) {
        List<U> itemsDTO = new ArrayList<>();
        for (V item : items) {
            itemsDTO.add(convertToItemDTO(item));
        }

        return itemsDTO;
    }
}
