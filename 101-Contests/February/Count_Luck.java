/*
Based on problem: https://www.hackerrank.com/contests/101feb14/challenges/count-luck

Used a modification of Pacman-DFS [so many of the same variable names to save time during contest] 
where instead of keeping track of every  index of the path, I simply keep an int of the number of times 
that the total numbers of times  that one could take a number of paths greater than one

Perfect Score
*/

import java.util.*;

public class Solution {
	static boolean[][] traveled;
	static boolean found = false;
  static int turns = 0;
  
	static boolean dfs(int x, int y, int pacman_x, int pacman_y, int food_x, int food_y, String [] grid){
       
    //Mark the square I have arrived to as traveled to
    traveled[pacman_x][pacman_y] = true;
        
    //For storing each valid adjacent edge
    Stack<String> total = new Stack<String>();
        
    //Check to see if we are at the food node
		if(pacman_x == food_x && pacman_y == food_y){
      return true;
		}
        
    //If we are not at the food node
		if(found == false){    
            
      //Populate the stack with each valid adjacent node
      if(pacman_x-1 >= 0 && grid[pacman_x-1].charAt(pacman_y) != 'X' && traveled[pacman_x-1][pacman_y] == false){
				total.add("UP");
        traveled[pacman_x-1][pacman_y] = true;
      }
      if(pacman_y-1 >= 0 && grid[pacman_x].charAt(pacman_y-1) != 'X' && traveled[pacman_x][pacman_y-1] == false){
				total.add("LEFT");
        traveled[pacman_x][pacman_y-1] = true;
      }
      if(pacman_y+1 < y && grid[pacman_x].charAt(pacman_y+1) != 'X' && traveled[pacman_x][pacman_y+1] == false){
				total.add("RIGHT");
        traveled[pacman_x][pacman_y+1] = true;
      }
      if(pacman_x+1 < x && grid[pacman_x+1].charAt(pacman_y) != 'X' && traveled[pacman_x+1][pacman_y] == false){
				total.add("DOWN");
        traveled[pacman_x+1][pacman_y] = true;
      }
            
      //If greater than 1, we will increment the solution if we are on the correct path
      int total_size = total.size();
            
      //If there is at least one valid adjacent node
      if(!total.empty()){
        String direction = total.pop(); //Get the first node
                
        //Check each possibility in the order that they would be in in the stack
        //If it is the direction first recurse into that node
        //To see if it leads to the food
        //If it does add it to the path
        //If not, then if there are still adjacent nodes then get the next node.
        if(direction.contains("DOWN") && found == false){
          found = dfs(x, y, pacman_x+1, pacman_y, food_x, food_y, grid);
          if(found == true){
            if(total_size > 1)
              turns++;
            total = new Stack<String>();
          }
          if(!total.empty() && found == false)
            direction = total.pop();
        }
        if(direction.contains("RIGHT")&& found == false){
          found = dfs(x, y, pacman_x, pacman_y+1, food_x, food_y, grid);
          if(found == true){
            if(total_size > 1)
              turns++;
            total = new Stack<String>();
          }
          if(!total.empty() && found == false)
            direction = total.pop();
        }
        if(direction.contains("LEFT")&& found == false){
          found = dfs(x, y, pacman_x, pacman_y-1, food_x, food_y, grid);
          if(found == true){
            if(total_size > 1)
              turns++;
            total = new Stack<String>();
          }
          if(!total.empty() && found == false)
            direction = total.pop();
        }
        if(direction.contains("UP")&& found == false){
          found = dfs(x, y, pacman_x-1, pacman_y, food_x, food_y, grid);
          if(found == true){
            if(total_size > 1)
              turns++;
            total = new Stack<String>();
          }
        }
      }else{
        return false; //This can't contain the path to the food
      }
		}
    return found;
	}
  
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int tests = in.nextInt();
        for(int i = 0; i < tests; i++){  
            found = false;
            int x = in.nextInt();
			int y = in.nextInt();
			int location_x = 0;
			int location_y = 0;
			int goal_x = 0;
			int goal_y = 0;
			String grid[] = new String[x];
			for(int j = 0; j < x; j++) {
				grid[j] = in.next();
        if(grid[j].contains("*")){
          goal_x = j;
          goal_y = grid[j].indexOf("*");
        }
        if(grid[j].contains("M")){
          location_x = j;
          loaction_y = grid[j].indexOf("M");
        }
			}
      int k = in.nextInt();
			traveled = new boolean[x][y];
      turns = 0;
			dfs( x, y, loaction_x, loaction_y, goal_x, goal_y, grid);
	    if(turns == k){
        System.out.println("Impressed");
      }else{
        System.out.println("Oops!");
      }
    }
	}
}
