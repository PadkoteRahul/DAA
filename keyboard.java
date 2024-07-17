// class keyboard {
//     public static String[] findWords(String[] words) {
//         String one = "qwertyuiop";
//         String two = "asdfghjkl";
//         String three = "zxcvbnm";
//         String sl, s1;
//         for(String s : words)
//         {
            
//             s1 = s.toLowerCase();
//             sl = (one.indexOf(s1.charAt(0)) != -1)?one:(two.indexOf(s1.charAt(0)) != -1)? two:three;
//             System.out.println(sl);

//         }
//         return new String[] {" "};
//     }
// 	public static void main(String[] args) {
// 		String[] w = {"Alaska", "Zebra", "namo"};
// 		System.out.println(findWords(w));
// 	}
// }
// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class keyboard {
    public static int min(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[n][m];
        for(int i=0; i<m; i++)
        {
            dp[0][i] = matrix[0][i];
        }
        for(int i=1; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(j == 0)
                {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j+1]) + matrix[i][j];
                }
                else if(j == n-1)
                {
                    dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + matrix[i][j];
                }
                else
                {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i-1][j+1])) + matrix[i][j];
                }
            }
        }
        int ans = dp[n-1][0];
        // System.out.println(Arrays.deepToString(dp));
        for(int i=1; i<m; i++)
        {
            if(dp[n-1][i] < ans) ans=dp[n-1][i];
        }
        return ans;
    }
    public static void main(String[] args)
    {
        int[][] mat ={{-2,11,-30},{-70,16,95},{-113,913,714}};
        System.out.println(min(mat));
    }
}
