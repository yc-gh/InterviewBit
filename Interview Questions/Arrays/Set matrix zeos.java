// https://www.interviewbit.com/problems/set-matrix-zeros/

public class Solution {
    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        
        //Need to store indexes of 0s 
        //This approach uses O(M+N) space
        // boolean[] emptyrows = new boolean[a.size()];
        // boolean[] emptycols = new boolean[a.get(0).size()];
        
        //Instead, store these indexes in the first row and first column
        //However, one extra boolean is needed 
        //to store whether the first row (if row wise traversing) has a 0 or not
        
        //Then traverse the first row and column and set 0s as recorded
        
        boolean firstrowzero = false;
        
        for(int i=0; i<a.size(); i++)
        {
            for(int j=0; j<a.get(i).size(); j++)
            {
                if(i==0 && a.get(i).get(j)==0)
                {
                    firstrowzero = true;
                }
                else if(a.get(i).get(j) == 0)
                {
                    a.get(0).set(j,0);
                    a.get(i).set(0,0);
                }
            }
        }
        
        //Set zeroes in rows
        for(int i=1; i<a.size(); i++)
        {
            if(a.get(i).get(0)==0)
            {
                for(int j=1; j<a.get(i).size(); j++)
                {
                    a.get(i).set(j,0);
                }
            }
        }
        
        //Set zeros in cols
        for(int j=0; j<a.get(0).size(); j++)
        {
            if(a.get(0).get(j)==0)
            {
                for(int i=1; i<a.size(); i++)
                {
                    a.get(i).set(j,0);
                }
            }
        }
        
        //Set zero in first row if need be
        if(firstrowzero)
        {
            for(int j=0; j<a.get(0).size(); j++)
            {
                a.get(0).set(j,0);
            }
        }
    }
}
