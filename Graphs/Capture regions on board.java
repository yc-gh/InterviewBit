//https://www.interviewbit.com/problems/capture-regions-on-board/

public class Solution {
	public void solve(ArrayList<ArrayList<Character>> board) {
	    if(board==null || board.size()==0) return;
        
        int m = board.size();
        int n = board.get(0).size();
        
        for(int c=0; c<n; c++) 
        {
            if(board.get(0).get(c)=='O') markConnToEdge(board,0,c);
            if(board.get(m-1).get(c)=='O') markConnToEdge(board,m-1,c);
        }
        for(int r=1; r<m-1; r++)
        {
            if(board.get(r).get(0)=='O') markConnToEdge(board,r,0);
            if(board.get(r).get(n-1)=='O') markConnToEdge(board,r,n-1);
        }
        
        for(int r=0; r<m; r++)
        {
            for(int c=0; c<n; c++)
            {
                if(board.get(r).get(c)=='*') board.get(r).set(c,'O');
                else if(board.get(r).get(c)=='O') board.get(r).set(c,'X');
            }
        }
    }
    
    private static void markConnToEdge(ArrayList<ArrayList<Character>> board, int r, int c)
    {
        if(r<0 || r>=board.size() || c<0 || c>=board.get(0).size() 
            || board.get(r).get(c)=='X' || board.get(r).get(c)=='*') return;
        
        if(board.get(r).get(c)=='O') board.get(r).set(c,'*');
        
        markConnToEdge(board,r-1,c);
        markConnToEdge(board,r,c+1);
        markConnToEdge(board,r+1,c);
        markConnToEdge(board,r,c-1);  
    }
}
