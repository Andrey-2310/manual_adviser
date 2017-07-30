package com.ranv.Service.ServiceModel;

import com.ranv.Model.ModelDB.Tag;
import com.ranv.Repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TagService {
    @Autowired
    TagRepository tagRepository;

    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    public Tag findByName(String name) {
        return tagRepository.findByName(name);
    }

   // public Long addTag(Tag tag) {
   public Long addTag(Tag tag){
        Optional<Long> newLong = Optional.of(tag.getId());
        return newLong.orElse(tagRepository.save(tag).getId());
    }
}