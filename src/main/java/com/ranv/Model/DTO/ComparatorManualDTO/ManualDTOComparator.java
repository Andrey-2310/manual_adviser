package com.ranv.Model.DTO.ComparatorManualDTO;

import com.ranv.Model.DTO.ManualDTO;

import java.util.Comparator;


public class ManualDTOComparator implements Comparator<ManualDTO> {

    @Override
    public int compare(ManualDTO m1, ManualDTO m2) {

        if (m1.getRating() < m2.getRating())
            return 1;
        if (m1.getRating() > m2.getRating())
            return -1;
        return 0;
    }
}
