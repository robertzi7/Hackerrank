/*
Based on problem: https://www.hackerrank.com/contests/codesprint5/challenges/special-multiple

1. For 1 to 500 (the contraints) get the binary form of the number and multiply it by 9
2. Check to see if any divisors of the number have not yet been assigned a value
2a. If it has already been assigned a value, we know that it will be lower than the current value
2b. If it has not yet been assigned a value, then assign it the mulitple
3. For each input, output the value at that index

Perfect Score
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        long[] array = new long[501];
        for(long i = 1; i < 5000; i++){
            long k = Long.parseLong(Long.toBinaryString(i));
            k *= 9;
            for(int j = 1; j < 501; j++){
                if(k % j == 0 && array[j] == 0)
                   array[j] = k;
            }
        }
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        for(int i = 0; i < num; i++){
            int k = in.nextInt();
            System.out.println(array[k]);
        }
    }
}
