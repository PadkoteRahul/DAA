/*
You are given a list of N integers List[], list contains both +ve and
-ve integers. Your task is to findout, the Lowest Product possible.
Where the product is the product of all the elements of contiguous sublist 
sList[], and sub list should contain atleast 1 integer.

Input Format:
-------------
Line-1: An integer N.
Line-2: N space separated integers, List[].

Output Format:
--------------
Print an integer output, the lowest product.

Sample Input-1:
---------------
4
2 3 -2 4

Sample Output-1:
----------------
-48

Explanation:
------------
Product of contiguous sub list [2,3,-2,4].

Sample Input-2:
---------------
3
-2 0 -3

Sample Output-2:
----------------
-3

Explanation:
------------
Product of sub list is -3, where [-3] is the contiguous sublist
*/

import java.util.*;
class MinProductSet {
    public int minProduct(int[] nums) 
	{
        if (nums.length == 0) 
			return 0;
		else if(nums.length == 1)
			return nums[0];
//4
//2 3 -2 4
        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int result = min_so_far;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
			int max = max_so_far * curr;
			int min = min_so_far * curr;
            min_so_far = Math.min(curr, Math.min(max,min));
			
            max_so_far = Math.max(curr, Math.max(max,min));
			
			System.out.println("curr " + curr + " min_so_far " + min_so_far + " max_so_far " + max_so_far);

            result = Math.min(min_so_far, result);
        }
        return result;
    }
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int nums[]=new int[n];
		for(int i=0;i<n;i++)
			nums[i]=sc.nextInt();
		System.out.println(new MinProductSet().minProduct(nums));		
	}
}

/*
Test cases:

case =1
input =4
2 3 -2 4
output =-48

case =2
input =3
-2 0 -3
output =-3

case =3
input =5
-4 2 -3 4 -5
output =-480

case =4
input =15
-6 -15 20 -2 9 -11 7 -15 0 14 -18 2 -15 -9 12
output =-37422000

case =5
input =15
4 3 7 -1 0 -9 5 3 -7 8 -6 1 -3 3 -9
output =-3674160

case =6
input =10
-1 -2 4 5 0 -3 -2 -4 6 3
output =-432

case =7
input =20
4 -1 7 8 -2 10 4 3 -2 2 -7 4 -3 4 -4 -1 4 -2 7 7
output =-1982857216

case =8
input =20
4 -11 7 8 -9 -10 4 0 -2 2 -7 4 -3 0 -4 -1 4 -2 -7 7
output =-887040

case=9
input=2
0 0
output=0

case=10
input=4
-2 -5 -7 -4
output=-140

case=11
input=5
1 0 8 0 0
output=0
*/

