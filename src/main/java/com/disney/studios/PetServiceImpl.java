package com.disney.studios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Hector R Acosta on 2/4/19.
 */
@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepository petRepository;

    public void setPetRepository(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<Pet> retrievePets() {
        List<Pet> pets = petRepository.findAll();
        return pets;
    }

    public Pet getPet(Long id) {
        Optional<Pet> optPet = petRepository.findById(id);
        return optPet.get();
    }

    public void savePet(Pet pet){
        petRepository.save(pet);
    }

    public void deletePet(Long id){
        petRepository.deleteById(id);
    }

    public void updatePet(Pet pet) {
        petRepository.save(pet);
    }
}
