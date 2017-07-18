package com.ranv.Model.DTO;

import com.ranv.Model.Manual;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * Created by Андрей on 18.07.2017.
 */
@Getter
@Setter
@Component
public class ManualDTO extends ModelDTO<ManualDTO, Manual>{

    private Long id;
    private String name;
    private String date;
    private String image;
    private String introduction;
    private Long userId;

    @Override
    public ManualDTO convertToItemDTO(Manual manual){
       ManualDTO manualDTO= new ModelMapper().map( manual, ManualDTO.class);
       manualDTO.setUserId(manual.getUser().getId());
       return manualDTO;
    }

}
