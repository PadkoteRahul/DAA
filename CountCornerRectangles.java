/*
JVS Infra Pvt Ltd purchased a flatland of size M*N, and it is divided 
into 1*1 cells. They mave marked some cells with red colors indicated 
with 1 and other cells with blue color indicated with 0.

They want build the walls in the form of rectangles by connecting four distinct 
red colored cells on the flatland that forms an axis-aligned rectangle.
And only the corners of the walls need to be red colored.

Your task is to help, JVS Infra to count the number of rectangular walls
can be built by connecting the red colored cells on the flatland.

Input Format:
-------------
Line-1: Two space separated integers, M and N
Next M lines: N space separated integers, either 0 or 1 only.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
3 4
1 0 1 0
1 1 1 1
0 1 1 1

Sample Output-1:
----------------
4

Explanation:
-----------
Given flatland is:
1 0 1 0
1 1 1 1
0 1 1 1
Number of rectngular walls are: 4
rectangle-1: by connecting 1's at (0, 0), (1, 0), (0, 2), (1, 2)
rectangle-2: by connecting 1's at (1, 1), (1, 2), (2, 1), (2, 2)
rectangle-3: by connecting 1's at (1, 1), (1, 3), (2, 1), (2, 3)
rectangle-4: by connecting 1's at (1, 2), (2, 2), (1, 3), (2, 3)


Sample Input-2:
---------------
4 5
1 0 1 0 1
0 0 0 1 0
0 1 1 0 1
1 0 1 0 0

Sample Output-2:
----------------
2

=== testcases ===
case =1
input =3 4
1 0 1 0
1 1 1 1
0 1 1 1
output =4

case =2
input =4 6
1 0 1 1 1 1
1 0 1 1 0 1
0 1 0 1 1 1
1 1 1 1 0 1
output =25

case =3
input =5 5
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1
output =100

case =4
input =5 6
1 1 0 1 0 1
1 1 0 1 1 0
1 1 0 1 1 1
1 0 1 0 0 0
0 1 1 1 1 0
output =22

case =5
input =8 12
0 1 0 1 1 1 0 0 0 0 0 0
1 1 1 1 0 0 0 0 1 1 1 1
0 1 1 0 0 0 0 1 1 1 1 0
0 1 1 1 1 0 0 0 0 1 1 1
1 1 0 1 0 0 0 1 0 0 1 1
1 1 1 0 0 1 0 1 1 0 1 1
0 0 1 0 0 0 1 1 0 1 0 0
1 0 0 0 1 1 0 1 0 1 0 0
output =112

case =6
input =11 12
0 1 0 1 1 1 1 0 1 0 0 0
0 1 0 0 0 0 0 0 0 1 1 0
1 0 0 0 1 0 0 1 1 1 1 0
0 1 1 1 1 1 1 0 1 0 1 0
1 0 0 1 0 1 1 0 1 0 1 1
0 1 0 0 1 0 1 1 1 0 0 1
1 0 1 0 0 1 0 0 1 0 1 1
1 1 1 1 1 0 0 0 0 1 1 1
1 0 1 1 0 0 0 1 1 1 1 1
0 1 0 1 0 1 1 1 0 0 1 1
0 1 0 0 1 0 0 0 1 1 0 1
output =249

case =7
input =12 16
0 1 1 1 0 1 0 0 0 1 0 0 1 0 1 0
0 0 1 1 0 0 0 1 0 0 0 0 1 0 0 0
0 1 0 1 0 1 0 1 1 0 0 0 1 1 0 1
1 0 1 0 1 1 0 1 1 1 0 1 0 1 0 0
0 1 0 1 1 1 0 0 1 0 1 0 1 1 1 1
1 1 1 0 1 1 1 1 1 0 0 1 0 1 0 0
0 0 0 1 1 1 0 1 0 1 0 0 0 0 0 1
1 1 0 0 1 1 1 1 0 1 0 0 1 1 1 1
0 0 1 1 1 0 1 0 1 1 0 0 0 1 1 0
0 0 1 0 0 0 1 0 1 0 0 0 0 1 1 0
1 0 0 1 1 1 1 1 0 0 0 0 0 1 1 1
0 0 1 0 1 0 1 1 1 0 0 1 0 1 0 0
output =487

case =8
input =7 9
1 1 1 0 1 1 0 1 1
1 1 0 1 1 0 1 0 1
1 0 1 1 0 1 0 1 0
0 1 1 1 1 0 1 0 1
1 0 1 1 1 1 0 1 1
1 1 0 1 1 0 1 0 1
1 1 1 0 1 1 0 1 1
output =165

case =9
input =6 17
0 0 1 1 1 1 1 0 1 0 1 1 1 0 0 1 1
0 0 1 0 1 0 0 1 0 0 0 0 1 0 0 0 0
1 0 0 1 0 0 1 0 1 0 1 0 0 1 0 1 1
1 1 0 1 0 1 0 1 1 0 1 1 1 0 1 0 1
1 0 1 0 1 1 1 1 0 0 1 1 0 0 1 0 1
0 0 0 1 0 0 1 0 0 0 1 0 1 1 1 0 1
output =137

case =10
input =15 16
1 0 0 1 0 1 1 0 1 0 1 1 1 0 0 1
1 1 0 0 0 1 0 1 1 1 1 1 1 1 0 0
0 0 1 1 0 0 1 0 0 0 1 0 1 1 0 0
0 1 1 0 0 0 0 1 0 1 1 1 0 0 0 0
1 1 1 1 1 1 0 1 1 0 1 0 1 1 0 1
1 1 0 1 1 0 1 0 1 1 0 1 0 1 1 1
1 1 1 1 0 0 0 0 1 1 1 0 0 0 0 0
1 0 1 1 0 0 0 1 1 0 1 0 1 0 0 1
0 0 1 1 0 1 1 1 0 0 1 0 1 1 0 1
1 0 1 1 1 1 0 0 0 1 0 1 1 1 0 0
0 1 1 0 0 0 0 1 1 0 0 0 0 1 1 1
0 0 1 1 0 1 1 1 1 1 1 0 0 1 0 1
1 1 1 0 1 0 0 1 0 1 0 1 1 0 0 1
0 1 0 1 1 0 1 1 0 0 0 0 1 0 1 0
1 1 0 1 1 1 1 0 0 0 1 0 1 0 1 1
output =1025

*/

import java.util.*;

class CountCornerRectangles {

	// fix two rows (or two columns) first, then check column by column to find 1 on both rows
	public int countCornerRectangles(int[][] grid)
	{
		if (grid == null || grid.length <= 1 || grid[0].length <= 1) 
		{
            return 0;
        }

		int ans = 0;
		int nrows = grid.length, ncols = grid[0].length;
		for (int i = 0; i < nrows; i++)
			for (int j = i + 1; j < nrows; j++)
				for (int k = 0, counter = 0; k < ncols; k++)
				{	
					if (grid[i][k] + grid[j][k] == 2)
					{
						ans += counter++;
						System.out.println("i " + i + " j " + j + " k " + k + " ans " + ans);
					}
				}
		return ans;
	}

	/*
	According to the question description, as long as we have two corner points of the rows 
	of a rectangle and corresponding two corner points of the columns, it forms a rectangle. 
	So we can two rows of the input matrix, every time we find two corner points in this row
	we treat them as the left line of a rectangle, we try to find how many right lines it 
	can have in the previous scanned lines. Thus, we use a 2D array dp[n][n] to track the 
	number of pairs of corner points before the current row with position in i, j, 
	then the number of rectangles with a right line made up of the current two 
	left points will be dp[i][j]. After that, update dp[i][j] by incrementing one.

	Time Complexity: O(M * N^2)
	*/

    public int countCornerRectanglesDP(int[][] grid) 
	{
		if (grid == null || grid.length <= 1 || grid[0].length <= 1) 
		{
            return 0;
        }

        int nrows = grid.length, ncols = grid[0].length;
        int[][] dp = new int[ncols][ncols];
        int res = 0;

        for(int i = 0;i < nrows;i++) 
		{
            for(int j = i + 1; j < nrows;j++) 
			{
                for(int k = 0; k < ncols; k++) 
				{
					if (grid[i][k] + grid[j][k] == 2)
					{
						res += dp[i][j];
						System.out.println("i " + i + " j " + j + " k " + k + " res " + res);
						dp[i][j]++;
					}
                }
				System.out.println(Arrays.deepToString(dp));
            }
        }
		return res;
    }
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int m =sc.nextInt();
		int n=sc.nextInt();
		int grid[][]=new int[m][n];
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				grid[i][j]=sc.nextInt();
		System.out.println(new CountCornerRectangles().countCornerRectanglesDP(grid));
	}
}