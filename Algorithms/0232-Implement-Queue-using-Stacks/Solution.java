class MyQueue {
    
    Stack<Integer> S1, S2;

    public MyQueue() {
        S1 = new Stack<>();
        S2 = new Stack<>();
    }
    
    public void push(int x) {
        while(!S1.isEmpty())
            S2.push(S1.pop());
        
        S1.push(x);

        while(!S2.isEmpty())
            S1.push(S2.pop());
    }
    
    public int pop() {
        if(!S1.isEmpty())
            return S1.pop();
        
        return -1;
    }
    
    public int peek() {
        if(!S1.isEmpty())
            return S1.peek();
        
        return -1;
    }
    
    public boolean empty() {
        return S1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
