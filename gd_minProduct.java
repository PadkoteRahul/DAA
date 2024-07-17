// You are given a list of N integers List[], list contains both +ve and
// -ve integers. Your task is to findout, the Lowest Product possible.
// Where the product is the product of all the elements sublist 
// sList[], and sub list should contain atleast 1 integer. 
// The elements need not be contiguous.

// Input Format:
// -------------
// Line-1: An integer N.
// Line-2: N space separated integers, List[].

// Output Format:
// --------------
// Print an integer output, the lowest product.

// Sample Input-1:
// ---------------
// 4
// 2 -3 4 -5

// Sample Output-1:
// ----------------
// -40

// Explanation:
// ------------
// Product of elements sub list [2 4 -5].


// Sample Input-2:
// ---------------
// 3
// -2 0 -3

// Sample Output-2:
// ----------------
// -3

// Explanation:
// ------------
// Product of sub list is -3, where [-3] is the sublist
import java.util.*;

class Solution
{
    public static long  minProductSet(int[] arr, int n)
    {
        int neg_no = 0;
        int neg_max = Integer.MIN_VALUE;
        int zero_no = 0;
        long min_pro = 1;
        for(int i : arr)
        {
            if(i < 0) neg_no++;
            if(i == 0) zero_no++;
            if(i > neg_max && i < 0) neg_max = i;
            // neg_max = Math.min(i, neg_max);
            if(i == 0) continue;
            min_pro *= i;
        // System.out.println("neg_max "+neg_max);
        // System.out.println("min_pro "+min_pro);
        }
        if(neg_no == 0 && zero_no == 0)
        {
            Arrays.sort(arr);
            return arr[0];
        }
        // if(zero_neg_no == 0) return min_pro; 
        if(zero_no > 0 && neg_no == 0) return 0;
        else if(neg_no % 2 == 0) return min_pro/neg_max;
        else return min_pro;
        // System.out.println(min_pro);
        // return 1;
    }
     public static void main (String[] args) {
         Scanner sc = new Scanner(System.in);
         
         int n = sc.nextInt();
         int[] arr = new int[n];
         for(int i=0; i<n; i++)
         {
             arr[i] = sc.nextInt();
         }
         System.out.println(minProductSet(arr, n));
     }
}