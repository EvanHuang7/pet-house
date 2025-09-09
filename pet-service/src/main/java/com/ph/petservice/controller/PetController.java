package com.ph.petservice.controller;

import com.ph.petservice.dto.PetResponseDTO;
import com.ph.petservice.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
