package com.ph.petservice.controller;

import com.ph.petservice.dto.PetRequestDTO;
import com.ph.petservice.dto.PetResponseDTO;
import com.ph.petservice.dto.validators.CreatePetValidationGroup;
import com.ph.petservice.service.PetService;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pets")
public class PetController {
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public ResponseEntity<List<PetResponseDTO>> getPets() {
        List<PetResponseDTO> pets = petService.getPets();

        return ResponseEntity.ok(pets);
    }

    @PostMapping
    public ResponseEntity<PetResponseDTO> createPet(@Validated({Default.class, CreatePetValidationGroup.class}) @RequestBody PetRequestDTO petRequest) {
        PetResponseDTO createdPet = petService.createPet(petRequest);

        return ResponseEntity.ok(createdPet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PetResponseDTO> updatePet(@PathVariable UUID id, @Validated({Default.class}) @RequestBody PetRequestDTO petRequest) {
        PetResponseDTO updatedPet = petService.updatePet(id, petRequest);

        return ResponseEntity.ok(updatedPet);
    }
}
