package com.ranv.Service.ServiceDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public abstract class ServiceModelDTO<U, V> {

    @Autowired
    @JsonIgnore
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
