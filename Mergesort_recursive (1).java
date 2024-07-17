import java.util.Scanner;
 
public class Mergesort_recursive
{ 
	public static void main(String a[])
	{
		Scanner sc=new Scanner (System.in);
		System.out.println("Enter array size");
		int n = sc.nextInt();

		int [] list=new int[n];
		System.out.println("Enter numbers ");
		for (int i=0 ; i<n; i++)
		{
			int  number = sc.nextInt();
			list[i]=number;
		}

		System.out.println("List before  sorting");
		for(int i = 0; i < list.length; i++)
			System.out.print( list[i]+"  ");
		System.out.println();

		mergeSort(list,0, list.length-1);

		System.out.print("List after sorting");
		for(int i = 0; i < list.length; i++)
			System.out.print(list[i]+"  ");
		System.out.println();
	}

	public static void mergeSort(int list[],int low, int high)
	{
		System.out.println("low " + low + " high " + high);

		if (low >= high) 
		{ 
			return;
		}   

		int middle = (low + high) / 2;          

		mergeSort(list, low, middle);
		mergeSort(list, middle + 1, high);

		merge(list, low, middle, high);
	}

	private static void merge(int list[], int low, int middle, int high)
	{
		System.out.println("Merge low " + low + " middle " + middle + " high " + high);
		int start= middle;
		int end = middle + 1;

		int l=low;

		while ((l <= start) && (end <= high))
		{
			if (list[low] < list[end]) 
			{
				low++;
			} 
			else 
			{
				int temp = list[end];
				for (int j = end-1; j >= low; j--) 
				{		 
					list[j+1] = list[j];
				}

				list[low] = temp;
				low++;
				start++;
				end++;
			}
		}
	}  	 
}

/*

Output:
Enter aray size
5
Enter numbers 
9
8
10
7
4
List before  sorting 
9  8  10  7  4  
List after sorting 
4  7  8  9  10  
*/
