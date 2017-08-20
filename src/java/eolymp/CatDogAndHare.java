package java.eolymp;


import java.util.Scanner;


public class CatDogAndHare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        Integer[] inputInt = new Integer[input.length];

        for (int i = 0; i < input.length; i++)
            inputInt[i] = Integer.valueOf(input[i]);

        double cat = (double) (inputInt[0] - inputInt[1] + inputInt[2]) / 2;
        double dog = (double) (inputInt[0] + inputInt[1] - inputInt[2]) / 2;
        double hare = (double) (-inputInt[0] + inputInt[1] + inputInt[2]) / 2;


        System.out.printf("%.2f %.2f %.2f", cat, dog, hare);
    }
}
