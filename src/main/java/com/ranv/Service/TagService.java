package com.ranv.Service;

import com.ranv.Model.ModelDB.Tag;
import com.ranv.Repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TagService {
    @Autowired
    TagRepository tagRepository;

    public List<Tag> findAll(){
        return tagRepository.findAll();
    }
    public Tag findByName(String name){return tagRepository.findByName(name);}
}
