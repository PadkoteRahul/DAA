/*
Mr. Dharma went to D-mart, and picked a basket with a capacity C.
There are N products in Dharma's wishlist.
You will be given desired cost and quantity of each Product.
Out of the wishlist Mr Dharma has, he wants to purchase the products in the following way:
	- The sum of quantities taken into the basket is less than or equal to C.
	- The sum of cost of the products in the basket is maximum among all 
	the possible combinations of products.

Your task is to help, Mr. Dharma to purachase the products with maximum cost, 
with the given basket capacity. 

Input Format:
-------------
Line-1: Two space separated integers, N and C.
Next N lines: Two space separated integers, Ci and Qi.
			cost and quantity of i-th product.

Output Format:
--------------
Print an integer, Maximum cost to pay to D-Mart.


Sample Input-1:
---------------
4 18
10 2
10 4
12 6
18 9

Sample Output-1:
----------------
44.0

Explanation:
------------
Quantity = 2 + 4 + 9 + 3 = 15
Cost = 10 + 10 + 18 + 6 = 44


Sample Input-2:
---------------
5 21
18 6
20 3
14 5
18 9
3 2

Sample Output-2:
----------------
66.0

Explanation:
------------
Quantity = 3 + 6 + 5 + 9 (7 qty used) = 18
Cost = 20 + 18 + 14 + 18 (14 value) = 66
*/

// Fractional Knapsack Problem
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// Greedy approach
public class Knapsack {
	// function to get maximum value
	private double getMaxValue(ItemValue[] arr, int capacity)
	{
		// sorting items by value/weight ratio;
		// Arrays.sort(arr, new ItemValueComparator());

		Arrays.sort(arr);

		double totalValue = 0d;

		for (ItemValue i : arr) {
			int curVal = (int)i.value;
			int curWt = (int)i.weight;
			System.out.println("curVal " + curVal + " curWt " + curWt + " factor " + (double)curVal / (double)curWt);
			if (capacity - curWt >= 0)
			{
				// this weight can be picked while
				capacity -= curWt;
				totalValue += curVal;
				if(capacity == 0)
					break;
			}
			else {
				// item cannot be picked whole
				double fraction	= ((double)capacity / (double)curWt);
				totalValue += (curVal * fraction);
				capacity = (int)(capacity - (curWt * fraction));
				break;
			}
			System.out.println("Capacity " + capacity + " totalValue " + totalValue);
		}
		return totalValue;
	}

	// item value class
	static class ItemValue implements Comparable
	{
		int value, weight;

		public ItemValue(int val, int wt)
		{
			this.value = val;
			this.weight = wt;
		}
		public int compareTo(Object obj) {
			ItemValue itemObj = (ItemValue)obj;
			if(weight < itemObj.weight)
				return -1;
			else if(weight > itemObj.weight)
				return 1;
			else
				return 0;				
		}
	}

	// class ItemValueComparator implements Comparator
	// {
	// 	@Override
	// 	public int compare(Object obj1, Object obj2)
	// 	{
	// 		ItemValue item1 = (ItemValue)obj1;
    // 		ItemValue item2 = (ItemValue)obj2;
	// 		double cpr1 = ((double)item1.value / (double)item1.weight);
	// 		double cpr2 = ((double)item2.value / (double)item2.weight);

	// 		if (cpr1 < cpr2)
	// 			return 1;
	// 		else
	// 			return -1;
	// 	}
	// }

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int size = sc.nextInt();
		int capacity = sc.nextInt();

		ItemValue[] arr = new ItemValue[size];
		for(int i = 0; i < size; i++)
			arr[i] = new ItemValue(sc.nextInt(), sc.nextInt());

		System.out.println(new Knapsack().getMaxValue(arr, capacity));
	}
}

/*Test cases
case =1
input =4 15
10 2
10 4
12 6
18 9
output =38.0

case =2
input =5 21
18 6
20 3
14 5
18 9
3 2
output =66.0

case =3
input =6 18
18 6
20 4
15 5
28 4
36 9
32 8
output =88.0

case =4
input =8 28
18 6
20 3
18 6
18 9
10 2
30 12
12 6
28 14
output =93.5

case =5
input =10 24
27 9
32 8
40 5
38 7
28 7
54 12
64 8
39 13
48 8
26 13
output =168.28571428571428

case =6
input =10 27
27 9
32 8
40 5
38 7
28 7
54 12
64 8
39 13
48 8
26 13
18 9
10 2
30 12
12 6
28 14
output =184.57142857142856
*/