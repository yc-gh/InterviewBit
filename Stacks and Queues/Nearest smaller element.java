//https://www.interviewbit.com/problems/nearest-smaller-element/

public class Solution {
    public int[] prevSmaller(int[] A) {
        if(A==null || A.length==0) return new int[0];
        int n = A.length;
        return prevSmallerUtil(A,n);
    }
    
    private static int[] prevSmallerUtil(int[] arr, int n)
    {
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i<n; i++)
        {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) 
            { 
                stack.pop(); 
            } 

            if (stack.isEmpty()) 
            { 
                res[i] = -1;    
            } 
            else 
            { 
                res[i] = stack.peek();
            }
            
            stack.push(arr[i]);
        }
        return res;
    }
}
