package com.disney.studios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Hector R Acosta on 2/4/19.
 */
@RestController
public class PetController {

    @Autowired
    private PetService petService;

    public void setPetService(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/dogs/pictures")
    public ResponseEntity<Object> getDogPictures(@RequestParam(required = false) String breed) {

        List<Pet> pets = petService.retrievePets();

        Map<String, List<Pet>> groupByBreed =
                pets.stream().collect(Collectors.groupingBy(Pet::getBreed));

        if (breed != null) {
            breed = breed.toLowerCase();
            return ResponseEntity.ok(groupByBreed.get(breed));
        } else {
            return ResponseEntity.ok(groupByBreed);
        }

    }

    @GetMapping("/dogs/{id}")
    public ResponseEntity<Object> getPet(@PathVariable(name="id") Long id) {
        return ResponseEntity.ok(petService.getPet(id));
    }

    @PostMapping("/dogs")
    public ResponseEntity<Object> savePet(@RequestBody Pet pet){
        petService.savePet(pet);
        return ResponseEntity.ok(pet);
    }

    @DeleteMapping("/dogs/{id}")
    public void deletePet(@PathVariable(name="id") Long id){
        petService.deletePet(id);
    }

    @PutMapping("/dogs/{id}")
    public ResponseEntity<Object> updatePet(@RequestBody Pet pet, @PathVariable(name="id") Long id){
        Pet p = petService.getPet(id);
        if(p != null){
            petService.updatePet(pet);

        }

        return ResponseEntity.ok(pet);

    }

    @PutMapping("/dogs/{id}/up")
    public ResponseEntity<Object> updatePetUp(@PathVariable(name="id") Long id){
        Pet pet = petService.getPet(id);
        if(pet != null){
            pet.setVotes(pet.getVotes() + 1);
            petService.updatePet(pet);
        }

        return ResponseEntity.ok(pet);

    }

    @PutMapping("/dogs/{id}/down")
    public ResponseEntity<Object> updatePetDown(@PathVariable(name="id") Long id){
        Pet pet = petService.getPet(id);
        if(pet != null && pet.getVotes() > 0){
            pet.setVotes(pet.getVotes() - 1);
            petService.updatePet(pet);
        }

        return ResponseEntity.ok(pet);

    }

}
