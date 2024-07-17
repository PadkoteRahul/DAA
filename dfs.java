
//     79. Word Search
// Given an m x n grid of characters board and a string word, return true if word exists in the grid.
// The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are 
// horizontally or vertically neighboring. The same letter cell may not be used more than once.

// Example 1:

// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
// Output: true
// Example 2:


// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
// Output: true
// Example 3:


// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
// Output: false
// import java.util.*;
// class dfs {
//     static int[][] directions = {{-1,0}, {0,1}, {1,0}, {0,-1}};
//     static int len;
//     static int l1;
//     static int l2;
//     static boolean result;
//     static public boolean exist(char[][] board, String word) {
//         if(board == null || board.length == 0 || board[0].length == 0 || word == null) return false;
//         len = word.length();
//         l1 = board.length;
//         l2 = board[0].length;
//         for(int i=0; i<l1; i++)
//         {
//             for(int j=0; j<l2; j++)
//             {
//                 // if(board[i][j] == word.charAt(0))
//                 // {
//                 //     return isExist(board, i, j, word, 0);
//                 // }
//                 if(isExist(board, word, i, j, 0) == true) 
//                 {
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
//     public static boolean isExist(char[][] board, String word, int i, int j,  int n)
//     {
//         if( n == len) return true;
//         // for(int[] dir : directions)
//         // {
//         //     int row = dir[0] + i;
//         //     int col = dir[1] + j;
//             // if(row>=0 && row<l1 && col>=0 && col<l2)
//             // {
//             //     if(board[row][col] == word.charAt(n))
//             //     {
//             //         return isExist(board, row, col, word, n+1);
//             //     }
//             // }
//             if(i<0 || j<0 || i>=l1 || j>=l2 ||board[i][j] != word.charAt(n)) return false;
//             board[i][j] = '#';
//             // result = isExist(board, row, col, word, n+1);
//         // }
//         result = isExist(board,    word , i-1, j, n+1) ||
//                  isExist(board, word, i, j-1,  n+1) ||
//                  isExist(board, word, i+1, j,  n+1) ||
//                  isExist(board, word, i, j+1,  n+1);
//         board[i][j] = word.charAt(n);
//         return result;
    
//     }
//     public static void main(String[] args) {
//         // Scanner sc = new Scanner(Ssytem.in);

//         char[][] board ={{'A','B','C','E'},
//                         {'S','F','C','S'},
//                         {'A','D','E','E'}};
//         String word = "ABCCED";
//         System.out.println(exist(board,word));
//     }
// }
/*
===========================================================================
==============================================================================
============================================================================
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
// approach is:
// adding different way patterns in to set it will make you completely Distinctislands
// import java.util.*;

// class dfs {
//     public int numDistinctIslands(int[][] grid) 
// 	{
// 		Set<String> set = new HashSet<>();

// 		for(int row = 0; row < grid.length; row++) {
// 			for(int col = 0; col < grid[row].length; col++) {
// 				if(grid[row][col] != 0)
// 				{
// 					StringBuilder sb = new StringBuilder();
// 					// System.out.println("row " + row + " col " + col);
// 					dfs(grid, row, col, sb, "o"); // origin
// 					grid[row][col] = 0;
// 					// System.out.println(sb);
// 					set.add(sb.toString());
// 				}
// 			}
// 		}
// 		// System.out.println(set.toString());
// 		return set.size();
// 	}
// 	private void dfs(int[][] grid, int row, int col, StringBuilder sb, String dir) 
// 	{
// 		if(row < 0 || row == grid.length || col < 0 || col == grid[row].length || grid[row][col] == 0) return;

// 		sb.append(dir);
// 		grid[row][col] = 0;
// 		dfs(grid, row - 1, col, sb, "u");
// 		dfs(grid, row + 1, col, sb, "d");
// 		dfs(grid, row, col - 1, sb, "l");
// 		dfs(grid, row, col + 1, sb, "r");
// 		sb.append("b"); 
// 	}
	
// 	public static void main(String args[])
// 	{
// 		Scanner sc=new Scanner(System.in);
// 		int m=sc.nextInt();
// 		int n=sc.nextInt();
// 		int grid[][]=new int[m][n];
// 		for(int i=0;i<m;i++)
// 			for(int j=0;j<n;j++)
// 				grid[i][j]=sc.nextInt();

// 		System.out.println(new DistinctIslands_DFS().numDistinctIslands(grid));
// 	}
// }
/*
Jadav Payeng, "The Forest Man of India", 
started planting the seeds in a M*N grid land.
Each cell in the grid land is planted with a seed.
After few days, some seeds grow into saplings indicates with '1',
and the rest are dead seeds indicates with '0'.

One or more saplings are connected either horizontally, vertically or diagonally with each other, form a sapling-group. 
There may be zero more sapling-groups in the grid land.

Jadav Payeng wants to know the biggest sapling-group in that grid land.

You are given the M * N grid, filled with 0's and 1's.
You are task is to help Jadav Payeng to find the number of saplings in 
the largest sapling-group.

Input Format:
-------------
Line-1: Two integers M and N, the number of rows and columns in the grid-land.
Next M lines: contains N space-separated integers .

Output Format:
--------------
Print an integer, the number of saplings in the 
largest sapling-group in the given grid-land.

Sample Input-1:
---------------
5 4
0 0 1 1
0 0 1 0
0 1 1 0
0 1 0 0
1 1 0 0

Sample Output-1:
----------------
8


Sample Input-2:
---------------
5 5
0 1 1 1 1
0 0 0 0 1
1 1 0 0 0
1 1 0 1 1
0 0 0 1 0

Sample Output-2:
----------------
5

=== testcases ===
case =1
input =5 5
0 1 1 1 1
0 0 0 0 1
1 1 0 0 0
1 1 0 1 1
0 0 0 1 0
output =5

case =2
input =5 5
0 1 1 1 1
1 0 0 0 1
1 1 0 1 0
0 1 0 1 1
0 1 1 1 0
output =15

case =3
input =7 5
1 1 1 0 1
0 0 1 0 0
1 1 0 1 0
0 1 1 0 0
0 0 0 0 0
0 1 0 0 0
0 0 1 1 0
output =9

case =4
input =8 9
0 1 0 0 0 0 1 1 0
1 1 0 0 1 0 0 0 1
0 0 0 0 1 0 1 0 0
0 1 1 1 0 1 0 1 1
0 1 1 1 0 0 1 1 0
0 1 0 1 1 0 1 1 0
0 1 0 0 1 1 0 1 1
1 0 1 1 1 1 0 0 0
output =29

case =5
input =13 18
0 0 0 0 0 0 0 1 0 0 0 1 0 1 0 1 0 1
1 1 1 1 0 1 1 1 0 0 0 0 1 1 0 1 1 1
0 1 1 1 1 1 1 0 0 1 0 1 1 1 0 1 0 1
0 1 1 1 1 0 0 1 1 0 1 0 1 0 0 1 0 0
0 0 0 1 1 0 0 0 1 1 0 1 1 1 0 1 1 1
0 1 1 1 1 1 0 0 1 1 1 1 0 1 0 1 1 1
1 0 0 1 1 1 0 0 1 1 1 1 1 1 1 0 1 0
0 0 1 0 0 0 0 1 1 1 1 1 0 1 0 1 0 1
0 1 1 1 1 1 0 0 1 0 0 0 1 1 1 1 1 0
1 0 1 0 0 1 1 0 1 1 1 1 1 0 1 1 0 1
0 1 1 0 0 1 1 1 1 1 1 0 0 0 1 0 0 1
0 0 0 1 0 0 1 1 1 1 0 1 0 0 0 0 0 0
0 1 0 0 1 1 0 0 1 0 0 1 0 0 1 1 0 0
output =125

case =6
input =15 18
1 0 1 1 1 1 1 0 1 0 0 1 1 0 0 1 1 1
0 0 1 1 1 1 1 1 1 0 0 0 0 0 1 0 1 1
1 0 1 1 1 0 0 0 0 0 1 1 0 1 1 0 1 1
1 0 0 0 1 0 0 0 0 1 1 0 0 1 1 0 1 0
1 0 1 0 0 1 1 0 0 1 0 0 0 0 1 0 0 0
1 0 0 1 1 0 1 0 0 0 0 1 0 0 1 1 0 1
1 1 1 1 0 1 0 0 0 0 1 1 1 1 1 0 1 0
1 1 1 1 1 0 1 1 1 0 1 0 1 1 0 0 1 0
0 1 0 0 0 0 0 0 1 0 0 1 0 0 1 1 1 0
1 0 1 0 1 0 0 1 1 1 0 1 1 1 0 0 0 0
0 1 1 0 1 0 0 1 1 0 0 0 1 1 1 0 0 1
0 1 0 1 0 0 1 1 0 0 1 1 0 1 0 1 0 1
0 1 0 0 1 1 1 1 0 1 1 1 0 0 0 0 1 0
1 0 0 0 0 1 0 1 0 0 1 0 0 1 1 1 0 0
1 0 1 1 1 0 0 1 0 0 1 1 0 1 1 0 0 1
output =70

case =7
input =15 25
1 0 1 1 1 0 0 0 1 0 1 0 1 0 0 0 1 0 0 1 1 0 0 0 0
0 0 1 1 1 1 0 1 1 1 0 0 1 0 0 0 1 0 1 1 1 1 0 1 1
1 1 1 1 1 0 0 0 1 1 0 0 1 1 1 0 0 0 0 0 1 0 0 0 0
1 1 1 1 1 0 1 1 0 0 0 0 1 0 1 1 0 1 0 1 0 1 1 0 0
1 1 1 1 0 1 0 0 1 0 0 1 1 1 1 1 1 1 1 1 0 0 1 0 0
0 1 0 0 0 1 0 0 0 1 0 1 0 1 1 0 0 1 1 1 1 1 1 0 0
0 1 1 1 0 1 1 1 0 1 1 1 0 1 0 1 0 1 0 1 0 1 1 1 1
1 0 1 1 0 1 0 0 0 0 0 1 0 1 1 0 1 1 1 1 0 1 0 1 0
1 0 1 0 0 1 0 1 0 0 1 1 0 1 0 1 1 0 0 1 0 1 1 1 1
1 1 1 1 1 0 0 0 1 0 0 1 0 1 1 1 0 1 0 0 1 0 1 1 0
0 0 0 0 1 0 0 0 1 0 0 0 0 0 0 0 0 1 0 0 1 0 0 0 0
0 0 1 0 0 0 0 1 0 0 1 1 1 1 1 0 1 1 1 0 1 0 0 0 0
1 1 0 0 1 0 1 0 0 1 0 1 0 0 0 1 1 1 0 0 0 1 1 1 1
1 1 1 0 1 0 1 0 1 1 0 1 1 1 1 1 0 0 1 0 1 0 0 1 1
1 0 1 0 1 0 1 1 0 1 1 0 1 0 0 1 0 1 0 1 0 1 0 0 1
output =177

case =8
input =20 25
1 0 0 0 0 1 1 0 0 0 0 0 1 1 1 1 1 0 1 1 1 1 0 0 0
1 0 1 0 1 0 1 0 1 1 0 1 0 1 0 1 0 0 1 0 0 1 1 0 1
0 1 1 0 1 0 0 1 1 0 0 0 0 1 1 0 1 1 0 0 1 0 1 0 0
1 0 1 0 0 0 0 0 0 0 1 1 0 0 0 0 1 0 1 1 1 1 0 0 1
1 0 1 0 0 0 0 1 0 0 0 1 1 0 0 0 0 0 0 0 0 0 1 0 1
1 0 0 0 1 0 0 1 0 1 0 1 0 0 1 0 1 0 1 0 0 0 0 0 0
1 0 0 1 0 0 0 0 1 0 0 0 1 0 1 0 0 1 0 1 1 1 0 0 0
0 1 1 1 1 1 1 0 0 1 1 1 0 0 0 0 0 1 0 0 0 0 0 0 1
1 0 1 0 1 0 1 0 0 0 0 0 0 0 0 0 0 0 1 1 0 0 0 1 0
1 0 0 0 1 0 1 1 1 0 1 0 0 1 1 1 1 1 1 0 0 0 0 0 1
1 1 1 0 1 0 1 0 0 0 0 0 1 1 1 0 0 0 1 1 1 1 1 1 0
1 0 0 0 0 1 1 0 1 0 1 0 0 1 1 0 1 1 0 1 0 1 1 0 0
1 0 1 1 0 0 1 1 1 1 0 0 0 1 0 1 1 0 0 1 0 0 1 1 0
0 0 0 1 1 0 1 1 1 1 0 0 1 1 0 0 1 0 0 1 1 1 0 1 1
0 1 0 0 1 0 0 0 0 1 0 1 0 1 0 1 0 0 0 1 1 0 0 1 0
1 0 0 0 0 1 0 1 0 1 1 1 0 1 1 1 0 1 0 1 0 0 0 0 1
0 1 0 1 1 0 0 0 0 1 0 1 1 1 1 1 0 0 0 0 0 0 0 1 1
0 1 0 1 1 1 1 1 0 0 0 1 1 1 1 0 0 1 1 0 1 0 1 1 1
0 0 0 1 1 0 1 0 1 0 1 1 0 0 1 1 1 0 1 0 0 0 0 1 1
0 1 1 1 0 0 0 1 0 0 0 0 0 0 1 0 0 0 1 0 0 1 1 1 1
output =141

case =9
input =20 20
1 1 1 1 1 1 0 0 0 1 1 1 1 1 1 1 1 0 0 0
0 0 0 0 0 0 0 0 1 0 1 0 0 1 1 1 0 0 0 1
0 0 1 1 1 0 1 0 1 0 1 1 0 1 1 1 0 0 1 1
1 1 1 1 1 0 0 1 0 1 0 0 0 1 1 0 0 1 0 1
0 1 1 1 0 0 1 1 0 1 0 0 0 0 1 0 0 1 1 0
0 1 1 0 1 1 1 0 0 0 0 1 1 1 0 1 0 0 0 0
0 0 1 0 1 1 1 0 0 0 1 0 1 1 0 0 1 1 1 1
1 1 1 1 0 1 1 0 1 1 0 1 0 1 0 0 1 1 0 1
1 1 0 1 1 0 0 0 0 0 0 1 1 1 0 0 1 1 1 1
1 0 0 0 0 0 0 0 1 1 0 0 1 0 1 1 1 1 0 1
1 1 0 0 1 1 0 1 0 0 0 0 1 0 1 1 1 1 0 0
0 0 1 1 1 0 1 1 0 1 1 1 1 1 1 0 1 0 0 1
1 1 0 1 0 0 1 1 1 0 1 1 0 0 0 0 1 0 0 0
0 0 1 1 0 0 1 0 1 1 0 0 0 0 1 0 1 0 0 1
0 1 1 0 0 0 0 0 1 0 1 0 1 0 1 0 0 0 0 0
1 1 0 0 1 0 0 0 0 1 1 0 1 0 0 0 0 0 1 1
1 1 1 1 0 1 0 0 1 1 0 0 0 1 0 1 0 1 0 1
1 1 0 1 0 1 1 0 0 1 1 0 1 0 0 0 0 0 1 1
0 0 0 1 1 0 1 0 0 1 1 1 0 0 0 1 0 0 1 0
1 1 1 1 0 1 0 1 1 1 0 1 0 1 1 0 1 1 0 1
output =171

case =10
input =30 30
0 1 0 1 1 0 1 1 1 1 0 1 0 1 0 1 1 0 0 0 0 1 1 1 1 0 0 0 0 1
0 1 0 0 0 0 0 1 0 1 1 0 0 0 1 1 0 0 1 0 0 0 0 1 1 0 0 1 1 0
1 1 1 0 1 1 0 1 0 0 1 1 1 0 1 1 0 0 0 0 0 0 1 0 1 0 0 1 0 1
0 1 1 0 0 1 0 0 0 0 0 1 1 0 0 0 0 0 0 1 1 0 0 1 0 1 0 1 0 0
0 0 1 0 1 1 0 1 1 0 1 1 1 0 0 1 0 1 1 0 0 0 1 1 0 0 1 0 1 0
0 1 1 1 1 0 0 1 1 1 1 1 1 0 0 0 1 0 0 0 1 1 0 0 0 0 1 0 1 0
1 1 0 0 1 0 0 0 0 0 0 0 1 0 1 0 0 0 1 1 0 1 0 0 1 0 0 0 1 0
1 1 1 0 0 0 0 0 0 0 1 1 1 0 0 1 0 0 1 1 0 1 1 1 0 1 1 0 0 1
0 0 0 0 1 0 1 0 0 0 1 1 1 1 0 0 1 1 1 0 0 0 1 1 0 0 1 0 0 1
1 0 1 1 1 1 0 1 1 1 1 1 1 1 0 1 0 1 1 1 0 0 1 1 0 1 0 1 0 0
0 0 1 1 0 1 1 0 1 0 1 1 0 0 0 1 1 0 1 1 0 1 1 0 0 0 0 0 0 0
0 0 0 1 0 0 0 1 0 0 1 0 1 0 1 0 0 0 1 1 0 0 1 1 1 0 1 1 1 1
0 0 0 1 1 1 0 1 1 1 1 1 0 1 0 1 0 1 0 0 0 1 0 1 0 0 0 1 1 1
1 0 0 1 0 0 0 0 1 0 0 0 1 1 1 1 0 0 1 0 0 0 0 1 1 0 0 1 1 1
1 0 0 1 1 0 0 0 0 0 1 0 0 1 0 1 1 1 0 1 1 0 0 1 0 1 1 0 1 0
0 0 1 1 1 1 0 0 0 1 1 0 0 0 0 1 0 0 0 1 1 1 1 1 0 1 0 0 0 1
0 1 0 0 1 1 0 0 0 1 0 0 0 0 1 1 0 0 1 0 0 0 1 1 0 0 0 0 0 0
0 0 0 0 0 1 0 0 1 1 1 1 1 1 0 1 1 1 0 1 0 1 1 0 1 0 1 1 1 1
1 0 1 1 1 1 1 1 0 1 0 1 0 1 0 1 0 0 0 0 1 0 1 0 0 0 0 1 0 0
0 1 0 1 1 1 0 0 1 0 1 0 1 1 1 1 0 0 0 1 0 0 0 0 0 0 0 0 1 1
1 1 0 0 0 1 1 0 1 1 1 0 0 1 1 0 1 1 1 0 1 0 0 1 0 0 0 1 0 0
1 0 0 1 0 1 1 0 1 1 1 0 1 1 0 1 0 0 0 0 1 1 0 0 0 0 1 1 1 1
0 0 0 0 0 1 1 0 1 1 0 0 1 0 0 1 1 0 0 0 1 1 0 0 0 0 0 0 1 1
0 0 1 0 1 1 1 0 1 1 0 0 0 0 0 1 1 1 0 0 1 0 1 1 1 1 0 0 0 0
0 0 0 1 0 0 0 1 0 1 1 1 1 0 0 0 1 1 0 1 0 0 0 0 0 0 1 1 0 1
1 1 0 0 1 0 0 1 0 0 0 1 0 0 1 1 1 1 0 0 1 0 0 1 0 0 1 1 1 0
0 1 1 1 0 0 0 0 0 0 1 1 0 0 1 1 0 0 1 1 1 1 0 0 1 1 1 0 1 0
1 0 0 0 1 1 0 1 0 1 0 1 0 1 1 1 1 0 1 1 0 1 1 0 1 1 0 1 0 1
0 1 0 1 1 0 0 0 1 0 0 1 1 0 0 1 1 1 0 1 0 0 0 1 0 0 0 0 1 0
0 1 1 1 0 1 1 0 0 0 0 1 0 1 0 1 1 1 1 0 0 1 0 0 0 0 0 0 0 0
output =358

*/
import java.util.*;

public class dfs {
    static boolean[][] visited;
    static int[][] matrix;
	int m, n;

    public int maxAreaOfIsland(int[][] grid) {
        int largest = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    int area = dfs(grid, row, col);
                    if (area > largest) largest = area;
                }
            }
        }
        return largest;
    }

    public int dfs(int[][] grid, int row, int col) 
	{
		// System.out.println("i " + i + " j " + j);
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) 
			return 0;
        grid[row][col] = 0;
        int count = 1;
		count += dfs(grid, row + 1, col);	// down
		count += dfs(grid, row - 1, col);	// up
		count += dfs(grid, row, col + 1);	// right
		count += dfs(grid, row, col - 1);	// left 
		count += dfs(grid, row - 1, col - 1);	// top left
		count += dfs(grid, row + 1, col - 1);	// bottom left
		count += dfs(grid, row - 1, col + 1);	// bottom right
		count += dfs(grid, row + 1, col + 1);	// top right
		System.out.println("row " + row + " col " + col + " count " + count);
        return count;
    }	

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] board = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = in.nextInt();
            }
        }
        System.out.println(new dfs().maxAreaOfIsland(board));
    }
}


















































































































































































































































































































