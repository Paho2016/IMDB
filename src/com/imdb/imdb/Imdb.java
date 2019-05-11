package com.imdb.imdb;

import com.imdb.admin.Admin;
import com.imdb.user.User;
import com.imdb.movie.Movie;
import com.imdb.movie.MovieStorage;

import java.util.Scanner;

public class Imdb {

    private Scanner scanner = new Scanner(System.in);
    private User user;
    private Admin admin;
    private Command command;

    public Imdb(User user){
        this.user = user;
        startMessageforUser();
    }
    public Imdb(Admin admin){
        this.admin = admin;
        startMessageforAdmin();
    }
    void startMessageforUser(){
        System.out.println("What do you want to do? \n" + command.SEARCH + " a movie \n" +  command.RATE + " a movie ");
        String commandReader = scanner.nextLine();
        if (commandReader.toUpperCase().equals(command.SEARCH)) {
            System.out.print("Type the title of the film: ");
            Movie searchedMovie =  searchMovie(scanner.nextLine());
            searchedMovie.toString();
        }
        else if(commandReader.toUpperCase().equals(command.RATE)){
            System.out.print("Type the title of the film you want to rate: ");
            String movie  = scanner.nextLine();
            user.rateMovie(MovieStorage.MOVIES.get(movie));
        }
        System.out.println("Do you want to do another action (yes / sth else");
        String answer = scanner.nextLine();
        if(answer.toLowerCase().equals("yes")){
            startMessageforUser();
        }else{return;}
    }

    void startMessageforAdmin(){
        System.out.println("What do you want to do? \n SEARCH a movie \n ADD a content ");
        String commandReader = scanner.nextLine();

        if (command.valueOf(commandReader.toUpperCase()).equals(command.SEARCH)) {
            System.out.print("Type the title of the film: ");
            Movie searchedMovie =  searchMovie(scanner.nextLine());
            searchedMovie.toString();
        }
        else if(command.valueOf(commandReader.toUpperCase()).equals(command.ADD)){

            this.admin.addNewContent();
            System.out.println("Do you want to add another Content? (yes / sth else");
            String answer = scanner.nextLine();
            if(answer.toLowerCase().equals("yes")){
                this.admin.addNewContent();
            }
            else { return; }
        }
        System.out.println("Do you want to do another action (yes / sth else");
        String answer = scanner.nextLine();
        if(answer.toLowerCase().equals("yes")){
            startMessageforAdmin();
        }else{return;}
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
