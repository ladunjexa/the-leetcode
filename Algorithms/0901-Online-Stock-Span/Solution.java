class StockSpanner {
    Stack<int[]> st;

    public StockSpanner() {  
        this.st = new Stack<int[]>();  
    }
    
    public int next(int price) {
        int N = 1;
        while(st.size() > 0 && price >= st.peek()[0]) {
            N += st.peek()[1];
            st.pop();
        }
        st.push(new int[]{ price, N });
        return N;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
