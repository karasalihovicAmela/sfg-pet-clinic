package com.amela.sfgpetclinic.services.map;

import com.amela.sfgpetclinic.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PetServiceMapTest {

    private PetServiceMap petServiceMap;

    private final Long petId = 1L;

    @BeforeEach
    void setUp() {

        petServiceMap = new PetServiceMap();

        petServiceMap.save(Pet.builder().id(petId).build());
    }

    @Test
    void findAll() {

        Set<Pet> petSet = petServiceMap.findAll();

        assertEquals(1, petSet.size());
    }

    @Test
    void findById() {

        Pet pet = petServiceMap.findById(petId);

        assertEquals(petId, pet.getId());
    }

    @Test
    void findByIdNotExisting() {

        Pet pet = petServiceMap.findById(5L);

        assertNull(pet);
    }

    @Test
    void findByIdNull() {

        Pet pet = petServiceMap.findById(null);

        assertNull(pet);

    }

    @Test
    void save() {

        Long id = 2L;

        Pet pet = Pet.builder().id(id).build();

        Pet savedPet = petServiceMap.save(pet);

        assertEquals(id, savedPet.getId());
    }

    @Test
    void saveDuplicateId() {

        Long id = 1L;

        Pet pet = Pet.builder().id(id).build();

        Pet savedPet = petServiceMap.save(pet);

        assertEquals(id, savedPet.getId());
        assertEquals(1, petServiceMap.findAll().size());
    }

    @Test
    void saveNoId() {

        Pet savedPet = petServiceMap.save(Pet.builder().build());

        assertNotNull(savedPet);
        assertNotNull(savedPet.getId());
        assertEquals(2, petServiceMap.findAll().size());
    }

    @Test
    void delete() {

        petServiceMap.delete(petServiceMap.findById(petId));

        assertEquals(0, petServiceMap.findAll().size());
    }

    @Test
    void deleteById() {

        petServiceMap.deleteById(petId);

        assertEquals(0, petServiceMap.findAll().size());
    }
}