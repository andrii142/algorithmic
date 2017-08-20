package java.eolymp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuadraticEquation {

    private static Integer[] converter(String[] input) {
        Integer[] res = new Integer[input.length];

        for (int i = 0; i < res.length; i++)
            res[i] = Integer.valueOf(input[i]);

        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer[] in = converter(br.readLine().split(" "));


        int p = in[1] * in[1] - 4 * in[0] * in[2];

        if (p < 0) {
            System.out.println("No roots");
            return;
        }

        int x1 = (int) (-in[1] - Math.sqrt(p)) / (2 * in[0]);
        int x2 = (int) (-in[1] + Math.sqrt(p)) / (2 * in[0]);

        if (p == 0) {
            System.out.println("One root: " + x1);
            return;
        }

        if (x2 < x1) {
            int tmp = x2;
            x2 = x1;
            x1 = tmp;
        }

        System.out.println("Two roots: " + x1 + " " + x2);
    }
}