package com.ph.petservice.service;

import com.ph.petservice.dto.PetRequestDTO;
import com.ph.petservice.dto.PetResponseDTO;
import com.ph.petservice.mapper.PetMapper;
import com.ph.petservice.model.Pet;
import com.ph.petservice.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetService {
    private PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<PetResponseDTO> getPets() {
        // Call built-in repo function from JpaRepository to get all pets
        List<Pet> pets = petRepository.findAll();

        // Call the PetMapper.modelToResponseDTO() method for each pet
        List<PetResponseDTO> petDTOs = pets.stream().map(PetMapper::modelToResponseDTO).toList();

        return petDTOs;
    }

    public PetResponseDTO createPet(PetRequestDTO petDTO) {
        Pet createdPet = petRepository.save(PetMapper.requestDTOToModel(petDTO));

        return PetMapper.modelToResponseDTO(createdPet);
    }
}
