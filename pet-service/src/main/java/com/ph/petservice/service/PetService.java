package com.ph.petservice.service;

import com.ph.petservice.dto.PetResponseDTO;
import com.ph.petservice.model.Pet;
import com.ph.petservice.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    private PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<PetResponseDTO> getPets() {
        List<Pet> pets = petRepository.findAll();
    }
}
