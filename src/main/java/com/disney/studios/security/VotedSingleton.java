package com.disney.studios.security;

import java.util.HashMap;

/**
 * Created by Hector R Acosta on 2/5/19.
 */
/*
THIS IS A SINGLETON THAT CAN BE USED TO ACCESS A MAP.
AT FIRST, I WANTED THIS TO BE A LIST, BUT IT IS IMPORTANT
TO THINK IN SCALABILITY. WHAT HAPPENS WHEN OUR APPLICATION
GROWS... A HASH IS MORE EFFICIENT TO LOOK FOR ELEMENTS VIA
A KEY. IN THIS CASE, THE USERNAME FUNCTIONS AS THE KEY, AND
THE VALUE IS THE USER OBJECT ITSELF.
 */
public class VotedSingleton {

    private static VotedSingleton instance;
    public HashMap<String, User> map = new HashMap<String, User>();

    private VotedSingleton(){}

    //static block initialization for exception handling
    static{
        try{
            instance = new VotedSingleton();
        }catch(Exception e){
            throw new RuntimeException("Exception occurred in creating singleton instance");
        }
    }

    public static VotedSingleton getInstance(){
        return instance;
    }
}