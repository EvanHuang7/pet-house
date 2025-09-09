package com.ph.petservice.mapper;

import com.ph.petservice.dto.PetRequestDTO;
import com.ph.petservice.dto.PetResponseDTO;
import com.ph.petservice.model.Pet;

import java.time.LocalDate;

public class PetMapper {
    public static PetResponseDTO modelToResponseDTO(Pet pet) {
        PetResponseDTO petDTO = new PetResponseDTO();

        petDTO.setId(pet.getId().toString());
        petDTO.setName(pet.getName());
        petDTO.setType(pet.getType());
        petDTO.setBreed(pet.getBreed());
        petDTO.setDateOfBirth(pet.getDateOfBirth().toString());

        return petDTO;
    }

    public static Pet requestDTOToModel(PetRequestDTO petDTO) {
        Pet pet = new Pet();

        pet.setName(petDTO.getName());
        pet.setType(petDTO.getType());
        pet.setBreed(petDTO.getBreed());
        pet.setDateOfBirth(LocalDate.parse(petDTO.getDateOfBirth()));
        pet.setRegisteredDate(LocalDate.parse(petDTO.getRegisteredDate()));

        return pet;
    }
}
