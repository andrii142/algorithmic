package eolymp.java;


import java.util.Scanner;

//https://www.e-olymp.com/en/contests/7715/problems/64103
public class CatDogAndHare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        Integer[] inputInt = new Integer[input.length];

        for (int i = 0; i < input.length; i++)
            inputInt[i] = Integer.valueOf(input[i]);

        int t2inMins = (inputInt[0] * inputInt[0] * 60) / inputInt[1];


        System.out.printf(t2inMins / 60 + " " + t2inMins % 60);
    }
}
