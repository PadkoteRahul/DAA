/*
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
-3 1 -2 4 -1 2 3 -5 4

Sample Output-1:
----------------
8

Explanation:
------------
By selecting consecutive boxes are [4,-1,2,3] has the highest score is 8


Sample Input-2:
---------------
2
1 -2

Sample Output-2:
----------------
1

Explanation:
------------
By picking the box is [1] has the highest score is 7


***** Testcases *****
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

/*
	Initialize:
		max_so_far = INT_MIN
		max_ending_here = 0

	Loop for each element of the array
	  (a) max_ending_here = max_ending_here + a[i]
	  (b) if(max_so_far < max_ending_here)
				max_so_far = max_ending_here
	  (c) if(max_ending_here < 0)
				max_ending_here = 0
	return max_so_far

	The simple idea of Kadane's algorithm is to look for all positive contiguous segments 
	of the array (max_ending_here is used for this). And keep track of the maximum sum 
	contiguous segment among all positive segments (max_so_far is used for this). 
	Each time we get a positive-sum compare it with max_so_far and update 
	max_so_far if it is lesser than max_ending_here 

	Time complexity: O(n)
	Space complexity: O(1)
*/

import java.util.*;

class MaxSubarray_1 
{	
	// Returns sum of maximum sum subarray in arr[l..h]
	static int maxSubArraySum(int arr[], int l, int h)
	{
		int size = arr.length;
        int max_so_far = Integer.MIN_VALUE;
		int max_ending_here = 0;
  
        for (int i = 0; i < size; i++)
        {
            max_ending_here = max_ending_here + arr[i];
			System.out.println("Before max_so_far " + max_so_far + " max_ending_here " + max_ending_here);

            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;

			System.out.println("After max_so_far " + max_so_far + " max_ending_here " + max_ending_here);
			System.out.println();

            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
	}

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[] = new int[n];

		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();

		int max_sum = new MaxSubarray_1().maxSubArraySum(arr, 0, n - 1);
		System.out.println(max_sum);
	}
}