package PlusMinus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        double positives = 0;
        double negatives = 0;
        double zeroes = 0;

        DecimalFormat df = new DecimalFormat("0.000000");

        for (int a: arr) {
            if (a > 0)
                positives +=1;
            else if (a < 0)
                negatives += 1;
            else
                zeroes += 1;
        }
            System.out.println(df.format(positives/arr.size()));
            System.out.println(df.format(negatives/arr.size()));
            System.out.println(df.format(zeroes/arr.size()));

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/PlusMinus/input.txt"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
