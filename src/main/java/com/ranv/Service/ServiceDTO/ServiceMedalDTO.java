package com.ranv.Service.ServiceDTO;

import com.ranv.Model.DTO.MedalDTO;
import com.ranv.Model.ModelDB.Medal;
import org.springframework.stereotype.Service;

@Service
public class ServiceMedalDTO extends ServiceModelDTO<MedalDTO, Medal> {
    @Override
    protected MedalDTO convertToItemDTO(Medal medal) {
        MedalDTO medalDTO = modelMapper.map(medal, MedalDTO.class);
        return medalDTO;
    }

    @Override
    protected Medal convertFromItemDTO(MedalDTO medalDTO) {
        Medal medal = modelMapper.map(medalDTO, Medal.class);
        return medal;
    }
}
