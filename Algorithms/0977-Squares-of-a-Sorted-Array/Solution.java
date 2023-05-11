class Solution {
	public int[] sortedSquares(int[] nums) {
		int len = nums.length, low = 0, high = len - 1, n, k;
		int[] res = new int[len];
		
		for(int i = len - 1; i >= 0; i--) {
			n = nums[low];
			k = nums[high];
			
			if(Math.abs(n) > Math.abs(k)) {
				res[i] = n*n;
				low++;
			} else {
				res[i] = k*k;
				high--;
			}
		}

		return res;
	}
}