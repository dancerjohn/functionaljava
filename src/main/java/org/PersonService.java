package org;

public class PersonService {

    public static void printFirstName(Person person){
        System.out.println(person.getFirstName());
    }


    public static void print(Person person){
        System.out.println(person.toString());
    }
}
