
/* 

Time Complexity: O((m + n) Log (m + n))
Space Complexity: O(m + n). Creating a new array of size m + n.

Input:
5
6
-3 3 6 12 15 
-20 -11 -5 1 4 10

Sorted array:
-20 -11 -5 -3 1 3 4 6 10 12 15
Median: 3
*/

import java.util.Scanner;
import java.util.Arrays;

class MedianSortedArrays_BF 
{
	public double findMedianSortedArrays(int[] ar1, int[] ar2) 
	{
		int[] arr3 = new int[ar1.length + ar2.length];
 
        // Merge two array into one array
        System.arraycopy(ar1, 0, arr3, 0, ar1.length);
        System.arraycopy(ar2, 0, arr3, ar1.length, ar2.length);
 
        // Sort the merged array
        Arrays.sort(arr3);
 
        // Return the median
        return getMedian(arr3);
	}

	public static int getMedian(int[] arr)
    {
        int n = arr.length;
		for(int i=0;i<n;i++)
		System.out.print(arr[i]+" ");
	System.out.println();
        // If length of array is even
        if (n % 2 == 0)
            return(arr[n/2] + arr[n/2 -1]) / 2;
        // If length if array is odd
        else
            return(arr[n / 2]);
    }

	public static void main(String[] args)
	{		
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[] arr1 = new int[m];
		int[] arr2 = new int[n];

		for(int i = 0; i < m; i++)
			arr1[i] = sc.nextInt();

		for(int i=0;i<n;i++)
			arr2[i] = sc.nextInt();

		System.out.println(new MedianSortedArrays_BF().findMedianSortedArrays(arr1, arr2)); 
	}
}
