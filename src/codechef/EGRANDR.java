package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Andrey on 7/9/16.
 */
public class EGRANDR {

    private static int[] converter(String[] input) {
        int[] output = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            output[i] = Integer.parseInt(input[i]);
        }

        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        while (n > 0) {
            int k = Integer.parseInt(reader.readLine());
            int[] input = converter(reader.readLine().split(" "));

            boolean isStipendium = false;
            int sum = 0;

            for (int i : input) {
                if(i == 2) {
                    isStipendium = false;
                    break;
                }

                if (i == 5)
                    isStipendium = true;

                sum += i;
            }

            double avr = (double) sum / (double) input.length;

            if (avr >= 4.0 && isStipendium)
                System.out.println("Yes");
            else System.out.println("No");

            n--;
        }
    }

}