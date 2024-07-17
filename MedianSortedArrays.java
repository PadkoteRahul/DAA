/*
In a school, 5th standard is having 2 sections called Rose and Lotus.
Section Rose contains 'm' students and Lotus contains 'n' students.
Each section students scored marks in Mathematics exam.
Teacher maintained a record of marks in ascending order of each section.
Now your task is to find out the median of the marks of 2 sections together.

Note: The overall run time complexity should be O(log (m+n)) .

Example 1:
Sample Input=
4                                                                                                               
6                                                                                                       
32 45 70 95                                                                                                     
40 50 59 67 73 84                                                                                                          

Sample Output=
63.0         //median

Example 2:
Sample Input=
5
6
10 20 30 40 50
35 44 60 70 80 90

Sample Output=
44


Input 3:
4
6
3 6 8 10
14 17 20 33 44 55

Output:
15.5

Input 4:
5
3
7 10 20 30 40 
50 60 80

Output:
35

*/

/*
Time complexity: O(log(min(x,y))
Space complexity: O(1)
*/

import java.util.*;

class MedianSortedArrays {
	public double findMedianSortedArrays(int[] arr1, int[] arr2) 
	{
		// Swap the arrays if arr1 length is greater than arr2 length
		if(arr1.length > arr2.length)
			findMedianSortedArrays(arr2, arr1);

		int x = arr1.length;
		int y = arr2.length;

		int low = 0;
		int high = x;

		while(low <= high)
		{
			int partitionX = (low + high)/2;
			int partitionY = (x + y + 1)/2 - partitionX;

			System.out.println("low " + low + " high " + high);

			// If partitionX = 0, it means nothing is there on left side. Use -INF for max
			System.out.println("partitionX " + partitionX + " partitionY " + partitionY);

			// If partitionX = 0, it means nothing is there on left side. Use -INF for maxLeftX
			// If partitionY = length of input, it means nothing is there on right side. Use +INF for minRightX

			int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : arr1[partitionX - 1];
			int minRightX = (partitionX == x) ? Integer.MAX_VALUE : arr1[partitionX];

			int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : arr2[partitionY - 1];
			int minRightY = (partitionY == y) ? Integer.MAX_VALUE : arr2[partitionY];

			System.out.println("maxLeftX " + maxLeftX + " minRightX " + minRightX);
			System.out.println("maxLeftY " + maxLeftY + " minRightY " + minRightY);

			if(maxLeftX <= minRightY && maxLeftY <= minRightX) 
			{
				// Array partitioning is @ correct place
				// Now get max of left elements and min of right elements to get the median
				// in case of even length combined array size 
				// or 
				// get max of left for odd length combined array size

				if((x + y) %2 == 0)
				{
					return ((double)(Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)))/2;
				}
				else
				{
					return (double)Math.max(maxLeftX, maxLeftY);
				}
			}
			else if(maxLeftX > minRightY)	// We are too far on right side for partitionX. Need to move left
			{
				high = partitionX - 1;
			}
			else	// We are too far on left side for partitionX. Need to move right
			{
				low = partitionX + 1;
			}
		}
		return -1;
			
	}
	
	public static void main(String[] args) { 
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		int n=sc.nextInt();

		int[] A= new int[m];
		int[] B=new int[n];

		for(int i=0;i<m;i++)
			A[i]= sc.nextInt();

		for(int i=0;i<n;i++)
			B[i]= sc.nextInt();

		System.out.println( new MedianSortedArrays().findMedianSortedArrays(A,B) ); 
	} 
}