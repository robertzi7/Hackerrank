/*
Based on problem: https://www.hackerrank.com/contests/101mar14/challenges/rectangular-game

Finds the minimum x-coordinate and minimum y-coordinate out of all inputs then the result is their product

Perfect Score

solve() function goes into the Template's solve() function 
(https://github.com/robertzi7/Hackerrank/blob/master/Template.java)
*/

static void solve() {
  long min_x = Long.MAX_VALUE;
  long min_y = Long.MAX_VALUE;
  for(int T = ni();T >= 1;T--){
	  long x = nl();
    long y = nl();
      if(x < min_x)
        min_x = x;
      if(y < min_y)
        min_y = y;
  }
  out.println(min_x*min_y);
}
