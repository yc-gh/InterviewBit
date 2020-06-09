//https://www.interviewbit.com/problems/black-shapes/

public class Solution {
    public int black(String[] A) {
        char[][] grid = new char[A.length][A[0].length()];
        for(int i=0; i<A.length; i++)
        {
            for(int j=0; j<A[i].length(); j++)
            {
                grid[i][j] = A[i].charAt(j);
            }
        }
        int rows = grid.length;
        if(rows == 0) return 0;
        int cols = grid[0].length;
        
        int count = 0;
        
        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                if(grid[i][j]=='X')
                {
                    dfs(grid,i,j,rows,cols);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    static void dfs(char[][] grid, int i, int j, int r, int c)
    {
        
            if(i<0 || i>=r || j<0 || j>=c || grid[i][j]!='X') return;
            grid[i][j] = 'O';
            dfs(grid, i, j-1, r, c);
            dfs(grid, i-1, j, r, c);
            dfs(grid, i, j+1, r, c);
            dfs(grid, i+1, j, r, c);
    }
}
