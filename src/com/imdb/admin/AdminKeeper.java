package com.imdb.admin;


import java.util.ArrayList;

public class AdminKeeper {

    protected static ArrayList<Admin> ADMIN = new ArrayList<>();
    static {
        ADMIN.add(new Admin());
    }
}
