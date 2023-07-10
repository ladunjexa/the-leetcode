class MedianFinder {
    PriorityQueue<Integer> left, right;

    public MedianFinder() {
        left = new PriorityQueue<Integer>(Collections.reverseOrder());
        right = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        left.add(num);
        right.add(left.remove());

        if(left.size() < right.size())
            left.add(right.remove());
    }
    
    public double findMedian() {
        return left.size() > right.size() ? left.peek() : (left.peek() + right.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
