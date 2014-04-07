/*
Based on problem: https://www.hackerrank.com/contests/codesprint5/challenges/is-fibo

1. Generate all Fibbonacci Numbers that don't result in an overflow and make the list into a string
2. Check to see if the number exists in the string

Perfect Score
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        long[] fib = new long[100000];
        fib[0] = 1;
        fib[1] = 1;
        for(int i = 2; i < 100000; i++){
            fib[i] = fib[i-1] + fib[i-2];
            if(fib[i] < 0){
                break;
            }
        }
        String s = Arrays.toString(fib);
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        in.nextLine();
        for(int k = 0; k < num; k++){
            String j = in.nextLine();
            if(s.contains(" " + j + ","))
                System.out.println("IsFibo");
            else
                System.out.println("IsNotFibo");
        }
            
    }
