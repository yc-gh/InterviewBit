// https://www.interviewbit.com/problems/repeat-and-missing-number-array/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        // s1 = sum(1...n)
        // s2 = sum([1]..[n])
        // s1 = s2 - A + B
        // s2 - s1 = A - B
        // d1 = A-B -> (1)
        // ss1 = sumSq(1..n)
        // ss2 = sumSq([1]..[n])
        // ss2 - ss1 = A^2 - B^2
        // ss2 - ss1 = (A+B)(A-B)
        // d2 = (A+B)(A-B) -> (2)
        // (2)/(1) -> d2/d1 = A+B -> (3)
        // (1)+(3) -> 2A = d2/d1 + d1
        // A = 1/2(d2/d1 + d1)
        // B = 1/2(d2/d1+d1) - d1
        
        long sum_all = 0;
        long sum_act = 0;
        long sq_all = 0;
        long sq_act = 0;
        int j=1;
        for(int i : A)
        {
            sum_act += i;
            sq_act += ((long)i * (long)i);
            
            sum_all += j;
            sq_all += ((long)j * (long)j);
            ++j;
        }
        
        long d1 = sum_act - sum_all;
        long d2 = sq_act - sq_all;
        
        long a = ((d2/d1)+d1)/2;
        long b = a - d1;
        
        ArrayList<Integer> res = new ArrayList<>();
        res.add((int)a);
        res.add((int)b);
        return res;
    }
}
