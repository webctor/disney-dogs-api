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
    public ResponseEntity<Object> getDogPictures() {

        List<Pet> pets = petService.retrievePets();

        Map<String, List<Pet>> groupByBreed =
                pets.stream().collect(Collectors.groupingBy(Pet::getBreed));

        System.out.println(groupByBreed);

        return ResponseEntity.ok(groupByBreed);
    }

    @GetMapping("/dogs/pictures/{id}")
    public Pet getPet(@PathVariable(name="id") Long id) {
        return petService.getPet(id);
    }

    @PostMapping("/dogs")
    public ResponseEntity<Object> savePet(@RequestBody Pet pet){
        petService.savePet(pet);
        return ResponseEntity.ok(pet);
    }

    @DeleteMapping("/dogs/{id}")
    public void deletePet(@PathVariable(name="id") Long id){
        petService.deletePet(id);
        System.out.println("Pet Deleted Successfully");
    }

    @PutMapping("/dogs/{id}")
    public void updatePet(@RequestBody Pet pet, @PathVariable(name="id") Long id){
        Pet p = petService.getPet(id);
        if(p != null){
            petService.updatePet(pet);
        }

    }

}
