/*
Based on problem: https://www.hackerrank.com/contests/101feb14/challenges/sherlock-and-pairs

1. Get the array of ints
2. Sort the array
3. For each index
3a. Keep a variable for the number of elements that have the same value
3b. When we have reached a number that is not the same value, add the number of (n choose 2) * 2 to the solution
    The *2 is due to (Ai,Aj) and (Aj,Ai) being considered unique
4. At the end of the loop, make sure that the last number gets counted in the solution then output the result

Perfect Score

solve() function goes into the Template's solve() function 
(https://github.com/robertzi7/Hackerrank/blob/master/Template.java)
*/

static void solve(){
  int tests = ni();
  for(int z = 0; z < tests ; z++){
    int size = ni();
    int[] array = na(size);
    Arrays.sort(array);
    long sol = 0;
    long pair = 1;
    for(int i = 1; i < size; i++){
      if(array[i] == array[i-1]){
        pair += 1;
      }else{
        sol += pair*(pair-1);
        pair = 1;
      }
    }
    if(pair > 1)
      sol += pair*(pair-1);
    out.println(sol);
  }
}
