package com.imdb.admin;

import com.imdb.imdb.Imdb;


import java.util.Scanner;

public class AdminSignIn {

    private Scanner scanner = new Scanner(System.in);
    private String username;
    private String password;
    private Admin admin;

    public AdminSignIn(){ }

    public void RequestSignIn(){
        System.out.print("Username :");
        this.username = scanner.nextLine();
        System.out.print("Password:");
        this.password = scanner.nextLine();
        signIn(this.username, this.password);
    }

    public  void signIn(String username, String password){
        if(checkSignInInfo(username, password)){
            System.out.print("You just Signed In !!");
            new Imdb(admin);
        }
        else{
            System.out.println("The information is incorrect!! Try again(Insert 1) or leave (Insert 2)");
            int answer = scanner.nextInt();
            switch (answer){
                case 1:
                    RequestSignIn();
                    break;
                case 2:
                    return;
            }
        }
    }

    private boolean checkSignInInfo(String username, String password){
        if (username.equals(AdminKeeper.ADMIN.get(0).username) && password.equals(AdminKeeper.ADMIN.get(0).password)) {
            this.admin = AdminKeeper.ADMIN.get(0);
            return true;
        }
        return false;
    }
}
