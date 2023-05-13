class MyStack {

    Stack<Integer> Stack = new Stack<>();
    Queue<Integer> Q1, Q2;

    public MyStack() {
        Q1 = new LinkedList<>();
        Q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        Q1.add(x);
    }
    
    public int pop() {
        while(Q1.size() > 1)
            Q2.add(Q1.remove());
        
        int pop = Q1.remove();
        Queue<Integer> curr = Q1;
        Q1 = Q2;
        Q2 = curr;

        return pop;
    }

    public int top() {
        while(Q1.size() > 1)
            Q2.add(Q1.remove());
        
        int top = Q1.peek();
        Q2.add(Q1.remove());
        Queue<Integer> curr = Q1;
        Q1 = Q2;
        Q2 = curr;

        return top;
    }
    
    public boolean empty() {
        return Q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
