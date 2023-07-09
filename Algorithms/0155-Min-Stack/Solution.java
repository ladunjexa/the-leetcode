class MinStack {
    Stack<Integer> stack;
    int minEl = Integer.MAX_VALUE;

    public MinStack() {
        stack = new Stack<Integer>();
    }
    
    public void push(int val) {
        if(val <= minEl) {
            stack.push(minEl);
            minEl = val;
        }

        stack.push(val);
    }
    
    public void pop() {
        if(stack.pop() == minEl)
            minEl = stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minEl;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
