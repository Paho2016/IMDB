package com.imdb.movie.cast;

import java.time.LocalDate;
import java.util.ArrayList;

public class Person {

    private final String fullName;
    private final LocalDate birthDate;
    private String biography;
    private ArrayList<FilmMakingRole> role;
    private ArrayList<String> movies;

    public Person(String fullName, LocalDate birthDate, String biography, ArrayList<FilmMakingRole> role, ArrayList<String> movies) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.biography = biography;
        this.role = role;
        this.movies = movies;
    }


}