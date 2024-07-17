import java.util.*;

class DFS{
    // public static boolean solve(int[][] grid, int n)
    // {
    //     if(dfs(grid, 0, 0, n) == false) return false;
    //     return true;
    // }

    // public static boolean isinbounds(int[][] grid, int row, int col, int n)
    // {
    //     return(row>=0 && row<n && col>= 0 && col<n && grid[row][col] == 1);
    // }
    // public static boolean dfs(int[][] grid, int row, int col, int n)
    // {
    //     if(row == n-1 && col == n-1 && grid[row][col] == 1) 
    //     {
    //         grid[row][col] = 0;
    //         return true;
    //     }

    //     if(isinbounds(grid, row, col, n) == true)
    //     {
    //         grid[row][col] = 0;

    //         if(dfs(grid, row+1, col, n)) return true;
    //         if(dfs(grid, row, col+1, n)) return true;
    //         return false;
    //     }
    //     return false;
    // }
        public static int countislands(int[][] grid, int n)
        {
            int count = 0;
            for(int i=1; i<n-1; i++)
            {
                for(int j=1; j<n-1; j++)
                {
                    if(grid[i][j] == 0)
                    {
                        if(dfs(grid, i, j, n) == true);
                        {
                            count++;
                        }
                    }
                }
            }
            return count;
        }
        public static boolean isinbounds(int[][] grid, int r, int c, int n)
        {
            if(r>=1 && c>=1 && r<=n-2 && c <= n-2 && grid[r][c] == 0) return true;
            return false;
        }
        public static boolean dfs(int[][] grid, int r, int c, int n)
        {
            if(r >= 1 && r<= n-2 && c >= 1 && c <= n-2 && grid[r][c] == 1) return true;
            if(isinbounds(grid, r, c, n))
            {
                grid[r][c] = 1;
                return dfs(grid, r, c+1, n) &&
                dfs(grid, r+1, c, n) &&
                dfs(grid, r, c-1, n) &&
                dfs(grid, r-1, c, n);
            }
            return false;
        }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println(countislands(grid, n));
    }
}