/*
Based on problem: https://www.hackerrank.com/contests/codesprint5/challenges/pennywise

Attempt at a Greedy Algorithm to either get the number number of coins that I can or to give the lowest valued coin

30% win rate
26.4 points out of 61.70 of top scorer
245th place out of 333
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int turn = in.nextInt();
        int hand = in.nextInt();
        int table = in.nextInt();
        if(table == 0){
            int least = in.nextInt();
            System.out.println(least + " 0");
        }else{
            ArrayList<Integer> coins = new ArrayList<Integer>();
            for(int i = 0; i < hand; i++){
                int c = in.nextInt();
                coins.add(c);
            }
            ArrayList<Integer> coins_table = new ArrayList<Integer>();
            for(int i = 0; i < table; i++){
                int c = in.nextInt();
                coins_table.add(c);
            }
            ArrayList<ArrayList<Integer>> played = new ArrayList<ArrayList<Integer>>();
            int to_play = coins.get(0);
            int size = 0;
            int index = 0;
            for(int i = 0; i < hand; i++){
                int coin = coins.get(i);
                played.add(new ArrayList<Integer>());
                int total = 0;
                for(int coin_t : coins_table){
                    if(total + coin_t < coin){
                        played.get(i).add(coin_t);
                        total += coin_t;
                    }
                }
                if(played.get(i).size() > size){
                    to_play = coin;
                    index = i;
                }
            }
            System.out.println(to_play + " " + played.get(index).size());
            for(int coin : played.get(index)){
                System.out.print(coin + " ");
            }
            System.out.println("");
        }
    }
}
