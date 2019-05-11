package com.imdb.movie;

import java.time.LocalDate;
import java.util.ArrayList;

import com.imdb.cast.Person;

public  class Movie {

    protected String title;
    protected String description;
    protected LocalDate premiereDate;
    protected ArrayList<Genre> genre;
    private ArrayList<Person> people;
    private double currentRating = currentRating();
    public static ArrayList<Integer> RATING = new ArrayList<>();


    public Movie(String title, String description, LocalDate premiereDate, ArrayList<Genre> genres, ArrayList<Person> people) {
        this.title = title;
        this.description = description;
        this.premiereDate = premiereDate;
        this.genre = genres;
        this.people = people;
    }

    public void rateMovie(Integer rate){
        this.RATING.add(rate);
    }

    public double currentRating() {
        double rating;
        double sum = 0;

        for (int i = 0; i < this.RATING.size() ; i++) {
            sum += this.RATING.get(i);
        }
        rating = sum/(this.RATING.size());
        return rating;
    }

    @Override
    public String toString() {
        return String.format("Movie title: %f.\nRating: %f.\nGenre: %f. \nPremiere date: %f.\nDescription: %f.", title, currentRating, genre, premiereDate, description);
    }
}
