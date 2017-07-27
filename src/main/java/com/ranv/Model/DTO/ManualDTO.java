package com.ranv.Model.DTO;

import com.ranv.Model.ModelDB.Manual;
import com.ranv.Model.ModelDB.Rating;
import com.ranv.Model.ModelDB.Tag;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@Component
public class ManualDTO extends ModelDTO<ManualDTO, Manual> {

    private String name;
    private String date;
    private String image;
    private String introduction;
    private String username;
    private boolean published;
    private List<String> tagNames;
    private Long rating;

    @Override
    public ManualDTO convertToItemDTO(Manual manual) {
        ManualDTO manualDTO = modelMapper.map(manual, ManualDTO.class);
        manualDTO.setUsername(manual.getUser().getUsername());
        manualDTO.setRating(manual.getRatings());
        manualDTO.tagNames = new ArrayList<>();
        for (Tag tag : manual.getTags()) {
            manualDTO.tagNames.add(tag.getName());
        }
        return manualDTO;
    }

    private void setRating(Set<Rating> ratings){
        rating=0L;
        for(Rating rat:ratings){
            rating+=rat.getValue();
        }
    }

    public Manual convertFromItemDTO(ManualDTO manualDTO){
        return modelMapper.map(manualDTO, Manual.class);
    }
}
