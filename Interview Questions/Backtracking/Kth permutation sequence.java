
// Faster solution fails on IB for larger values of n
public class Solution {
    public String getPermutation(int n, int k) {
        if(n>12) return String.valueOf(Integer.MAX_VALUE);
        StringBuilder sb = new StringBuilder();
        List<Integer> numbers = new ArrayList<>();
        for(int i=1; i<=n; i++) numbers.add(i);
        
        int[] fact = new int[n];
        int sum = 1;
        fact[0] = 1;
        for(int i=1; i<n; i++)
        {
            sum *= i;
            fact[i] = sum;
            if(fact[i]>k) fact[i] = k;
        }
        
        k--;
        
        for(int i=1; i<=n; i++)
        {
            int index = k/fact[n-i];
            sb.append(numbers.get(index));
            numbers.remove(index);
            k -= index*fact[n-i];
        }
        
        return sb.toString();
    }
}


// DFS 
class Solution {
    public String getPermutation(int n, int k) {
        String[] res = new String[1];
        backtrack(n, new int[]{k}, res, new StringBuilder(), new boolean[n+1]);
        return res[0];
    }
    
    private void backtrack(int n, int[] k, String[] res, StringBuilder sb,
                          boolean[] vis)
    {
        if(sb.length()==n)
        {
            if(--k[0] == 0) res[0] = sb.toString();
        }
        else
        {
            for(int i=1; i<=n; i++)
            {
                if(vis[i]) continue;
                sb.append(i);
                vis[i] = true;
                backtrack(n, k, res, sb, vis);
                sb.setLength(sb.length()-1);
                vis[i] = false;
            }
        }
    }
    
    
}

// Editorial DFS solution
public class Solution {
    public String getPermutation(int A, int B) {
        ArrayList<String> a = new ArrayList<String>();
        for(int i=1; i<=A; i++){
            a.add(Integer.toString(i));
            
        }
        ArrayList<String> ans = new ArrayList<String>();
        helper(A, B, 0, a, new ArrayList<String>(), ans);
        return ans.get(0);
    }
    
    private int helper(int n, int k, int count, ArrayList<String> a, ArrayList<String> curr, ArrayList<String> ans) {
        if(curr.size() == n) {
            return ++count;
        }
        
        for(int i=0; i<a.size(); i++){
            String v = a.get(i);
            curr.add(v);
            a.remove(i);
            count = helper(n, k, count, a, curr, ans);
             if( count== k) {
               StringBuilder sb = new StringBuilder();
                for(String s: curr) {
                    sb.append(s);
                    
                }
                if(ans.size() > 1)
                    ans.set(0,sb.toString());
                else 
                    ans.add(sb.toString());
                return k;
                
            }
            a.add(i, v);
            curr.remove(curr.size()-1);
            
        }
        return count;
    }
    
   
}

