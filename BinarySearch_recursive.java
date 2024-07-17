// Binary Search in Java
import java.util.*;
class BinarySearch_recursive
{
	int binarySearch(int array[], int x, int low, int high) 
	{
		if (high >= low) {
		int mid = low + (high - low) / 2;

		// If found at mid, then return it
		if (array[mid] == x)
			return mid;

		// Search the left half
		if (array[mid] > x)
			return binarySearch(array, x, low, mid - 1);

		// Search the right half
		return binarySearch(array, x, mid + 1, high);
	}
    return -1;
  }

public static void main(String args[])
{
	BinarySearch_recursive ob = new BinarySearch_recursive();
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