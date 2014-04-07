/*
Based on problem: https://www.hackerrank.com/contests/101jan14/challenges/harry-potter-and-the-floating-rocks

The answer is the GCD of the absolute value of the difference betweed the x and y corrdinates.
Then subtract one because we want to ignore both ends of the line, not just one

Perfect Score
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static long gcd(long a, long b) { return b==0 ? a : gcd(b, a%b); }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        for(int i = 0; i < num; i++){
            long ha_x = in.nextLong();
            long ha_y = in.nextLong();
            long he_x = in.nextLong();
            long he_y = in.nextLong();
            long a = Math.abs(ha_x-he_x);
            long b = Math.abs(ha_y-he_y);
            System.out.println(gcd(a,b)-1);
        }
    }
}
