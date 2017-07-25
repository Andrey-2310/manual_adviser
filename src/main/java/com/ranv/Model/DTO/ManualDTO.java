package com.ranv.Model.DTO;

import com.ranv.Model.ModelDB.Manual;
import com.ranv.Model.ModelDB.Tag;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Component
public class ManualDTO extends ModelDTO<ManualDTO, Manual> {

    private String name;
    private String date;
    private String image;
    private String introduction;
    private String username;
    private List<String> tagNames;

    @Override
    public ManualDTO convertToItemDTO(Manual manual) {
        ManualDTO manualDTO = modelMapper.map(manual, ManualDTO.class);
        manualDTO.setUsername(manual.getUser().getUsername());
        manualDTO.tagNames = new ArrayList<>();
        for (Tag tag : manual.getTags()) {
            manualDTO.tagNames.add(tag.getName());
        }
        return manualDTO;
    }

}
