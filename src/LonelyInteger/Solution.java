package LonelyInteger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'lonelyinteger' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int lonelyInteger(List<Integer> a) {
        List<Integer> l = a.stream().sorted().collect(toList());
        int lonelyI = 0;
        int i = 0;

        for (Integer o: l) {
            if (lonelyI != o && i == 1)
                return lonelyI;
            else if (lonelyI == o)
                i++;
            else {
                lonelyI = o;
                i = 1;
            }
        }

        return lonelyI;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/LonelyInteger/input.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/LonelyInteger/output.txt"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.lonelyInteger(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
