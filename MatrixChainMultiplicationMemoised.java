/*
Your are given the sizes of N-1 matrices as a list[] of size N, where the matrix are numbered from 0 to N-2 and the matrix size is defined as matrix-i size is list[i]*list[i+1].

Matrix multiplication follows associative rule. If you want to multiply 4 matrices, A,B,C and D.
You can perform multiplication in the following ways, ABCD, AB(CD), A(BC)D, ((AB)C)D, (AB)(CD)..etc.
To multiply two matrices of size m*n, n*p, you require m*n*p number of multiplications.

Your task is to return the minimum number of multiplications needed to multiply the N-1 matrices.

Input Format:
------------------
Line-1: An integer N
Line-2: N space separated integers, the list[]

Output Format:
--------------------
Print an integer, minimum multiplications needed.


Sample Input-1:
--------------------
4
10 30 5 60

Sample Output-1:
----------------------
4500

Explanation:
-----------------
posibilities are:
(AB)C => (10×30×5) + (10×5×60) => 1500 + 3000 = 4500 multiplications
A(BC) => (30×5×60) + (10×30×60) => 9000 + 18000 = 27000 multiplications


Sample Input-2:
--------------------
5
12 5 18 7 19

Sample Output-2:
----------------------
2435

Explanation:
-----------------
The best way is: A((BC)D) => (12*5*19) + (5*18*7) + (5*7*19)
=> 1140 + 630 + 665 = 2435 multiplications


=== testcases ===
case =1
input =5
12 5 18 7 19
output =2435

case =2
input =10
42 52 88 17 29 77 28 94 28 58
output =345577

case =3
input =15
4 2 18 3 7 1 4 10 15 8 5 10 5 6 13
output =729

case =4
input =20
9 1 11 4 5 3 7 12 5 1 1 19 19 9 13 16 5 3 1 1
output =1214

case =5
input =30
16 17 13 12 13 15 19 13 17 17 17 10 15 18 13 17 10 16 17 12 10 12 18 18 18 16 16 12 19 15
output =63550

case =6
input =30
12 12 19 12 12 16 13 14 18 15 11 10 17 19 17 14 10 10 16 19 13 12 10 18 17 18 12 17 15 12
output =57466

case =7
input =40
18 13 17 15 17 15 17 14 14 17 17 13 19 15 16 16 10 12 10 14 10 17 13 15 12 11 13 19 18 16 12 15 14 15 14 18 14 17 19 12
output =84008

case =8
input =50
45 54 66 16 63 26 75 40 47 63 38 96 87 37 33 32 45 52 71 45 99 35 84 90 51 67 95 79 63 46 41 63 32 74 75 67 76 59 51 14 89 78 68 45 39 77 68 83 31 23
output =2311904

*/

/*
Time Complexity: O(n^3)
Auxiliary Space: O(n^2)
*/

/*
Build a matrix dp[][] of size N*N for memoization purposes.
Use the same recursive call as done in the above approach:
When we find a range (i, j) for which the value is already calculated, return the minimum value for that range (i.e., dp[i][j]).
Otherwise, perform the recursive calls as mentioned earlier.
The value stored at dp[0][N-1] is the required answer.
*/

// https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/

import java.util.*;

class MatrixChainMultiplicationMemoised 
{
	static int[][] dp;
	// Matrix Ai has dimension p[i-1] x p[i] for i = 1..n
	static int matrixChainMemoised(int p[], int i, int j)
	{
		System.out.println("i " + i + " j " + j);
		if (i == j) 
		{
			return 0;
		}
		if (dp[i][j] != 0) 
		{
			return dp[i][j];
		}

		dp[i][j] = Integer.MAX_VALUE;

		for (int k = i; k < j; k++) 
		{
			dp[i][j] = Math.min(dp[i][j], matrixChainMemoised(p, i, k) +  matrixChainMemoised(p, k + 1, j)
					+ p[i - 1] * p[k] * p[j]);
		}
		return dp[i][j]; 
	}

	static int MatrixChainOrder(int[] p, int n)
	{
		dp = new int[n][n];
		return matrixChainMemoised(p, 1, n-1);
	}	

	public static void main(String args[])
	{
		/*
		5
		4 5 3 6 2
		*/
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();

		System.out.println(MatrixChainOrder(arr, n));
	}
}
