/*
Based on problem: https://www.hackerrank.com/contests/101jan14/challenges/filling-jars

1. Keep a variable for the sum of each line.
2. For each line, add the total number of candies being added
3. At the end, output by the total sum divided by the number of lines

Perfect Score
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long m = in.nextLong();
        long sum = 0;
        for(int i = 0; i < m; i++){
            long a = in.nextLong();
            long b = in.nextLong();
            long k = in.nextLong();
            sum += k*(b-a+1);
        }
        System.out.println(sum/n);
    }
}
