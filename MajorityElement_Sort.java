import java.util.*;

/*
Time complexity: O(nlogn)
Space complexity: O(1)
*/

class MajorityElement_Sort 
{
	static int findMajority(int arr[], int n)
	{
		Arrays.sort(arr);

		int mid = n/2;
		int midEle = arr[mid];

		if(arr[mid - 1] == midEle)
			return arr[mid-1];
		else
		{
			if(n % 2 == 0)
				return -1;
			else 
				return arr[mid+1];
		}
	}

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();

		System.out.println("The majority element is : " + findMajority(arr, n));
	}
}
