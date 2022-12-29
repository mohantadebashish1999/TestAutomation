package com.automations.testcases;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import com.github.javafaker.Faker;

public class Testfaker {
    public static void main(String args[])
   {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Faker faker = new Faker();
   
    String dob = sdf.format(faker.date().birthday());
    System.out.println("date of birth is: " + dob);
   
    }
    
}
