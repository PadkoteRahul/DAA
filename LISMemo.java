/*
There are some balls in a row, the balls are numbered from -1000 to +1000.
You need do arrange the balls in a such way that, 
the numbers on the balls in the row, should be in ascending order.
You are allowed to remove few balls in the row, 
but you are not allowed to shuffle their position.

Given an set of integers, numbers printed on the balls. 
Your task is to find the length of longest ascending arrangement of 
the numbered balls in the row.

Input Format:
-------------
Line-1: An integer N represents number of balls.
Line-2: Space separated integers, numbers printed on the balls in a row.

Output Format:
--------------
Print an integer, length of longest ascending arrangement of the numbered balls.
 
Sample Input-1: 
-------------
8
10 9 2 5 3 7 101 18

Sample Output-1: 
--------------
4 

Explanation: 
-------------
The longest ascending arrangement is [2,3,7,101], therefore the length is 4. 
 
 
Sample Input-2: 
-------------
6
0 1 0 1 0 1
  
Sample Output-2: 
--------------
2
 
Explanation: 
-------------
The longest ascending arrangement is [0, 1], therefore the length is 2. 

=== testcases ===
case =1
input =8
10 9 2 5 3 7 101 18
output =4

case =2
input =6
0 1 0 3 2 3
output =4

case =3
input =20
-181 566 -612 306 171 -480 167 818 945 -25 71 -449 -252 -139 -660 -672 -914 -213 835 -597
output =6

case =4
input =30
-36 -25 3 37 -56 45 94 -7 -20 -31 -98 98 -82 96 93 58 83 24 -21 -28 -23 -12 2 22 27 94 -75 -10 33 58
output =10
 
case =5
input =50
82 -80 41 -65 -35 86 95 66 77 39 6 84 11 -63 78 82 47 -83 25 12 -99 89 -97 91 85 -49 -15 -52 -6 -96 -68 -9 -12 6 64 -59 3 95 -5 23 48 -17 -12 53 94 77 79 27 72 -66
output =12
 
case =6
input =50
-88 69 -39 -34 28 -78 -53 81 -33 -37 95 -59 46 21 98 18 95 -84 -42 80 -12 88 -61 67 -96 -17 -72 -15 78 62 -24 69 -98 86 -96 -26 -74 11 -19 69 -61 -85 -33 41 -46 -95 -43 -18 -60 63
output =9

case =7
input =50
90 48 2 88 3 75 30 49 27 49 26 64 40 58 95 30 58 1 65 4 78 8 35 79 10 94 99 78 53 27 82 19 21 2 76 80 55 18 60 60 51 74 71 74 57 30 -6 27 28 19
output =11
 
case =8
input =50
0 -9 -4 -5 2 -1 -9 0 -10 -1 -3 -2 -5 -2 -6 -5 -10 7 7 -9 -4 7 3 -5 7 -2 8 -2 5 5 -10 1 -7 -5 8 -4 0 -6 2 -2 7 -7 -4 -2 7 -9 -8 -6 1 5
output =8

*/

import java.util.*;

class LISMemo
{
	// Time complexity: O(n^2)
	// Space complexity: O(n)

    public int lengthOfLISMemo(int[] nums) 
	{
		if (nums == null || nums.length == 0) 
            return 0;

        int[] dp = new int[nums.length];
        int max = 1;
        for(int i = 1; i < nums.length; i++) 
		{
            max = Math.max(max, helper(nums, i, dp));
        }
        return max;
    }
    
    protected int helper(int[] nums, int i, int[] dp) 
	{
		System.out.println("i " + i);

        if(i == 0)
            return 1;

        if(dp[i] != 0) 
            return dp[i];

        int longest = 1;
		for (int j = 0; j < i; j++) 
		{
            if(nums[i] > nums[j]) 
				longest = Math.max(longest, helper(nums, j, dp) + 1);
        }

        dp[i] = longest;
        return longest;
    }
	
    public static void main(String[] args)
    {
		/*
		6
		15 10 5 8 6 9
		*/
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();     
		int ar[] = new int[n];
		for(int i = 0; i < n; i++)
		ar[i] = sc.nextInt();
		System.out.println(new LISMemo().lengthOfLISMemo(ar));
	}
}

