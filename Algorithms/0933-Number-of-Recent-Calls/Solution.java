class RecentCounter {

    private LinkedList<Integer> requests;

    public RecentCounter() {
        requests = new LinkedList<Integer>();
    }
    
    public int ping(int t) {
        requests.addLast(t);
        while(t - 3000 > requests.getFirst())
            requests.removeFirst();
        
        return requests.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
