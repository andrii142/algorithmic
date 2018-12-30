package main.codechef;

import java.io.IOException;
import java.util.Scanner;

public class BUYING2 {

    public static void main(String[] args) throws IOException {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();

        while (n > 0) {
            int numberOfBanknotes = sc.nextInt();
            int cakePrice = sc.nextInt();

            int minBanknote = sc.nextInt();
            int moneySum = minBanknote;

            for(int i = 1; i < numberOfBanknotes; i++) {
                int el = sc.nextInt();
                if (el < minBanknote) {
                    minBanknote = el;
                }

                moneySum += el;
            }

            int restOfMoney = moneySum % cakePrice;
            int res = restOfMoney > minBanknote ? -1 : moneySum / cakePrice;

            System.out.println(res);

            n--;
        }

        sc.close();
    }
}
