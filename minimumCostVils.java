import java.util.*;

class minimumCostVils
{
    public static int minimumCost(int[][] vils, int rows, int costs)
    {
        int[][] dp = new int[rows][costs];
        dp[0][0] = vils[0][0];
        dp[0][1] = vils[0][1];
        dp[0][2] = vils[0][2];
        for(int i = 1; i<=rows; i++)
        {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + vils[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + vils[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + vils[i][2];
        }
        return Math.min(dp[rows][0], Math.min(dp[rows][1], dp[rows][2]));
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] vils = new int[n][3];
        // int[] arr = new int[3];
        for(int i=0; i<n; i++)
        {
            for(int j = 0; j<=3; j++)
            {
                vils[i][j] = sc.nextInt();
            }
            // Arrays.sort(arr);
            // System.out.println(Arrays.toString(arr));
            // vils[i] = arr.clone();
            
        }
        System.out.println(minimumCost(vils, n-1, 3));
        // for(int i =0; i<n; i++)
        // {
        //     System.out.println(Arrays.toString(vils[i]));
        //     // for(int j = 0; j<3; j++)
        //     // {
        //     //     print
        //     // }
        // }
        // List<List<Integer>> ll = new ArrayList<>();
        // for(int i = 0 ; i<)
        
    }
}