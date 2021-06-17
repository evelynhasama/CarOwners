package com.example.carowners;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application {

    public static ArrayList<Owner> owners;

    @Override
    public void onCreate() {
        super.onCreate();

        owners = new ArrayList<Owner>();
        owners.add(new Owner("Rachel Y", "Mercedes", "E180", "123342323"));
        owners.add(new Owner("Fiona H", "Volkswagen", "Polo", "678679252"));
        owners.add(new Owner("Joe M", "Mercedes", "E200", "678846765"));
        owners.add(new Owner("Jaime H", "Nissan", "Altima", "678234234"));
        owners.add(new Owner("Summer H", "Nissan", "Navara", "873342342"));
        owners.add(new Owner("Rianne A", "Mercedes", "Almera", "1576842353"));
        owners.add(new Owner("Amanda W", "Volkswagen", "Kombi", "123974232"));
        owners.add(new Owner("Kath W", "Mercedes", "E180", "576823423"));
    }
}
