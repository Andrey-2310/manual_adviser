package com.ranv.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;


@Configuration
public class TagDTOConfiguration {

    @Bean
    public SortedMap<Long, Integer> getTagDTOMap() {
        SortedMap<Long, Integer> sortedMap = new TreeMap<>(Collections.reverseOrder());

        sortedMap.put(100L, 3);
        sortedMap.put(10L, 2);
        sortedMap.put(0L, 1);
        return sortedMap;
    }

}

