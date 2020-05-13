// https://www.interviewbit.com/problems/min-stack/

class Solution {
    
    private Deque<Integer> stack = new ArrayDeque<>();
    private Deque<Integer> minstack = new ArrayDeque<>();
    
    public void push(int x) {
        stack.push(x);
        if(!minstack.isEmpty())
        {
            int min = getMin();
            if(x<min) minstack.push(x);
            else minstack.push(min);
        }
        else minstack.push(x);
    }

    public void pop() {
        if(!stack.isEmpty()) 
        {
            stack.pop();
            minstack.pop();
        }
    }

    public int top() {
        if(stack.isEmpty()) return -1;
        else return stack.peek();
    }

    public int getMin() {
        if(minstack.isEmpty()) return -1;
        else return minstack.peek();
    }
}
