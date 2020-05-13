// https://www.interviewbit.com/problems/merge-overlapping-intervals/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    static class sorter implements Comparator<Interval> 
    {
        public int compare(Interval i1, Interval i2) 
        {
            if(i1.start == i2.start)
            {
                return i1.end - i2.end;
            }
            return i1.start - i2.start;    
        }
    }
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) 
    {
        ArrayList<Interval> answer = new ArrayList<>();
        Collections.sort(intervals, new sorter());
        int curr=0;
        while(curr<intervals.size())
        {
            int next = curr+1;
            int currstart = intervals.get(curr).start;
            int currend = intervals.get(curr).end;
            int newend = intervals.get(curr).end;
            while((next<intervals.size()) && (newend >= intervals.get(next).start))
            {
                newend = intervals.get(next).end > currend ? intervals.get(next).end : currend;
                currend = newend;
                next++;
            }
            answer.add(new Interval(currstart, newend));
            curr = next;
        }
        
        return answer;
    }
}
