package com.zoo.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.zoo.crud.DTO.ResponsesDTO;
import com.zoo.crud.DTO.SectionDTO;
import com.zoo.crud.model.Sections;
import com.zoo.crud.repository.Isection;


@Service
public class sectionService {
    @Autowired
    private Isection data;

    public List<Sections> findAll(){
        return data.findAll();
    }

    public List<Sections> getListSectionsForName(String name) {
        return data.findByNameSectionContainingIgnoreCase(name);
    }

    public Optional<Sections> findById(int id){
        return data.findById(id);
    }

    public ResponsesDTO deleteSections(int id){
        Optional<Sections> sections = findById(id);
        if (!sections.isPresent()){
            return new ResponsesDTO(HttpStatus.NOT_FOUND.toString(), "The register does not exist");
        }
        
        data.deleteById(id);  // 🔹 Aquí realmente se elimina el registro.
    
        return new ResponsesDTO(HttpStatus.OK.toString(), "Se eliminó correctamente");
    }

    public ResponsesDTO save(SectionDTO sectionDTO){
        Sections sections = convertToModel(sectionDTO);
        data.save(sections);
        ResponsesDTO respuesta = new ResponsesDTO(
            HttpStatus.OK.toString(),
            "Se guardó correctamente"
        );
        return respuesta;
    }

    public ResponsesDTO updateSections(int id, SectionDTO sectionDTO){
        Optional<Sections> sections = findById(id);
        if (!sections.isPresent()){
            return new ResponsesDTO(HttpStatus.NOT_FOUND.toString(), "The register does not exist");
        }
        
        Sections updatedSections = sections.get();
        updatedSections.setNameSection(sectionDTO.getNameSection());
        updatedSections.setLocation(sectionDTO.getLocation());
        
        data.save(updatedSections);  // 🔹 Aquí realmente se actualiza el registro.
    
        return new ResponsesDTO(HttpStatus.OK.toString(), "Se actualizó correctamente");
    }

    public SectionDTO converToDTO(Sections section){
        SectionDTO sectionDTO = new SectionDTO(
            section.getSectionID(),
            section.getNameSection(),
            section.getLocation()
        );
        return sectionDTO;
    }

    public Sections convertToModel(SectionDTO sectionDTO){
        Sections section = new Sections(
            0,
            sectionDTO.getNameSection(),
            sectionDTO.getLocation()
        );
        return section;
    }

}
