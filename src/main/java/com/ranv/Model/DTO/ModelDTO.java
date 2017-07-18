package com.ranv.Model.DTO;

import java.util.ArrayList;
import java.util.List;


public abstract class ModelDTO<U, V> {

    abstract protected U convertToItemDTO(V item);

    public List<U> convertItems(List<V> items) {
        List<U> itemsDTO = new ArrayList<>();
        for (V item : items) {
            itemsDTO.add(convertToItemDTO(item));
        }
        return itemsDTO;
    }
}
