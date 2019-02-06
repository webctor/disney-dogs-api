package com.disney.studios;

import javax.persistence.*;

/**
 * Created by Hector R Acosta on 2/4/19.
 */
/*
THIS ENTITY MAPS TO A TABLE IN A RELATIONAL DATABASE. IN THIS CASE,
WE ARE USING AN IN-MEMORY H2 DB. I LIKE SPECIFYING THE NAME OF THE
TABLE AND COLUMNS, EVEN THOUGH IT IS NOT NECESSARY. THIS WAY IF YOU
HAVE TO CREATE A COMPLEX QUERY, THEN YOU CAN DO IT EASILY.
 */
@Entity
@Table(name="DOG")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PICTURE")
    private String picture;

    @Column(name = "BREED")
    private String breed;

    @Column(name = "VOTES")
    private int votes = 0;

    public Pet() {}

    public Pet(String breed, String picture) {
        this.breed = breed;
        this.picture = picture;
    }

    public Pet(Long id, String breed, String picture, int votes) {
        this.breed = breed;
        this.picture = picture;
        this.id = id;
        this.votes = votes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getBreed() {
        return breed.toLowerCase();
    }

    public void setBreed(String breed) {
        this.breed = breed.toLowerCase();
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
}
