package TowerBreakers;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'towerBreakers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     */

    public static int towerBreakers(int n, int m) {
        int [] towers = new int[n];
        int winner = 2;
        int higherHeight = m;
        int destroyedTowers = 0;
        int divisor = 2;
        int i = 0;

        for (; i < n; i++)
            towers[i] = m;

        i = 0;
        while (higherHeight > 1) {
            if (winner == 2)
                winner = 1;
            else
                winner = 2;

            if (destroyedTowers >= n-1)
                return winner;

            if (n % 2 == 0) {
                while (towers[i] % divisor != 0)
                    divisor += 1;
            } else
                divisor = m;
            towers[i] = towers[i]/divisor;


            if (towers[i] <= 1)
                destroyedTowers += 1;

            i++;
            if (i >= n) {
                i = 0;
                divisor = 2;
                higherHeight = towers[i];
            }
        }

        return winner;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/TowerBreakers/input.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/TowerBreakers/output.txt"));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int result = Result.towerBreakers(n, m);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}