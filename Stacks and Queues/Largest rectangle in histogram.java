//https://www.interviewbit.com/problems/largest-rectangle-in-histogram/

public class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0, n=heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i<=n; i++)
        {
            int h = i==n ? 0 : heights[i];
            while(!stack.isEmpty() && heights[stack.peek()]>h)
            {
                int curr = stack.pop();
                int prev = stack.isEmpty() ? -1 : stack.peek();
                int area = heights[curr] * (i - prev - 1);
                maxArea = Integer.max(maxArea, area);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
