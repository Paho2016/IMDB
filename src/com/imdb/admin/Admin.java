package com.imdb.admin;

import com.imdb.movie.cast.FilmMakingRole;
import com.imdb.movie.cast.Person;
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

    public void addNewContent(){
        addContent();
    }

    private void addContent() {

        System.out.print("Title of the film: ");
        String title = scanner.nextLine();

        System.out.print("Premiere of the film(yyyy-mm-dd format): ");
        LocalDate premiereDate = LocalDate.parse(scanner.nextLine());


        System.out.print("Number of genres: ");
        ArrayList<Genre> genres = new ArrayList<>();
        int genreNumber = scanner.nextInt();
        scanner.nextLine();


        for (Genre print: Genre.values()) {
            System.out.print(print + " ");
        }
        System.out.println();


        for (int i = 0; i < genreNumber; i++) {
            System.out.print("Genre Type: ");
            String add = scanner.nextLine();
            add = add.toUpperCase();
            genres.add(Genre.valueOf(add));
        }

        System.out.print("Description of the film: ");
        String description = scanner.nextLine();

        System.out.print("Number of people worked for the film: ");
        ArrayList<Person> people = new ArrayList<>();
        int staffNumber = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < staffNumber; i++) {
            addPerson();
        }


        Movie newMovie = new Movie(title, description, premiereDate, genres, people);
        MovieStorage.MOVIES.put(title, newMovie);
    }

    private Person addPerson() {

        System.out.print("Full name: ");
        String fullName = scanner.nextLine();

        System.out.print("BirthDate name (yyyy-mm-dd format): ");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());

        System.out.print("Biography: ");
        String bio = scanner.nextLine();

        System.out.print("Number of  roles: ");
        ArrayList<FilmMakingRole> role = new ArrayList<>();

        int roleNumber = scanner.nextInt();
        scanner.nextLine();

        for (FilmMakingRole print: FilmMakingRole.values()) {
            System.out.print(print + " ");
        }
        System.out.println();

        for (int i = 0; i < roleNumber; i++) {
            System.out.print("Role Type: ");
            String add = scanner.nextLine();
            add = add.toUpperCase();
            role.add(FilmMakingRole.valueOf(add));
        }

        System.out.println("Number of  films participated: ");
        ArrayList<String> movies = new ArrayList<>();

        int filmNumber = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < filmNumber; i++) {
            System.out.println("Film name: ");
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
