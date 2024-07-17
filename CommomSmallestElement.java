// There are B bags containing N gold boxes each. In each bag, gold boxes are
// arranged  in ascending order of their weights strictly, create a method in 
// such a way that we need to return the least weight of gold box which is
// common least weight in all the given bags.

// If we don’t have any common least weighted gold box,
// among all the bags then return -1.

// Input Format:
// -------------
// Line-1: Two integers B and N, number of bags and number of goldboxes in each Bag.
// Next B lines: N space separated integers, weights of GoldBoxes.

// Output Format:
// --------------
// Print the least weight of gold box, if found
// Print -1, if not found.


// Sample Input:
// ---------------
// 5 5
// 1 2 3 4 5
// 2 3 6 7 9
// 1 2 3 5 8
// 1 3 4 6 8
// 2 3 5 7 8

// Sample Output:
// --------------
// 3
import java.util.*;

class CommomSmallestElement
{
    public static int findCommonSmallestElement(int[][] mat, int row, int col)
    {
        int result = -1;
        int i = 0;

            int j = 1;
            int count = 1;
            int left = 0;
            int right = col;
            while(left <= right && i<=col )
            {
                int target = mat[0][i]; 
                int mid = (left+right)/2;
                if(mat[j][left] > target)   
                {
                    i++;
                    j = 1;
                    count = 1;
                    left = 0;
                    right = col;
                }
                else if(mat[j][right] < target)
                {
                    i++;
                    count = 1;
                    j = 1;
                    left = 0; 
                    right = col;
                }
                else if(mat[j][mid] == target)
                {
                        result = mat[0][i];
                        count++;
                        j++;
                        // System.out.println("count of "+result+" up to "+j+" is : " +count);
                        left = 0;
                        right = col;
                        if(count == row+1)
                        {
                        // System.out.println("count of "+result+" up to "+j+" is : " +count);
                        return result;
                        }
                }
                else if(mat[j][mid] < target)
                {
                    left = mid+1;
                }
                else
                {
                    right = mid-1;
                }
        }
    return -1; 
    }
     public static void main (String[] args) {
         Scanner sc = new Scanner(System.in);
         
         int m = sc.nextInt();
         int n = sc.nextInt();
         int[][] matrix = new int[m][n];
         for(int i = 0; i<m; i++)
         {
             for(int j=0; j<n; j++)
             {
                 matrix[i][j] = sc.nextInt();
             }
         }
         System.out.println(findCommonSmallestElement(matrix, m-1, n-1));
     }
}