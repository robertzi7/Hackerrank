/*
Based on the following problem: https://www.hackerrank.com/challenges/pacman-dfs

Perfect score
*/

import java.util.*;

public class Solution {
	static Stack<String> current_path = new Stack<String>();
	static Stack<String> final_path = new Stack<String>();
	static boolean[][] traveled;
	static boolean found = false;
	/* Head ends here */
	static boolean dfs(int x, int y, int pacman_x, int pacman_y, int food_x, int food_y, String [] grid){
        //Mark the square I have arrived to as traveled to
        traveled[pacman_x][pacman_y] = true;
        
        //For storing each valid adjacent edge
        Stack<String> total = new Stack<String>();
        
        //Check to see if we are at the food node
		if(pacman_x == food_x && pacman_y == food_y){
			current_path.add(pacman_x + " " + pacman_y);
			final_path.add(pacman_x + " " + pacman_y);
            return true;
		}
        
        //If we are not at the food node
		if(found == false){    
            
            //Populate the stack with each valid adjacent node
            if(pacman_x-1 >= 0 && grid[pacman_x-1].charAt(pacman_y) != '%' && traveled[pacman_x-1][pacman_y] == false){
				total.add("UP");
                traveled[pacman_x-1][pacman_y] = true;
            }
            if(pacman_y-1 >= 0 && grid[pacman_x].charAt(pacman_y-1) != '%' && traveled[pacman_x][pacman_y-1] == false){
				total.add("LEFT");
                traveled[pacman_x][pacman_y-1] = true;
            }
            if(pacman_y+1 <= y && grid[pacman_x].charAt(pacman_y+1) != '%' && traveled[pacman_x][pacman_y+1] == false){
				total.add("RIGHT");
                traveled[pacman_x][pacman_y+1] = true;
            }
            if(pacman_x+1 <= x && grid[pacman_x+1].charAt(pacman_y) != '%' && traveled[pacman_x+1][pacman_y] == false){
				total.add("DOWN");
                traveled[pacman_x+1][pacman_y] = true;
            }
            
            //If there is at least one valid adjacent node
            if(!total.empty()){
                //The node we traveled to has an expansion so we add it to the path
                current_path.add(pacman_x + " " + pacman_y);
                String direction = total.pop(); //Get the first node
                
                //Check each possibility in the order that they would be in in the stack
                //If it is the direction first recurse into that node
                //To see if it leads to the food
                //If it does add it to the path
                //If not, then if there are still adjacent nodes then
                //Get the next node.
                if(direction.contains("DOWN") && found == false){
                    found = dfs(x, y, pacman_x+1, pacman_y, food_x, food_y, grid);
                    if(found == true){
                        final_path.add(pacman_x + " " + pacman_y);
                        total = new Stack<String>();
                    }
                    if(!total.empty() && found == false)
                        direction = total.pop();
                }
                if(direction.contains("RIGHT")&& found == false){
                    found = dfs(x, y, pacman_x, pacman_y+1, food_x, food_y, grid);
                    if(found == true){
                        final_path.add(pacman_x + " " + pacman_y);
                        total = new Stack<String>();
                    }
                    if(!total.empty() && found == false)
                        direction = total.pop();
                }
                if(direction.contains("LEFT")&& found == false){
                    found = dfs(x, y, pacman_x, pacman_y-1, food_x, food_y, grid);
                    if(found == true){
                        final_path.add(pacman_x + " " + pacman_y);
                        total = new Stack<String>();
                    }
                    if(!total.empty() && found == false)
                        direction = total.pop();
                }
                if(direction.contains("UP")&& found == false){
                    found = dfs(x, y, pacman_x-1, pacman_y, food_x, food_y, grid);
                    if(found == true){
                        final_path.add(pacman_x + " " + pacman_y);
                        total = new Stack<String>();
                    }
                }
            }else{
                current_path.add(pacman_x + " " + pacman_y);
                return false; //This can't contain the path to the food
            }
		}
        return found;
	}
	/* Tail starts here */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);


		int pacman_x = in.nextInt();
		int pacman_y = in.nextInt();

		int food_x = in.nextInt();
		int food_y = in.nextInt();

		int x = in.nextInt();
		int y = in.nextInt();

		String grid[] = new String[x];

		for(int i = 0; i < x; i++) {
			grid[i] = in.next();
		}

		traveled = new boolean[x][y];
		dfs( x, y, pacman_x, pacman_y, food_x, food_y, grid);
		String[] curr_path = current_path.toArray(new String[0]);
		String[] fin_path = final_path.toArray(new String[0]);
		System.out.println(curr_path.length);
		for(int i = 0; i < curr_path.length; i++){
			System.out.println(curr_path[i]);
		}
		System.out.println(fin_path.length - 1);
		for(int i = fin_path.length; i > 0; i--){
			System.out.println(fin_path[i-1]);
		}

	}
}
