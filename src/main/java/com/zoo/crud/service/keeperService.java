package com.zoo.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoo.crud.DTO.KeeperDTO;
import com.zoo.crud.model.keeper;
import com.zoo.crud.repository.Ikeeper;

@Service
public class keeperService {
    @Autowired
    private Ikeeper data;

    public void save(KeeperDTO keeperDTO){
        keeper keeper = convertToModel(keeperDTO);
        data.save(keeper);
    }

    public KeeperDTO converToDTO(keeper keeper){
        KeeperDTO keeperDTO = new KeeperDTO(
            keeper.getNameKeeper(),
            keeper.getPhone(),
            keeper.getSpecialty()
        );
        return keeperDTO;
    }

    public keeper convertToModel(KeeperDTO keeperDTO){
        keeper keeper = new keeper(
            0,
            keeperDTO.getNameKeeper(),
            keeperDTO.getPhone(),
            keeperDTO.getSpecialty()
        );
        return keeper;
    }

}
