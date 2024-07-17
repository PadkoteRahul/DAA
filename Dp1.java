import java.util.*;
class Dp1 {
    public static int longestCommonSubsequenceLength(String s1, String s2) {
      /*
       * s2 will be on the rows, s1 will be on the columns.
       * 
       * +1 to leave room at the left for the "".
       */
        int n = s1.length();
        int m = s2.length();
      int dp[][] = new int[m + 1][n + 1];
  
      /*
       * dp[m][n] is our original subproblem. Each entry in the
       * table is taking a substring operation against whatever string is on the rows
       * or columns.
       * 
       * It goes from index 0 to index i/j (exclusive)
       * 
       * So if my s1 = "azb" and j = 2...then my substring that I pass to the
       * lcs() function will be:
       * 
       * 0 1 2 "a  z  b"
       * 
       * "az" (index 2...our upper bound of the snippet...is excluded)
       */
      for (int i = 0; i <= m; i++) 
      {
        for (int j = 0; j <= n; j++) 
        {
          if (i == 0 || j == 0) 
          {
            dp[i][j] = 0;
          } 
          else if (s2.charAt(i - 1) == s1.charAt(j - 1)) {
            dp[i][j] = dp[i - 1][j - 1] + 1;
          } 
          else 
          {
            dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
          }
          System.out.print(dp[i][j]+" ");
        }
        System.out.println();
      }
      
  
      return dp[m][n];
    }
    public static void main(String[] args)
    {
        String s = "abcdef";
        String s1 = "acdghif";
        System.out.println(longestCommonSubsequenceLength(s, s1));
    }
  }
  