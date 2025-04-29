package com.zoo.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.zoo.crud.DTO.MedicationDTO;
import com.zoo.crud.DTO.ResponsesDTO;
import com.zoo.crud.model.Medications;
import com.zoo.crud.repository.Imedication;
import com.zoo.crud.repository.IregisterAnimal;

@Service
public class medicationService {
    @Autowired
    private Imedication data;

    @Autowired
    private IregisterAnimal registerAnimalRepository;

    public List<Medications> findAll(){
        return data.findAll();
    }

    public List<Medications> getListMedicationsForDescription(String name){
        return data. findByMedicineContaining(name);
    }

    public Optional<Medications> findById(int id){
        return data.findById(id);
    }

    public ResponsesDTO deleteMedication(int id){
        Optional<Medications> medication = findById(id);
        if (!medication.isPresent()){
            return new ResponsesDTO(HttpStatus.NOT_FOUND.toString(), "The medication does not exist");
        }
        
        data.deleteById(id);  // 🔹 Aquí realmente se elimina el registro.
    
        return new ResponsesDTO(HttpStatus.OK.toString(), "Se eliminó correctamente");
    }

    public ResponsesDTO save(MedicationDTO medicationDTO){
        Medications medication = convertToModel(medicationDTO);
        data.save(medication);
        ResponsesDTO respuesta = new ResponsesDTO(
            HttpStatus.OK.toString(),
            "Se guardó correctamente"
        );
        return respuesta;
    }

    public ResponsesDTO updateMedication(MedicationDTO medicationDTO){
        Medications medication = convertToModel(medicationDTO);
        data.save(medication);
        ResponsesDTO respuesta = new ResponsesDTO(
            HttpStatus.OK.toString(),
            "Se actualizó correctamente"
        );
        return respuesta;
    }

    public MedicationDTO converToDTO(Medications medication){
        MedicationDTO medicationDTO = new MedicationDTO(
            medication.getMedicationID(),
            medication.getRegisterAnimal(),
            medication.getDescription(),
            medication.getMedicine(),
            medication.getDose(),
            medication.getDuration()
        );
        return medicationDTO;
    }

    public Medications convertToModel(MedicationDTO medicationDTO){
        var registerAnimal = registerAnimalRepository.findById(medicationDTO.getRegisterAnimal().getRegisterAnimalID())
            .orElseThrow(() -> new RuntimeException("RegisterAnimal not found"));
        Medications medication = new Medications(
            0,
            registerAnimal,
            medicationDTO.getDescription(),
            medicationDTO.getMedicine(),
            medicationDTO.getDose(),
            medicationDTO.getDuration()
        );
        return medication;
    }

}
