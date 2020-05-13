// https://www.interviewbit.com/problems/anagrams/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        if(A==null || A.size()==0) return new ArrayList<>();
        
        Map<String, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        for(int i=0; i<A.size(); i++)
        {
            String curr = A.get(i);
            char[] ch = new char[26];
            for(char c : curr.toCharArray()) ch[c-'a']++;
            String temp = String.valueOf(ch);
            if(!map.containsKey(temp)) map.put(temp, new ArrayList<>());
            map.get(temp).add(i+1);
        }
        
        for(Map.Entry<String, ArrayList<Integer>> entry : map.entrySet())
        {
            ArrayList<Integer> list = entry.getValue();
            Collections.sort(list);
            res.add(list);
        }
        return res;
    }
}