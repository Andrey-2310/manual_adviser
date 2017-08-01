package com.ranv.Model.DTO.Comparator.ComparatorManualDTO;

import com.ranv.Model.DTO.ManualDTO;

import java.util.Comparator;


public class DateComparator implements Comparator<ManualDTO> {
    @Override
    public int compare(ManualDTO m1, ManualDTO m2) {
        return m1.getDate().compareTo(m2.getDate());
    }
}
