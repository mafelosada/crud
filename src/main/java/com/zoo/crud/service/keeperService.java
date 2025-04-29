package com.zoo.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;

import com.zoo.crud.DTO.ResponsesDTO;
import com.zoo.crud.DTO.KeeperDTO;
import com.zoo.crud.model.Keepers;
import com.zoo.crud.repository.Ikeeper;

@Service
public class keeperService {
    @Autowired
    private Ikeeper data;

    public List<Keepers> findAll(){
        return data.findAll();
    }

    public List<Keepers> findByNameKeeper(String name){
        return data.findByNameKeeper(name);
    }

    public Optional<Keepers> findById(int id){
        return data.findById(id);
    }

    public ResponsesDTO deleteKeeper(int id){
        Optional<Keepers> keeper = findById(id);
        if (!keeper.isPresent()){
            return new ResponsesDTO(HttpStatus.NOT_FOUND.toString(), "The register does not exist");
        }
        
        data.deleteById(id);  // 🔹 Aquí realmente se elimina el registro.
    
        return new ResponsesDTO(HttpStatus.OK.toString(), "Se eliminó correctamente");
    }

    public ResponsesDTO save(KeeperDTO keeperDTO){
        Keepers keeper = convertToModel(keeperDTO);
        data.save(keeper);
        ResponsesDTO respuesta = new ResponsesDTO(
            HttpStatus.OK.toString(),
            "Se guardó correctamente"
        );
        return respuesta;
    }

    public ResponsesDTO updateKeeper(int id, KeeperDTO keeperDTO){
        Optional<Keepers> keeper = findById(id);
        if (!keeper.isPresent()){
            return new ResponsesDTO(HttpStatus.NOT_FOUND.toString(), "The register does not exist");
        }
        
        Keepers updatedKeeper = keeper.get();
        updatedKeeper.setNameKeeper(keeperDTO.getNameKeeper());
        updatedKeeper.setPhone(keeperDTO.getPhone());
        updatedKeeper.setSpecialty(keeperDTO.getSpecialty());

        data.save(updatedKeeper); // Guardar el registro actualizado

        return new ResponsesDTO(HttpStatus.OK.toString(), "Se actualizó correctamente");
    }

    public KeeperDTO converToDTO(Keepers keeper){
        KeeperDTO keeperDTO = new KeeperDTO(
            keeper.getKeeperID(),
            keeper.getNameKeeper(),
            keeper.getPhone(),
            keeper.getSpecialty()
        );
        return keeperDTO;
    }

    public Keepers convertToModel(KeeperDTO keeperDTO){
        Keepers keeper = new Keepers(
            0,
            keeperDTO.getNameKeeper(),
            keeperDTO.getPhone(),
            keeperDTO.getSpecialty()
        );
        return keeper;
    }

}
