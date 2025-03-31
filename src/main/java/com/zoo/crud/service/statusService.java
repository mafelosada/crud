package com.zoo.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoo.crud.DTO.StatusDTO;
import com.zoo.crud.model.status;
import com.zoo.crud.repository.Istatus;

@Service
public class statusService {

    @Autowired
    private Istatus data;

    public void save(StatusDTO statusDTO){
        status status = convertToModel(statusDTO);
        data.save(status);
    }

    public StatusDTO converToDTO(status status){
        StatusDTO statusdto = new StatusDTO(
            status.getNameStatus()
        );
        return statusdto;
    }

    public status convertToModel(StatusDTO statusDTO){
        status status = new status(
            0,
            statusDTO.getNameStatus()
        );
        return status;
    }
    

}
