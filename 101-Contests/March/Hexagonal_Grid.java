/*
Based on problem: https://www.hackerrank.com/contests/101mar14/challenges/hexagonal-grid

Create the board into a 2D array

For each index going from left to right, places a tile in the following priorities then go to the next index
vertical, slanted to the right, horizontal, quit if there is an open space and no tile can go in it, no tile placed

In the contest, I accidently had a 4th tile that was slanted to the left and I had the horizontal have a
higher priority to the tile that was slanted to the right. This caused me to fail the majority of test cases,
and after I changed these two things I had a perfect score.

solve() function goes into the Template's solve() function 
(https://github.com/robertzi7/Hackerrank/blob/master/Template.java)
*/

static void solve()
{
  for(int T = ni();T >= 1;T--){
	  int n = ni();
    char[][] board = nm(2,n);
    boolean print = false;
    for(int i = 0; i < n; i++){
      if(board[0][i] == board[1][i]){
        if(board[0][i] == '0'){
          board[0][i] = '2';
          board[1][i] = '2';
        }
      }else{
        if(board[0][i] == '0'){
          if(i < n-1 && board[0][i+1] == '0'){
            board[0][i] = '2';
            board[0][i+1] = 2;
          }else{
            print = true;
            out.println("NO");
            break;
          }
        }else if(board[1][i] == '0'){
          if(i < n-1 && board[0][i+1] == '0'){
            board[1][i] = '2';
            board[0][i+1] = '2';
          }else if(i < n-1 && board[1][i+1] == '0'){
            board[1][i] = '2';
            board[1][i+1] = 2;
          }else{
            print = true;
            out.println("NO");
            break;
          }
        }
      }
    }
    if(!print)
      out.println("YES");
    }
}
