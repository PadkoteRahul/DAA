
class countNumberOfRectangles{
    static public int countNumberOfRectangless(int m, int n, int[][] grid)
    {
        int[][] mat = new int[m][n];
        int count = 0;
        for(int i=1; i<m; i++)
        {
            for(int j=1; j<n; j++)
            {
                if(mat[i][j] == 1)
                {
                    for(int k=i+1; k<m; k++)
                    {
                        for(int l=j+1; j<n; j++)
                        {
                            if(mat[l][k] == 1 && mat[i][k]==1 && mat[k][l] == 1)
                            {
                                count++;
                            }
                            
                        }
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        //implement your code here.
        int[][] grid = {{1, 0, 1, 0},
                {1, 1, 1, 1},
                {0, 1, 1, 1}};
        int m = grid.length;
        int n = grid[0].length;
        System.out.println(countNumberOfRectangless(m, n, grid));
        
    }
}