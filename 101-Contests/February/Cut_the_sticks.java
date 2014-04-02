/*
Based on problem: https://www.hackerrank.com/contests/101feb14/challenges/cut-the-sticks

1. Get the array of ints
2. Sort the array
3. Keep an index of the lowest positive number
4. While that index is less than the length of the array
4a. Get the value at the index
4b. For all the values that are equal to the value, increase the index by 1 (as it will become zero)
4c. For all the values that are greater than zero, subtract it by the previously gotten value and increase a
solution variable by one
4d. Once when all the values are gone through, output the solution variable

Perfect Score

solve() function goes into the Template's solve() function 
(https://github.com/robertzi7/Hackerrank/blob/master/Template.java)
*/

static void solve(){
  int num = ni();
  int index = 0;
  int[] sticks = na(num);
  Arrays.sort(sticks);
  while(index < num){
    int cut = sticks[index];
    int next_index = 0;
    int sol = 0;
    for(int i = 0; i < num; i++){
        if(sticks[i] == cut){
            next_index++;
        }
        if(sticks[i] > 0){
            sticks[i] -= cut;
            sol++;
        }
    }
    out.println(sol);
    index += next_index;
  }
}
