package com.ranv.Model.DTO.Comparator.ComparatorUnitDTO;

import com.ranv.Model.DTO.UnitDTO;

import java.util.Comparator;


public class OrderComparator implements Comparator<UnitDTO> {
    @Override
    public int compare(UnitDTO u1, UnitDTO u2) {
        if (u1.getOrder() < u2.getOrder())
            return -1;
        if (u1.getOrder() > u2.getOrder())
            return 1;
        return 0;
    }
}
