package com.disney.studios;

import java.util.List;

/**
 * Created by Hector R Acosta on 2/4/19.
 */
public interface PetService {

    public List<Pet> retrievePets();

    public Pet getPet(Long id);

    public void savePet(Pet pet);

    public void deletePet(Long id);

    public void updatePet(Pet pet);

}
