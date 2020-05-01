// https://www.interviewbit.com/problems/word-search-board/

public class Solution {
    public int exist(String[] A, String word) {
        char[][] board = new char[A.length][];
        for(int i=0; i<A.length; i++)
        {
            board[i] = A[i].toCharArray();
        }
        int r = board.length;
        int c = board[0].length;
        
        for(int i=0; i<r; i++)
        {
            for(int j=0; j<c; j++)
            {
                if(board[i][j] == word.charAt(0))
                {
                    if(dfs(board, i, j, r, c, word, 0)) return 1;
                }
            }
        }
        
        return 0;
    }
    
    static boolean dfs(char[][] board, int i, int j, int r, int c, 
                        String word, int index)
    {
        if(i<0 || i>=r || j<0 || j>=c) return false;
        if(board[i][j] != word.charAt(index)) return false;
        if(index+1 >= word.length()) return true;
        boolean found = dfs(board, i, j-1, r, c, word, index+1)
            || dfs(board, i-1, j, r, c, word, index+1)
            || dfs(board, i, j+1, r, c, word, index+1)
            || dfs(board, i+1, j, r, c, word, index+1);
        
        if(found) return true;
        return false;
    }
}
