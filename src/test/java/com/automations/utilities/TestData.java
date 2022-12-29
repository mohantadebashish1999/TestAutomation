package com.automations.utilities;

import java.text.SimpleDateFormat;

import com.github.javafaker.Faker;

public class TestData {
    static Faker faker = new Faker();

    public static String GenerateFirstName()
    {
        String fakerFirstName = faker.name().firstName();
        return fakerFirstName;
    }

    public static String GenerateLastName()
    {
        String fakerLastName = faker.name().lastName();
        return fakerLastName;
    }
    public static String GenerateDOB()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fakerDOB = sdf.format(faker.date().birthday());
        return fakerDOB;

    }
    public static String GenerateZipCode()
    {
        String fakerZipcode = faker.address().zipCode();
        return fakerZipcode;
    }
    public static String GenerateStreet()
    {
        String fakerStreet = faker.address().streetAddress();
        return fakerStreet;
    }
    public static String GenerateHouseNumber()
    {
        String fakerHousenumber = faker.address().buildingNumber();
        return fakerHousenumber;

    }
    public static String GenerateLocation()
    {
        String fakerlocation = faker.address().city();
        return fakerlocation;

    }
    public static String GeneratePhoneNumber()
    {
        String fakerPhoneNumber = faker.phoneNumber().phoneNumber();
        return fakerPhoneNumber;

    }
    
    /* 
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        static Faker faker = new Faker();
            String fakerFirstName = faker.name().firstName();
            String fakerLastName = faker.name().lastName();
            //String fakerDOB = faker.date().past(1, TimeUnit.DAYS).toString();
            String fakerDOB = sdf.format(faker.date().birthday());
            String fakerZipcode = faker.address().zipCode();
            String fakerStreet = faker.address().streetAddress();
            String fakerHousenumber = faker.address().buildingNumber();
            String fakerlocation = faker.address().city();
            String fakerPhoneNumber = faker.phoneNumber().phoneNumber();
    
     */
     
    
}
