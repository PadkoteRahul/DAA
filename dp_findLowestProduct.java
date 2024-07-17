// You are given a list of N integers List[], list contains both +ve and
// -ve integers. Your task is to findout, the Lowest Product possible,
// Where the product is the product of all the elements of contiguous sublist 
// sList[], and sub list should conatin atleast 1 integer.

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
// 2 3 -2 4

// Sample Output-1:
// ----------------
// -48

// Explanation:
// ------------
// Product of contiguous sub list [2,3,-2,4].


// Sample Input-2:
// ---------------
// 3
// -2 0 -3

// Sample Output-2:
// ----------------
// -3

// Explanation:
// ------------
// Product of sub list is -3, where [-3] is the contiguous sublist
import java.util.*;

class dp_findLowestProduct{
    public static int findLowestProduct(int[] arr, int n)
    {
        int max_so_far = arr[0];
        int min_so_far = arr[0];
        int result = min_so_far;
        for(int i=1; i<n; i++)
        {
            int curr = arr[i];
            int max = max_so_far * curr;
            // System.out.println("max  : "+max);

            int min = min_so_far * curr;
            // System.out.println("min : "+min);
            
            max_so_far = Math.max(curr, Math.max(max, min));
            // System.out.println("max do far : "+max_so_far);
            min_so_far = Math.min(curr, Math.min(max, min));
            // System.out.println("min so far: "+ min_so_far);
        
            result = Math.min(result, min_so_far);
            // System.out.println("result : "+result);
        }
        return result;
        
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for(int i=0; i<n; i++)
        {
            arr[i] = sc.nextInt();
        }
        
        System.out.println(findLowestProduct(arr, n));
    }
}