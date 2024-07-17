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

public class PaintVillaRecur 
{
	private int[][] costs;

    public int minCost(int[][] costs) 
	{
		if(costs == null || costs.length == 0)            
			return 0;

        this.costs = costs;
        return Math.min(paintCost(0, 0), Math.min(paintCost(0, 1), paintCost(0, 2)));
    }

    private int paintCost(int n, int color) 
	{
        int totalCost = costs[n][color];
        if (n == costs.length - 1) 
			return totalCost;

		if (color == 0) // Red
            totalCost += Math.min(paintCost(n + 1, 1), paintCost(n + 1, 2));
		else if (color == 1) // Green
            totalCost += Math.min(paintCost(n + 1, 0), paintCost(n + 1, 2));
		else // Blue
            totalCost += Math.min(paintCost(n + 1, 0), paintCost(n + 1, 1));
      
		return totalCost;
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
		System.out.println(new PaintVillaRecur().minCost(costs));
	}
}
