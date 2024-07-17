import java.util.*;

class BinarySearch_iterative 
{
	int binarySearch(int array[], int ele, int low, int high) 
	{
// Repeat until the pointers low and high meet each other
		while (low <= high) 
		{
			int mid = low + (high - low) / 2;

			if (array[mid] == ele)
				return mid;
			else if (array[mid] < ele)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
  }

  public static void main(String args[]) 
  {
	BinarySearch_iterative ob = new BinarySearch_iterative ( );
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter array size");
	int n = sc.nextInt(); 

	int array[]=new int[n];
	System.out.println("Enter the elements of array ");

	for(int i=0;i<n;i++)
	{
		array[i] = sc.nextInt();
	}

	// Sorting the array
	Arrays.sort(array);

	// Printing the array after sorting
	System.out.println("Sorted array[]: "+ Arrays.toString(array));
	System.out.println("Enter the search key");

	int key = sc.nextInt();
	int result = ob.binarySearch(array, key, 0, n - 1);

	if (result == -1)
		System.out.println("Element not found");
	else
		System.out.println("Element found at index " + result);
  }
}
