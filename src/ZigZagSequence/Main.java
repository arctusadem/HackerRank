package ZigZagSequence;

import java.util.Arrays;
import java.util.Scanner;
public class Main {

    //Debug exercise with max of 3 lines of change to make algorithm work

    public static void main (String[] args) throws java.lang.Exception {
        /*
        Input example:
        1
        7
        1 2 3 4 5 6 7
        */
        Scanner kb = new Scanner(System.in);
        int test_cases = kb.nextInt();
        for(int cs = 1; cs <= test_cases; cs++){
            int n = kb.nextInt();
            int a[] = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = kb.nextInt();
            }
            findZigZagSequence(a, n);
        }
    }

    public static void findZigZagSequence(int [] a, int n){
        Arrays.sort(a);
        //(n - 1) changed to n
        int mid = n/2;
        int temp = a[mid];
        a[mid] = a[n - 1];
        a[n - 1] = temp;

        int st = mid + 1;
        //n - 1 changed to n - 2
        int ed = n - 2;
        while(st <= ed){
            temp = a[st];
            a[st] = a[ed];
            a[ed] = temp;
            st = st + 1;
            //ed + 1 changed to ed - 1
            ed = ed - 1;
        }
        for(int i = 0; i < n; i++){
            if(i > 0) System.out.print(" ");
            System.out.print(a[i]);
        }
        System.out.println();
    }
}