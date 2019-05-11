package com.imdb.user;

import java.util.Scanner;

public class Registration extends  UserKeeper{

    Scanner scanner = new Scanner(System.in);

    public static final int MAX_PASSWORD_LENGTH = 10;
    public static final int MAX_USERNAME_LENGTH = 25;

    private String username;
    private String password;
    public  Registration(){ }

    public  void register(){
        System.out.print("Think a username for you (MAX: 10 symbol) ");
        this.username = scanner.nextLine();
        System.out.print("Think a password for you (MAX: 25 symbol)");
        this.password = scanner.nextLine();
        createUser(this.username, this.password);
    }

    public void createUser(String username, String password){
        if(checkRegistration(username, password)){
            System.out.println("Congratulations " +   username + "!! You have registered successfully");
            UserKeeper.USERS.put(username, password);
            UserKeeper.LOGGED_USERS.add(new User(username, password));

        }
        else{
            System.err.println("You failed registration");
        }

        UserSignIn sign = new UserSignIn(username, password);
        sign.signIn();
    }


    private boolean checkRegistration(String username, String password){

        if(username.length() > MAX_USERNAME_LENGTH || password.length() > MAX_PASSWORD_LENGTH){
            System.err.println("Your username or password is larger");
            return false;
        }
        for (String uName: UserKeeper.USERS.keySet()) {
            if(username.equals(uName)){
                System.err.println(username + " This username already exists");
                return false;
            }
        }

        for (String uPass:UserKeeper.USERS.values()) {

            if(password.equals(uPass)){
                System.err.print(password + " This password already exists");
                return false;
            }
        }

        return true;
    }
}
