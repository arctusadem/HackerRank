package MiniMaxSum;

import java.io.*;
import java.lang.reflect.Array;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        int imenor = 0;
        int imaior = 0;
        int menor = arr.get(0);
        int maior = arr.get(0);
        long miniSum = 0;
        long maxSum = 0;
        List<Integer> miniSumArr = new ArrayList<>();
        List<Integer> maxSumArr = new ArrayList<>();


        for (int i = 0; i < arr.size(); i++) {
            miniSumArr.add(arr.get(i));
            maxSumArr.add(arr.get(i));
            if (menor < arr.get(i)) {
                menor = arr.get(i);
                imenor = i;
            } else if (maior > arr.get(i)) {
                maior = arr.get(i);
                imaior = i;
            }
        }

        miniSumArr.remove(imaior);
        maxSumArr.remove(imenor);

        for (int i = 0; i < 4; i++) {
            miniSum += miniSumArr.get(i);
            maxSum += maxSumArr.get(i);
        }
        System.out.println(maxSum + " " + miniSum);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/MiniMaxSum/input.txt"));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}