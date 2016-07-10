import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CHEFELEC {

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
            int[] electricity = converter(reader.readLine().split(""));
            int[] coordinates = converter(reader.readLine().split(" "));

            int firstPosWithElectricity = 0;

            long wires = 0;

            long leftPath;
            long rightPath = 0;

            for (int i = 0; i < coordinates.length; i++) {
                if (electricity[i] == 1 && i == 0) {
                    firstPosWithElectricity = 0;
                    break;
                }

                if (i != 0)
                    wires += coordinates[i] - coordinates[i - 1];

                if (electricity[i] == 1 && i != 0) {
                    firstPosWithElectricity = i;
                    break;
                }
            }

            for (int i = firstPosWithElectricity + 1; i < coordinates.length; i++) {
                if (electricity[i] == 0) {
                    rightPath = 0;
                    leftPath = coordinates[i] - coordinates[i - 1];

                    while (true) {
                        if (i + 1 >= coordinates.length) break;

                        if (electricity[i + 1] == 1) {
                            rightPath = coordinates[i + 1] - coordinates[i];
                            break;
                        } else {
                            wires += coordinates[i + 1] - coordinates[i];
                            rightPath = 0;
                            i++;
                        }
                    }

                    if (rightPath == 0 || leftPath < rightPath) wires += leftPath;
                    else wires += rightPath;

                }
            }

            System.out.println(wires);

            n--;
        }
    }

}
