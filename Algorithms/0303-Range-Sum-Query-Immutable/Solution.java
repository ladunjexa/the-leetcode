class NumArray {
    List<Integer> q;

    public NumArray(int[] nums) {
        q = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; q.add(nums[i++]));
    }
    
    public int sumRange(int left, int right) {
        int c = 0;
        for(int i = left; i <= right; c += q.get(i++));
        return c;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
