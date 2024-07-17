/*
Sharath is playing a game where there are N levels. Inorder to win the game he has to reach Nth level.

The rule book explains "In one step you can either cross one level or two levels".

Return the number of distinct possible ways to win the game.

Constraints:

    1 <= N <= 45

Input Format:
-------------
Line-1: An Integer N represents number of levels.
  
Output Format:
--------------
Print an integer.


Sample Input-1:
---------------
2
  
Sample Output-1:
----------------
2

Explanation:
------------
1. 1-level+ 1-level =2
2. 2 levels in one step.
   
Sample Input-2:
---------------
4
  
Sample Output-2:
----------------
5

Explanation:
------------
1. 1-level + 1-level + 1-level + 1-level = 4
2. 1-level + 1-level + 2-levels = 4
3. 1-level + 2-levels + 1-level = 4
4. 2-levels + 1-level + 1-level = 4
5. 2-levels + 2-levels  = 4


=== testcases ===
case =1
input =9
output =55
    
case =2
input =2
output =2
 
case =3
input =20
output =10946
 
case =4
input =25
output =121393
 
case =5
input =30
output =1346269
   
case =6
input =1
output =1
 
case =7
input =5
output =8
 
case =8
input =44
output =1134903170

*/
import java.util.*;

class ClimbingStairs {

	public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
   
    public static void main(String[] args)
    {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();     
		System.out.println(new ClimbingStairs().climbStairs(n));
    }
}


