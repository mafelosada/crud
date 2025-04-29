package com.zoo.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.zoo.crud.DTO.ResponsesDTO;
import com.zoo.crud.DTO.StatusDTO;
import com.zoo.crud.model.Statuss;
import com.zoo.crud.repository.Istatus;

@Service
public class statusService {

    @Autowired
    private Istatus data;

    public List<Statuss> findAll(){
        return data.findAll();
    }

    public List<Statuss> getListStatusForName(String filter){
        return data.findAll();
    }

    public Optional<Statuss> findById(int id){
        return data.findById(id);
    }

    public ResponsesDTO deleteStatus(int id){
        Optional<Statuss> status = findById(id);
        if (!status.isPresent()){
            return new ResponsesDTO(HttpStatus.NOT_FOUND.toString(), "The register does not exist");
        }
        
        data.deleteById(id);  // 🔹 Aquí realmente se elimina el registro.
    
        return new ResponsesDTO(HttpStatus.OK.toString(), "Se eliminó correctamente");
    }

    public ResponsesDTO save(StatusDTO statusDTO){
        Statuss status = convertToModel(statusDTO);
        data.save(status);
        ResponsesDTO respuesta = new ResponsesDTO(
            HttpStatus.OK.toString(),
            "Se guardó correctamente"
        );
        return respuesta;
    }

    public ResponsesDTO updateStatus(int id, StatusDTO statusDTO){
        Optional<Statuss> status = findById(id);
        if (!status.isPresent()){
            return new ResponsesDTO(HttpStatus.NOT_FOUND.toString(), "The register does not exist");
        }
        
        Statuss updatedStatus = status.get();
        updatedStatus.setNameStatus(statusDTO.getNameStatus());
        data.save(updatedStatus); // Guardar el objeto actualizado en la base de datos

        return new ResponsesDTO(HttpStatus.OK.toString(), "Se actualizó correctamente");
    }

    public StatusDTO converToDTO(Statuss status){
        StatusDTO statusdto = new StatusDTO(
            status.getStatusID(),
            status.getNameStatus()
        );
        return statusdto;
    }

    public Statuss convertToModel(StatusDTO statusDTO){
        Statuss status = new Statuss(
            0,
            statusDTO.getNameStatus()
        );
        return status;
    }
    

}
