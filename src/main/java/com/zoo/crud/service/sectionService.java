package com.zoo.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoo.crud.DTO.SectionDTO;
import com.zoo.crud.model.section;
import com.zoo.crud.repository.Isection;

@Service
public class sectionService {
    @Autowired
    private Isection data;

      public void save(SectionDTO sectionDTO){
        section section = convertToModel(sectionDTO);
        data.save(section);
    }

    public SectionDTO converToDTO(section section){
        SectionDTO sectionDTO = new SectionDTO(
            section.getNameSection(),
            section.getLocation()
        );
        return sectionDTO;
    }

    public section convertToModel(SectionDTO sectionDTO){
        section section = new section(
            0,
            sectionDTO.getNameSection(),
            sectionDTO.getLocation()
        );
        return section;
    }

}
