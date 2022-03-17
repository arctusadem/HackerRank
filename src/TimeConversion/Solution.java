package TimeConversion;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) throws ParseException {
        String inputPattern = "hh:mm:ssaa";
        String outputPattern = "HH:mm:ss";

        SimpleDateFormat simpleInputDateFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat simpleOutputDateFormat = new SimpleDateFormat(outputPattern);

        Date date = simpleInputDateFormat.parse(s);

        return simpleOutputDateFormat.format(date);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/TimeConversion/input.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/TimeConversion/output.txt"));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

