class Solution {
    public int majorityElement(int[] nums) {
        int c = 0, el = 0;

        for(int i = 0; i < nums.length; i++) {
            el = (c == 0) ? nums[i] : el;
            c = (c + ((nums[i] == el) ? 1 : -1));
        }

        return el;
    }
}
