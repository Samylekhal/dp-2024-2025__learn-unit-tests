package fr.anthonyquere.fizzbuzz;

import java.util.List;
import java.util.ArrayList;

public class FizzBuzz {

    public static void main(String[] args) {
        System.out.println("Hello, World!");

        List<String> fizzBuzz = startFizzBuzz(15);
        fizzBuzz.forEach(System.out::println);
    }

    public static List<String> startFizzBuzz(int count) {
        List<String> liste = new ArrayList<String>();

        if (count == 0) {
            return liste;
        }
        else {
            for (int i = 1 ; i <= count; i++){
                if(i % 3 == 0 && i  % 5 == 0){
                    liste.add("FizzBuzz");
                }
                else if(i % 3 == 0){
                    liste.add("Fizz");
                }
                else if(i % 5 == 0){
                    liste.add("Buzz");
                }
                else{
                    liste.add("le reste");
                }

            }
            return liste;
        }
    }
}



