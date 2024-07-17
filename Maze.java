/*
You are entering into a maze N*N grid consist of(0's and 1's)
Initially you will start from (0,0) position in the maze, 
Your target is to reach the end position (N-1, N-1).

Among the four directions available(top, down, left, right),
you can move in two directions only, right and down.

In the maze, '0' indicates dead end and '1' indicates open way. 
You can travel through only open way.

For Example:-
Given Maze of size N=4 , starting position is (0, 0),
1 0 0 0
1 1 0 1
0 1 0 0
1 1 1 1

You can reach the (3, 3) position in the following way.
1 0 0 0
1 1 0 0
0 1 0 0
0 1 1 1

Return true, if you can reach the end position(N-1, N-1).
otherwise return false.

Input Format:
-------------
Line-1 -> An integer N, size of square board.
Next N lines -> N space separated integers 

Output Format:
--------------
Print a boolean value.

Sample Input-1:
---------------
4
1 0 0 0
1 1 0 1
0 1 0 0
1 1 1 1

Sample Output-1:
----------------
true


Sample Input-2:
---------------
4
1 1 0 0
1 0 0 1
0 1 1 0
1 0 0 1

Sample Output-2:
----------------
false


=== testcases ===
case =1
input =4
1 0 0 0
1 1 0 1
0 1 0 0
1 1 1 1
output =true

case =2
input =4
1 1 0 0
1 0 0 1
0 1 1 0
1 0 0 1
output =false

case =3
input =5
0 0 1 0 1
0 1 0 1 1
1 0 1 1 1
1 0 0 1 0
1 1 1 0 1
output =false

case =4
input =6
1 1 1 0 0 1
0 1 0 0 0 0
1 1 0 1 0 0
0 1 1 1 0 0
0 0 1 1 0 0
1 1 1 1 1 1
output =true

case =5
input =7
1 1 1 1 1 1 1
0 0 1 0 0 0 0
0 0 1 1 0 0 0
0 0 0 1 1 0 0
0 0 0 0 1 1 0
0 0 0 0 0 1 0
0 0 0 0 0 1 1
output =true

case =6
input =7
1 1 1 1 1 1 1
0 0 0 0 0 0 1
1 1 1 1 1 1 1
1 0 0 0 0 0 0
1 1 1 1 1 0 0
1 1 1 1 1 0 0
1 1 1 1 1 1 1
output =false

case =7
input =8
1 1 1 1 0 0 1 0
0 1 1 1 1 1 1 1
1 0 0 1 0 0 1 1
0 0 1 0 0 1 1 0
0 1 1 0 1 1 1 0
1 1 0 0 0 1 0 0
1 1 1 1 0 0 0 0
0 0 1 0 1 1 1 1
output =false

case =8
input =8
1 1 1 1 0 0 1 0
0 1 1 1 1 1 1 1
1 0 0 1 0 0 1 1
0 0 1 1 1 1 0 0
0 1 1 0 1 1 0 0
1 1 0 0 1 0 0 0
1 1 1 1 1 1 0 0
0 0 1 0 1 1 1 1
output =true

case =9
input =5
1 1 1 0 1
0 1 0 1 1
1 1 1 1 1
1 0 0 1 0
1 1 1 1 0
output =false
*/

import java.util.Scanner;
public class Maze { 
	private int N; 
	Maze(int N)
	{
		this.N = N;
	}
	
	boolean inInBounds( int maze[][], int x, int y) 
	{ 
		return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1); 
	} 
	
	boolean solveMaze(int maze[][]) 
	{ 
		if (dfs(maze, 0, 0) == false) 
		{ 
			return false; 
		} 
		return true; 
	} 
	
	boolean dfs(int maze[][], int x, int y) 
	{ 
		System.out.println("x " + x + " y " + y);
		if (x == N - 1 && y == N - 1 && maze[x][y] == 1) 
		{ 
			maze[x][y] = 0; 
			return true; 
		} 

		if (inInBounds(maze, x, y) == true) { 
			// making it visited
			maze[x][y] = 0;

			// go to bottom cell
			if (dfs(maze, x + 1, y)) 
				return true; 

			// go to right cell
			if (dfs(maze, x, y + 1)) 
				return true; 

			return false; 
		} 
		return false; 
	} 

	public static void main(String args[]) 
	{ 
		Scanner sc=new Scanner(System.in);
		int n = sc.nextInt();
		Maze m = new Maze(n); 
		int maze[][] = new int[n][n];
		for(int i = 0;i < n;i++)
			for(int j = 0;j < n;j++)
				maze[i][j]=sc.nextInt();

		System.out.println(m.solveMaze(maze)); 
	} 
} 
