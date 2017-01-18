package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HORSES {
    private static int[] numbers;

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

            QuickSort.sort(input);
            input = QuickSort.numbers;

            int min = input[1] - input[0];
            for (int i = 1; i < input.length - 1; i++) {
                int cur = input[i + 1] - input[i];
                if (cur < min) min = cur;
            }

            System.out.println(min);

            n--;
        }
    }


}
