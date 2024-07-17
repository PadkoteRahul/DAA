/*
Gopal is given a list of integers.
Your task to is find out, the length of the longest subsequence that is a
toggle sequence.

Toggle Sequence means, the difference between the consecutive numbers
are alternate positive and negative.

A subsequence is obtained by deleting some number of elements
(eventually, also zero) from the original sequence, leaving the remaining elements in
their original order.

For Example:
Given list of integers = 1 3 2 5 4 
the consecutive differences are [ 2, -1, 3, -1], 
the differences are alternate +ve and -ve.
So, complete list is a toggle sequence.

If the list of integers = 1 3 2 4 5,
the consecutive differences are [ 2, -1, 2, 1], not alternate +ve and -ve.
Not a toggle sequence.

Note: A sequence with fewer than two elements is a toggle sequence.

Input Format:
-------------
Space separated Integers, List

Output Format:
--------------
Print the length of the longest toggle sequence


Sample Input-1:
---------------
1 7 4 9 2 5

Sample Output-1:
----------------
6

Explanation:
------------
Given list of integers = 1 7 4 9 2 5
the consecutive differences are [ 6, -3, 5, -7, 3], 
the differences are alternate +ve and -ve.
So, complete list is a toggle sequence.

Sample Input-2:
---------------
1 5 4 3 7 9 10

Sample Output-2:
----------------
4

Explanation:
------------
Given list of integers = 1 5 4 3 7 9 10
the consecutive differences are [ 4, -1, -1, 4, 2, 1], 
the differences are alternate +ve and -ve.

*/

import java.util.*;

public class ToggleSequenceRecur
{
    private int calculate(int[] nums, int index, boolean isIncreasing) 
	{
		System.out.println("isIncreasing " + isIncreasing + " index " + index);
		int maxcount = 0;
		for (int i = index + 1; i < nums.length; i++) 
		{
			if ((isIncreasing && nums[i] > nums[index]) || (!isIncreasing && nums[i] < nums[index]))
				maxcount = Math.max(maxcount, 1 + calculate(nums, i, !isIncreasing));
		}
		return maxcount;
	}

    public int toggleMaxLength(int[] nums) 
	{
        if (nums.length < 2)
            return nums.length;

        return 1 + Math.max(calculate(nums, 0, true), calculate(nums, 0, false));
    }
		
	public static void main(String args[] )
	{
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] sarr = str.split(" ");

		// declaring an array with the size of string
        int[] nums = new int[sarr.length];
 
        for (int i = 0; i < sarr.length; i++) 
            nums[i] = Integer.valueOf(sarr[i]);

		System.out.println(new ToggleSequenceRecur().toggleMaxLength(nums));
	}	
}