package com.ph.petservice.mapper;

import com.ph.petservice.dto.PetResponseDTO;
import com.ph.petservice.model.Pet;

public class PetMapper {
    public static PetResponseDTO toDTO(Pet pet) {
        PetResponseDTO petDTO = new PetResponseDTO();

        petDTO.setId(pet.getId().toString());
        petDTO.setName(pet.getName());
        petDTO.setType(pet.getType());
        petDTO.setBreed(pet.getBreed());
        petDTO.setDateOfBirth(pet.getDateOfBirth().toString());

        return petDTO;
    }
}
