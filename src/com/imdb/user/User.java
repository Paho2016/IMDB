package com.imdb.user;

import com.imdb.movie.Movie;
import com.imdb.movie.MovieStorage;

import java.util.Scanner;

public  class User {


    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    public  void rateMovie(Movie movie){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Make your rate with points 1-10 ");
        movie.rateMovie(scanner.nextInt());
    }

    public Movie searchMovie(String title) {
        for (int i = 0; i < MovieStorage.MOVIES.size(); i++) {

            try {
                MovieStorage.MOVIES.get(title);
            } catch (Exception IllegalArgumentException) {
                throw new IllegalArgumentException("NO RESULT!");
            }
        }
        return MovieStorage.MOVIES.get(title);
    }
}
