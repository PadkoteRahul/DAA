/*
Viraj Aanand is a wedding planner, He order his assistant to decorate a wall.
The decorator plans to decorate the wall with two different colored balloons.
The wall size is M*N, The decorator can decorate the wall using M*N balloons
the balloons are blue or white in color.

Blue colored ballons represented with digit-1 and 
White colored ballons represented with digit-0.

The blue colored balloons forms different shapes, that are connected 4 directonally.
The directons are upwards, downwards, left, and right. Viraj Aanand got an idea to 
count the unique shapes formed by blue colored ballons.

You will be given the decorated wall as a matrix wall[][].
Your task is to help, Viraj Aanand to count the unique shapes.

Input Format:
-------------
Line-1: Two space separated integers M and N, size of the wall.
Next M lines: N space separated integers, either 0 or 1.

Output Format:
--------------
Print an integer, Number of distinct shapes formed by blue balloons.


Sample Input-1:
---------------
4 5
1 1 0 0 0
1 1 0 0 0
0 0 0 1 1
0 0 0 1 1

Sample Output-1:
----------------
1


Sample Input-2:
---------------
5 5
1 1 0 1 1
1 0 0 0 1
0 0 0 0 0
1 0 0 0 1
1 1 0 1 1

Sample Output-2:
----------------
4

Note: 
-------
The shapes, 
1 1  		  1 1
1     and    1 
are different.
 
******* Testcases *******
case =1
input =4 5
1 1 0 0 0
1 1 0 0 0
0 0 0 1 1
0 0 0 1 1
output =1

case =2
input =5 5
1 1 0 1 1
1 0 0 0 1
0 0 0 0 0
1 0 0 0 1
1 1 0 1 1
output =4

case =3
input =8 8
1 1 0 1 1 0 1 1
1 1 1 1 1 1 1 0
0 1 0 1 0 1 1 1
1 1 1 0 0 1 0 1
1 1 0 0 1 1 1 0
0 1 1 1 1 1 0 1
1 1 1 0 1 0 0 0
1 0 1 1 0 1 0 0
output =2

case =4
input =18 18
1 1 0 0 0 0 0 0 0 0 1 1 1 1 0 0 0 0
1 0 1 1 1 0 0 1 0 1 0 1 1 0 0 1 0 1
0 1 0 1 1 1 1 0 0 1 0 1 1 0 1 1 0 0
0 1 1 1 0 1 0 1 0 1 0 1 1 0 0 0 1 0
0 1 1 0 1 0 1 0 1 1 0 1 1 1 1 1 0 0
0 0 1 1 0 0 1 0 1 1 1 0 0 0 0 0 1 1
0 0 1 0 1 1 1 0 1 0 0 0 0 0 1 1 0 1
0 1 0 1 0 0 0 0 0 0 0 1 1 1 0 0 0 1
0 0 0 0 1 1 1 0 1 1 1 0 1 1 1 0 0 0
0 1 1 1 1 1 0 0 1 1 0 0 1 1 1 0 1 0
1 0 0 0 0 1 0 0 1 0 0 1 0 0 0 0 0 1
1 1 1 1 1 0 0 1 0 0 1 0 0 0 0 1 1 1
1 1 1 1 1 0 0 1 1 1 0 0 1 1 1 0 0 1
1 0 0 0 1 0 0 1 1 1 0 0 1 1 1 1 0 0
0 0 1 0 1 0 1 0 1 1 0 0 1 1 0 0 0 1
0 1 1 0 1 0 1 0 0 0 0 1 0 1 0 0 1 0
0 0 0 1 0 1 0 0 0 1 0 1 0 0 0 1 1 1
0 1 0 0 0 1 1 1 0 0 1 1 1 0 1 0 1 0
output =20

case =5
input =12 12
1 1 0 0 1 1 1 1 0 1 0 1
1 0 0 1 1 0 1 0 0 1 0 1
0 0 0 0 0 1 0 1 1 0 1 0
0 1 0 1 0 1 0 0 0 1 0 1
1 1 0 0 1 1 1 0 0 0 1 1
1 0 1 1 1 1 0 1 1 1 0 0
1 1 0 0 1 0 1 0 1 0 1 0
1 0 1 0 0 1 0 1 0 0 0 1
0 0 1 0 0 1 1 0 1 1 1 1
1 1 0 1 0 1 0 0 1 0 1 0
0 0 1 0 1 0 1 0 1 1 1 1
1 1 0 1 1 0 0 1 1 0 1 0
output =11

case =6
input =15 12
0 0 0 0 0 1 0 0 1 1 0 0
0 1 1 0 1 1 1 0 0 1 1 0
0 1 1 1 1 0 0 0 1 1 0 0
0 0 0 1 1 0 0 0 0 0 0 1
0 0 1 0 0 1 0 0 0 1 0 0
1 0 1 0 1 1 1 0 1 1 0 1
0 1 1 0 1 0 0 0 0 0 0 0
1 1 1 0 1 1 0 0 0 0 1 0
0 0 1 1 1 1 0 1 0 1 1 1
0 0 1 1 1 0 1 0 0 0 1 0
1 0 1 0 1 1 1 0 0 1 1 0
1 0 1 1 1 1 0 1 1 1 1 1
1 1 1 1 0 0 0 0 0 1 0 0
0 1 0 1 1 1 0 0 0 1 0 1
1 1 1 1 0 0 1 1 1 0 0 0
output =7

case =7
input =7 12
1 1 0 0 0 1 1 1 0 0 0 1
1 1 0 1 0 1 1 1 1 1 0 1
1 1 1 0 0 0 1 1 0 1 0 1
1 0 0 1 1 0 1 1 0 0 0 0
1 1 1 1 1 0 0 0 1 1 1 0
0 1 0 0 1 0 1 0 1 1 0 0
0 1 0 0 1 0 1 0 1 1 0 0
output =6

case =8
input =20 19
0 0 1 1 1 0 1 0 0 1 1 1 1 0 0 0 1 0 0
0 0 0 0 1 0 0 0 0 1 1 1 0 0 1 0 1 1 0
1 0 0 1 0 1 0 0 1 1 1 1 1 1 0 0 1 0 0
1 0 1 1 1 0 0 1 1 0 1 0 1 0 0 0 0 0 1
1 1 0 1 1 1 1 1 0 0 0 1 0 1 0 1 1 0 1
0 0 1 0 1 1 0 1 0 1 1 0 0 0 1 0 1 0 1
1 0 0 0 1 0 0 0 1 0 1 0 0 1 1 0 0 1 1
0 0 0 1 1 1 0 0 0 0 0 1 1 0 0 0 1 1 1
0 0 1 1 0 0 1 0 0 1 1 0 0 1 0 1 0 1 1
1 1 1 0 0 1 0 0 1 1 0 0 0 1 0 1 1 0 1
1 1 1 1 0 1 1 0 1 0 1 0 1 0 0 1 0 0 1
1 1 1 0 1 0 0 1 0 0 0 1 0 0 1 0 1 1 0
1 0 1 1 0 0 0 1 0 0 1 0 0 0 1 0 0 1 1
0 0 1 0 1 0 1 0 1 1 0 0 0 0 1 1 0 1 1
0 1 0 0 0 1 1 0 0 0 0 1 1 1 1 1 1 0 0
0 0 0 0 1 0 0 0 1 1 1 0 0 1 1 1 1 1 0
1 1 1 0 1 1 0 1 0 1 0 1 0 0 1 1 1 1 1
0 1 0 0 0 0 1 1 1 0 0 1 1 1 0 1 1 1 0
0 0 0 1 1 1 1 1 1 1 1 0 1 1 0 0 1 0 1
1 1 1 0 0 1 0 0 1 1 0 0 0 1 0 1 1 0 1
output =18

*/

import java.util.*;

class DistinctIslands_DFS {
    public int numDistinctIslands(int[][] grid) 
	{
		Set<String> set = new HashSet<>();

		for(int row = 0; row < grid.length; row++) {
			for(int col = 0; col < grid[row].length; col++) {
				if(grid[row][col] != 0)
				{
					StringBuilder sb = new StringBuilder();
					// System.out.println("row " + row + " col " + col);
					dfs(grid, row, col, sb, "o"); // origin
					grid[row][col] = 0;
					// System.out.println(sb);
					set.add(sb.toString());
				}
			}
		}
		System.out.println(set.toString());
		return set.size();
	}
	private void dfs(int[][] grid, int row, int col, StringBuilder sb, String dir) 
	{
		if(row < 0 || row == grid.length || col < 0 || col == grid[row].length || grid[row][col] == 0) return;
		// System.out.println(sb +" "+dir);
		sb.append(dir);
		grid[row][col] = 0;
		dfs(grid, row - 1, col, sb, "u");
		dfs(grid, row + 1, col, sb, "d");
		dfs(grid, row, col - 1, sb, "l");
		dfs(grid, row, col + 1, sb, "r");
		sb.append("b"); 
	}
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		int n=sc.nextInt();
		int grid[][]=new int[m][n];
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				grid[i][j]=sc.nextInt();

		System.out.println(new DistinctIslands_DFS().numDistinctIslands(grid));
	}
}