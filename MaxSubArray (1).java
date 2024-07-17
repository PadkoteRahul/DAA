/*
You are playing a game. There are N boxes placed in a row (0-indexed), 
every box has some points. You need to play the game with the following rules:
 - Initially your score is  '0' points.
	- Suppose the box has P points in it.
	  if p>0 you will gain P points, if p<0 you will loose P points.
	- You are allowed to choose any number of consecutive boxes, atleast 1 box.
   	
You are given the points in the N boxes as points[]. 
Your target is to maximize your score, and return the highest score possible. 
 
Input Format:
-------------
Line-1: An integer N.
Line-2: N space separated integers, points[].
  
Output Format:
--------------
An integer, print the highest score.
    
Sample Input-1:
---------------
9
-3 1 -2 4 -2 2 3 -5 4
 
Sample Output-1:
----------------
 7
   
Explanation:
------------
By selecting consecutive boxes are [4,-2,2,3] has the highest score is 7
   
 
Sample Input-2:
---------------
 2
 1 -2
  
Sample Output-2:
----------------
1

Explanation:
------------
By picking the box is [1] has the highest score is 1.

=== testcases ===
case =1
input =9
-2 1 -3 4 -1 2 1 -5 4
output =6
    
case =2
input =2
1 -2
output =1
 
case =3
input =20
6 -2 -7 7 -4 3 5 -5 7 -7 9 4 7 -5 -7 5 1 2 -3 3
output =26
 
case =4
input =25
5 -7 4 -9 -8 4 -9 -1 -10 -8 5 -4 -3 -8 6 8 9 6 5 -4 2 1 -5 9 8
output =45
 
case =5
input =30
6 -13 20 -1 -4 -13 -8 -4 -17 -7 -1 12 13 19 -10 -12 1 -15 -4 6 -1 -3 15 5 -5 3 -18 -13 -14 1
output =44
   
case =6
input =50
17 0 -17 7 14 -11 1 20 3 13 -1 6 17 -15 15 6 16 -10 17 3 -4 14 -18 16 -11 -16 -17 11 15 -20 3 -19 6 13 12 -11 -2 15 7 -4 15 -14 16 -7 7 -1 -14 -1 2 8
output =111
 
case =7
input =50
-21 -49 -40 -52 -36 18 -87 76 -44 96 92 63 81 -82 84 18 -30 -7 90 -26 -85 29 98 92 43 57 -6 16 -100 89 45 55 68 -75 -56 -58 -45 88 54 -27 -100 85 -26 -88 -96 20 90 -86 26 -49
output =812
 
case =8
input =75
3 67 -84 -38 -97 7 -55 -75 -27 2 78 -23 21 95 47 -17 65 19 9 -89 -34 74 -34 -98 29 -93 -1 -74 -7 83 88 41 -31 19 -69 -84 62 -43 -52 -11 65 -56 -81 -27 95 9 82 75 -98 -15 -72 71 -23 83 64 28 -90 -88 83 -92 83 -65 56 -79 -17 33 27 57 75 83 -5 -8 -64 1 43
output =365

*/
import java.util.*;

class MaxSubArray
{
	public int maxSubArray(int[] arr) 
	{
        int n = arr.length;
        int max = Integer.MIN_VALUE, sum = 0;
 
        for (int i = 0; i < n; i++) 
		{
            sum += arr[i];
 
            if (sum > max) 
				max = sum;            
 
            if (sum < 0)	// Greedy: negative sum is worst than restarting with a new range
                sum = 0;
        }
		return max;
	}

	public int maxSubArrayDP(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n]; //dp[i] means the maximum subarray ending with A[i];
        dp[0] = arr[0];
        int max = dp[0];
        
        for(int i = 1; i < n; i++)
		{
			// Either take the current element and continue with the previous sum OR restart a new range
            dp[i] = arr[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        } 
		System.out.println(Arrays.toString(dp));
        return max;
	}
   
    public static void main(String[] args)
    {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();     
		int ar[]=new int[n];
		for(int i=0;i<n;i++)
			ar[i]=sc.nextInt();
		System.out.println(new MaxSubArray(). maxSubArray(ar));
	}
}