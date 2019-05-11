package com.imdb.user;


import com.imdb.imdb.Imdb;

import java.util.Scanner;
public class UserSignIn {

    private Scanner scanner = new Scanner(System.in);
    private String username;
    private String password;
    private User user;

    public UserSignIn(){
        System.out.print("Username :");
        this.username = scanner.nextLine();
        System.out.print("Password:");
        this.password = scanner.nextLine();
    }

    public UserSignIn(String username, String password){
        this.username = username;
        this.password = password;
    }
    public  void signIn(){
        if(checkSignInInfo()){
            System.out.print("You just Signed In !!");
            new Imdb(user);
        }
    }
    private boolean checkSignInInfo(){
        for (int i = 0; i < UserKeeper.LOGGED_USERS.size() ; i++) {
            if(this.username.equals(UserKeeper.LOGGED_USERS.get(i).getUsername()) && this.password.equals(UserKeeper.LOGGED_USERS.get(i).getPassword())){
                this.user = UserKeeper.LOGGED_USERS.get(i);
                return true;
            }
        }
        return false;
    }
}
