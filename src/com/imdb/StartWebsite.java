package com.imdb;

import com.imdb.admin.AdminSignIn;
import com.imdb.user.Registration;
import com.imdb.user.UserSignIn;

import java.util.Scanner;

public class StartWebsite {

    private Scanner scanner = new Scanner(System.in);

    StartWebsite(){}

    public void doSomething() {

        System.out.println("Who are you ? (Standard User or Admin)");
        String user = scanner.nextLine();

        if (user.toLowerCase().replace(" ", "").equals("standarduser")) {
            System.out.println("What you want to do ? (Sign In , Sign Up)");
            String sign = scanner.nextLine();
            if (sign.toLowerCase().replace(" ", "").equals("signup")) {
                register();
            }
            else if (sign.toLowerCase().replace(" ", "").equals("signin")){
                signIn();
            }
        } else if (user.toLowerCase().replace(" ", "").equals("admin")) {
                adminSignIn();
        }
        else{
            doSomething();
        }

    }

    public void register () {
        Registration registration = new Registration();
        registration.register();
    }

    public  void signIn(){
        UserSignIn signIn = new UserSignIn();
        signIn.signIn();
    }
    public  void adminSignIn(){
        AdminSignIn adminSignIn = new AdminSignIn();
        adminSignIn.RequestSignIn();
    }
}

