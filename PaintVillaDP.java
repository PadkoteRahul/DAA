/*
Skandhanshi Infra Township constructed N Villas in a row.
They planned to paint the villas with three colors, 
snow-white, sky-blue and light-green. 
And adjacent villas should not paint with same color.

You are given the cost of painting each villa with these colors, cost[N][3].
cost[i][0] is cost of painting with snow-white.
cost[i][1] is cost of painting with sky-blue.
cost[i][2] is cost of painting with light-green.
where, 0 <= i < N.

Your task is to find the minimum cost to paint all the villas.

Input Format:
-------------
Line-1: An integer N, number of villas.
Next N lines: 3 space separated integers, cost to paint the villas.

Output Format:
--------------
Print an integer, minimum cost to paint all the villas.

Sample Input:
---------------
3
17 2 17
16 4 5
14 3 19

Sample Output:
----------------
10

Explanation: 
------------
1st Villa painted with sky-blue, 2nd Villa painted with light-green,
3rd Villa painted with sky-blue.
Minimum cost: 2 + 5 + 3 = 10.

*/

import java.util.*;

public class PaintVillaDP 
{
	public static int minCost(int[][] costs) 
	{
	    if(costs == null || costs.length == 0)
	        return 0;
	    
		int n = costs.length;
		int[][] dp = new int[n][3];
        
        for(int c = 0; c < 3; c++) 
			dp[0][c] = costs[0][c];
        
        for(int i = 1; i < n; i++)
		{
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + costs[i][2];
        }
        System.out.println(Arrays.deepToString(dp));
        return Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);
	}
	
	public static void main(String args[] ) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();  
		int[][] costs = new int[n][3];
		for(int i = 0; i < n; i++)
		{
		   for(int j = 0; j < 3; j++)
		   {
			   costs[i][j] = scan.nextInt();
		   }
		}
		System.out.println(minCost(costs));
	}
}
