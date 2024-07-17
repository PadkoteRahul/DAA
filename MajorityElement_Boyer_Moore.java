import java.util.*;

/*
The Boyer-Moore voting algorithm is popular optimal algorithms which is used to find the 
majority element among the given elements that have more than N/ 2 occurrences. 
This works perfectly fine for finding the majority element which takes 2 traversals 
over the given elements, which works in O(N) time complexity and O(1) space complexity.

First, choose a candidate from the given set of elements if it is the same as the 
candidate element, increase the votes. Otherwise, decrease the votes if votes become 0, 
select another new element as the new candidate.

/*
Time complexity: O(N)
Space complexity: O(1)
*/

class MajorityElement_Boyer_Moore
{
	public static int findMajority(int[] nums)
	{
		int count = 0, candidate = -1;

		// Finding majority candidate
		for (int index = 0; index < nums.length; index++) {
			if (count == 0) {
				candidate = nums[index];
				count = 1;
			}
			else {
				if (nums[index] == candidate)
					count++;
				else
					count--;
			}
			System.out.println("Count: " + count + " candidate: " + candidate);
		}

		// Checking if majority candidate occurs more than n/2 times
		count = 0;
		for (int index = 0; index < nums.length; index++) {
			if (nums[index] == candidate)
				count++;
		}

		if (count > (nums.length / 2))
			return candidate;
		return -1;
	}

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();

		System.out.println("The majority element is : " + findMajority(arr));
	}
}
