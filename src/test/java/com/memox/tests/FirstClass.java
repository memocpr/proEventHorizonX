package com.memox.tests;

import com.github.javafaker.Faker;

public class FirstClass {

    public static void main(String[] args) {


        System.out.println(" hi universe :) ");

        Faker faker = new Faker();
        System.out.println(faker.name().fullName());
    }

}
