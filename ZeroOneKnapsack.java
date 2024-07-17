/*
Mr. Dharma went to D-mart, and picked a basket with a capacity C.
There are N products in Dharma's wishlist.
You will be given desired cost and quantity of each Product.
Out of the wishlist Mr Dharma has, he wants to purchase the products in the following way:
	- The sum of quantities taken into the basket is less than or equal to C.
	- The sum of cost of the products in the basket is maximum among all 
	the possible combinations of products.

Your task is to help, Mr. Dharma to purachase the products with maximum cost, 
with the given basket capacity. 

Input Format:
-------------
Line-1: Two space separated integers, N and C.
Next N lines: Two space separated integers, Ci and Qi.
        			cost and quantity of i-th product.

Output Format:
--------------
Print an integer, Maximum cost to pay to D-Mart.


Sample Input-1:
---------------
4 15
10 2
10 4
12 6
18 9

Sample Output-1:
----------------
38

Explanation:
------------
Quantity = 2 + 4 + 9 = 15
Cost = 10 + 10 + 18 = 38


Sample Input-2:
---------------
4 21
18 6
20 3
14 5
18 9

Sample Output-2:
----------------
56

Explanation:
------------
Quantity = 6 + 3 + 9 = 18
Cost = 18 + 20 + 18 = 56

******* Testcases *******
case =1
input =3 6
10 1
15 2
40 3
output =65

case =2
input =4 21
18 6
20 3
14 5
18 9
output =56

case =3
input =6 18
18 6
20 4
15 5
28 4
36 9
32 8
output =84

case =4
input =8 28
18 6
20 3
18 6
18 9
10 2
30 12
12 6
28 14
output =86

case =5
input =10 24
27 9
32 8
40 5
38 7
28 7
54 12
64 8
39 13
48 8
26 13
output =152

case =6
input =15 27
27 9
32 8
40 5
38 7
28 7
54 12
64 8
39 13
48 8
26 13
18 9
10 2
30 12
12 6
28 14
output =170

*/

import java.util.*;


/*
4 7
1 2
2 3
5 3
9 4

o/p: 14
*/

class ZeroOneKnapsack
{
	static int KnapSackRecur(int[] val, int[] weight, int n, int w) 
	{
		System.out.println("Recursion n " + n + " w "+ w);
		// Base Case
        if (n == 0 || w == 0)
            return 0;
 
        // If weight of the nth item is more than Knapsack capacity w,
        // then this item cannot be included
        if (weight[n - 1] > w)
            return KnapSackRecur(val, weight, n - 1, w);
 
        // Return the maximum of two cases:

        // (1) nth item included. If we use it, let us add the current value (val[n-1]), to our solution 
		// using any of the previous n-1 items, but with capacity w - weight[n - 1] (current_weight) 

        // (2) not included
        else
            return Math.max(val[n - 1] + KnapSackRecur(val, weight, n - 1, w - weight[n - 1]),
                       KnapSackRecur(val, weight, n - 1, w));
	}

	/*
	Memoization is basically an extension to the recursive approach so that we can overcome 
	the problem of calculating redundant cases and thus increased complexity
	*/
	static int KnapSackMemoization(int[] val, int[] weight, int n, int w, int [][]dp) 
	{
		System.out.println("Memoization n " + n + " w "+ w);
		// Base Case
        if (n == 0 || w == 0)
            return 0;

		if (dp[n][w] != 0)
			return dp[n][w];  
 
        // If weight of the nth item is more than Knapsack capacity W,
        // then this item cannot be included
        if (weight[n - 1] > w)
            return dp[n][w] = KnapSackMemoization(val, weight, n - 1, w, dp);
 
        // Return the maximum of two cases:

        // (1) nth item included. If we use it, let us add the current value, val[n-1], to our solution using any of the previous n-1 items, but with capacity w - weight[n - 1] (current_weight) 

        // (2) not included
        else
            return dp[n][w] = Math.max(val[n - 1] + KnapSackMemoization(val, weight, n - 1, w - weight[n - 1], dp),
                       KnapSackMemoization(val, weight, n - 1, w, dp));
	}

	// To call memoization function
	static int KnapSack(int[] val, int[] weight, int n, int w) 
	{
		int dp[][] = new int[n + 1][w + 1];	
		return KnapSackMemoization(val, weight, n, w, dp);        
	}

	/*
	In a DP[][] table let's consider all the possible weights from 1 to W as the columns and 
	cost and weight that can be kept as the rows. 

	The state DP[i][j] will denote maximum value of j-weight considering all values from 1 to ith.
	So if we consider wi (weight in ith row) we can fill it in all 
	columns which have weight values > wi. Now two possibilities can take place: 

	Fill wi in the given column.
	Do not fill wi in the given column.

	Now we have to take a maximum of these two possibilities:
	1) If we do not fill ith weight in jth column then DP[i][j] state will be same as DP[i-1][j]

	2) If we fill the weight, DP[i][j] will be equal to the value of wi + value of the column
	weighing j-wi in the previous row. 

	So we take the maximum of these two possibilities to fill the current state.
	*/

	static int KnapSackDP(int[] val, int[] weight, int n, int w)
	{
		int i, j;
        int dp[][] = new int[n + 1][w + 1];
 
        // Build table dp[][] in bottom up manner
        for (i = 1; i <= n; i++)
        {
            for (j = 1; j <= w; j++)
            {
                if (j >= weight[i-1])	// included
				{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - weight[i-1]] + val[i-1]);
				}
                else	// not included
				{												 
                    dp[i][j] = dp[i-1][j];
				}
            }
        } 
		System.out.println(Arrays.deepToString(dp));
        return dp[n][w];
	}
	
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n = sc.nextInt();
		int w = sc.nextInt();
		int val[] = new int[n];
		int wt[] = new int[n];
		for(int i = 0; i < n; i++)
		{
			val[i] = sc.nextInt();
			wt[i] = sc.nextInt();
		}
		System.out.println(KnapSack(val, wt, n, w));
	}
}
