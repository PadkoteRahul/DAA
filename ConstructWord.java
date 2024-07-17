/*
Given an 2D character array, Letters[][], of size r*c.
You have to construct the word W, using the given array.

Rules to construct the word are as follows:
	- All the letters of the word W, should be adjacent to each other 
	in the array Letters(either horizontal or vertical).
	- You can use each charcater in Letters[][] only once.

If you are able to construct the word W, return 'true'
Otherwise 'false'.

Input Format:
-------------
Line-1 -> two integers R and C, array size.
R lines -> C space separated characters.
Last line -> a string, word W

Output Format:
--------------
print the boolean result.


Sample Input-1:
---------------
3 3
a b c
d e f
g h i
bad

Sample Output-1:
----------------
true

Sample Input-2:
---------------
3 3
a b c
d e f
g h i
ace

Sample Output-2:
----------------
false


Sample Input-3:
---------------
3 3
a b c
d e f
g h i
add

Sample Output-3:
----------------
false

*/

import java.util.*;

class ConstructWord{
	public boolean exist(char[][] board, String word) {
		for (int row = 0; row < board.length; row++)
			for (int col = 0; col < board[0].length; col++)
				if ((board[row][col] == word.charAt(0)) && dfs(board, row, col, 0, word))
					return true;
		return false;
	}

	private boolean dfs(char[][] board, int r, int c, int count, String word) 
	{
		if (count == word.length())
			return true;

		if (r == -1 || r == board.length || c == -1 || c == board[0].length || board[r][c] != word.charAt(count))
			return false;

		/*
		First, we mark the current cell as visited, e.g. any non-alphabetic letter will do. 
		Then we iterate through the four possible directions, namely down, up, right and left.
		The order of the directions can be modified.

		At the end of the exploration, we revert the cell back to its original state. 
		Finally we return the result of the exploration.
		*/
		char temp = board[r][c];
		board[r][c] = ' ';
		boolean found = dfs(board, r + 1, c, count + 1, word) ||
						dfs(board, r - 1, c, count + 1, word) ||
						dfs(board, r, c + 1, count + 1, word) ||
						dfs(board, r, c - 1, count + 1, word);
		board[r][c] = temp;
		return found;
	}
	
	public static void main(String args[] )
	{
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		char[][] array=new char[m][n];
		for(int i = 0; i < m; i++)
			for(int j = 0; j < n; j++)
				array[i][j] = sc.next().charAt(0);

		String word	= sc.next();
		System.out.println(new ConstructWord().exist(array, word));
	}
}