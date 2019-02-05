package com.disney.studios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Hector R Acosta on 2/4/19.
 */
@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

}
