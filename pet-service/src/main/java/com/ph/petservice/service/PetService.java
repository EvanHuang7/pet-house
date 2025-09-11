package com.ph.petservice.service;

import com.ph.petservice.dto.PetRequestDTO;
import com.ph.petservice.dto.PetResponseDTO;
import com.ph.petservice.exception.PetNotFoundException;
import com.ph.petservice.mapper.PetMapper;
import com.ph.petservice.model.Pet;
import com.ph.petservice.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

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
        // Create a new pet
        Pet createdPet = petRepository.save(PetMapper.requestDTOToModel(petDTO));

        return PetMapper.modelToResponseDTO(createdPet);
    }

    public PetResponseDTO updatePet(UUID id, PetRequestDTO petDTO) {
        // Get the pet by id
        Pet targetPet = petRepository.findById(id).orElseThrow(() -> new PetNotFoundException("Pet not found with ID: " + id));

        // Update pet info
        targetPet.setName(petDTO.getName());
        targetPet.setType(petDTO.getType());
        targetPet.setBreed(petDTO.getBreed());
        targetPet.setDateOfBirth(LocalDate.parse(petDTO.getDateOfBirth()));

        Pet updatedPet = petRepository.save(targetPet);

        return PetMapper.modelToResponseDTO(updatedPet);

    }

    public void deletePet(UUID id) {
        petRepository.deleteById(id);
    }
}
