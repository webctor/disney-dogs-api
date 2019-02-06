package com.disney.studios;

import com.disney.studios.security.User;
import com.disney.studios.security.VotedSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
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
                pets.stream().sorted(Comparator.comparingInt(Pet::getVotes)).collect(Collectors.groupingBy(Pet::getBreed));


        if (breed != null) {
            breed = breed.toLowerCase();
            return ResponseEntity.ok(groupByBreed.get(breed));
        } else {
            return ResponseEntity.ok(groupByBreed);
        }

    }

    @GetMapping("/dogs/{id}")
    public ResponseEntity<Object> getPet(@PathVariable(name="id") Long id) {
        try {
            return ResponseEntity.ok(petService.getPet(id));
        } catch (NoSuchElementException nse) {
            return ResponseEntity.badRequest().build();
        }

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
    public ResponseEntity<Object> updatePet(@RequestBody Pet pet, @PathVariable(name="id") Long id, Authentication authentication){

        String username = authentication.getName();

        VotedSingleton voted = VotedSingleton.getInstance();

        if(voted.map.containsKey(username)) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body("Don't cheat... This is not a backdoor!");
        } else {
            voted.map.put(username, new User(username));
        }

        Pet p = petService.getPet(id);
        if(p != null){
            petService.updatePet(pet);

        }

        return ResponseEntity.ok(pet);

    }

    @PutMapping("/dogs/{id}/up")
    public ResponseEntity<Object> updatePetUp(@PathVariable(name="id") Long id, Authentication authentication){

        String username = authentication.getName();

        VotedSingleton voted = VotedSingleton.getInstance();

        if(voted.map.containsKey(username)) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body("Don't cheat... You already voted!");
        } else {
            voted.map.put(username, new User(username));
        }

        Pet pet = petService.getPet(id);
        if(pet != null){
            pet.setVotes(pet.getVotes() + 1);
            petService.updatePet(pet);
        }

        return ResponseEntity.ok(pet);

    }

    @PutMapping("/dogs/{id}/down")
    public ResponseEntity<Object> updatePetDown(@PathVariable(name="id") Long id, Authentication authentication){

        String username = authentication.getName();

        VotedSingleton voted = VotedSingleton.getInstance();

        if(voted.map.containsKey(username)) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body("Don't cheat... You already voted!");
        } else {
            voted.map.put(username, new User(username));
        }

        Pet pet = petService.getPet(id);
        if(pet != null && pet.getVotes() > 0){
            pet.setVotes(pet.getVotes() - 1);
            petService.updatePet(pet);
        }

        return ResponseEntity.ok(pet);

    }

}
