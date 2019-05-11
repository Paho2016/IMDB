package com.imdb.admin;

import com.imdb.cast.FilmMakingRole;
import com.imdb.cast.Person;
import com.imdb.movie.Genre;
import com.imdb.movie.Movie;
import com.imdb.movie.MovieStorage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    private Scanner scanner = new Scanner(System.in);
    protected static String username = "Tigran_Jomardyan";
    protected static String password = "admin.Tigran.111";

    Admin(){}

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

    public void addNewContent(){
        addContent();
    }

    private void addContent() {
        String title = scanner.nextLine();
        String description = scanner.nextLine();
        LocalDate premiereDate = LocalDate.parse(scanner.nextLine());
        ArrayList<Genre> genres = new ArrayList<>();

        System.out.print("Number of genres: ");
        int genreNumber = scanner.nextInt();
        for (int i = 0; i < genreNumber; i++) {
            genres.add(Genre.valueOf(scanner.nextLine()));
        }

        ArrayList<Person> people = new ArrayList<>();

        System.out.print("Number of people worked for the film: ");
        int staffNumber = scanner.nextInt();
        for (int i = 0; i < staffNumber; i++) {
            addPerson();
        }

        Movie newMovie = new Movie(title, description, premiereDate, genres, people);

        MovieStorage.MOVIES.put(title, newMovie);
    }

    private Person addPerson() {

        System.out.println("Full name: ");
        String fullName = scanner.nextLine();

        System.out.println("BirthDate name: ");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());

        System.out.println("Biography: ");
        String bio = scanner.nextLine();

        System.out.println("Number of  roles: ");
        ArrayList<FilmMakingRole> role = new ArrayList<>();

        int roleNumber = scanner.nextInt();
        for (int i = 0; i < roleNumber; i++) {
            role.add(FilmMakingRole.valueOf(scanner.nextLine()));
        }

        System.out.println("Number of  films participated: ");
        ArrayList<String> movies = new ArrayList<>();

        int filmNumber = scanner.nextInt();
        for (int i = 0; i < filmNumber; i++) {

            String film = scanner.nextLine();

            for (String s : MovieStorage.MOVIES.keySet()) {
                if (s.equals(film)) {
                    movies.add(s);
                }
            }
        }
       return new Person(fullName, birthDate, bio, role, movies);
    }
}
