/*
Based on problem: https://www.hackerrank.com/contests/codesprint5/challenges/matrix-tracing

1. Reconize that this is similar to finding the number of Manhattan Paths
2. Calculate (m+n-2 choose n-1) in an effecient manner

Perfect Score
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    static long[] array = new long[2000000];
    
    static long modInverse(long a, int n) {
        long i = n, v = 0, d = 1;
        while (a>0) {
            long t = i/a, x = a;
            a = i % x;
            i = x;
            x = d;
            d = v - t*x;
            v = x;
        }
        v %= n;
        if (v<0) 
            v = (v+n)%n;
        return v;
    }
    
    static long sol(int m, int n){
        if(n == 0)
            return 1;
        return ( ((sol(m-1,n-1)*m) % 1000000007) * modInverse(n, 1000000007) ) % 1000000007;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        for(int i = 0; i < num; i++){
            int m = in.nextInt();
            int n = in.nextInt();
            System.out.println((int)sol(m+n-2,n-1));
        }
    }
}
