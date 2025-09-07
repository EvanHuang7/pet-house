package com.ph.petservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Pet  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    private String name;

    @NotNull
    private String type;

    @NotNull
    private String breed;

    @NotNull
    private LocalDate date0fBirth;

    @NotNull
    private LocalDate registeredDate;

    // TODO: add foreign key for the id of User after creating User table
    // Many pets belong to one user
//    @ManyToOne
//    @JoinColumn(name = "owner_id", nullable = false)
//    private User owner;

}
