class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1, sum = -1;

        while(low <= high) {
            sum = numbers[low] + numbers[high];
            if(sum < target)
                low++;
            else if(sum > target)
                high--;
            else
                break;
        }

        return new int[]{ low + 1, high + 1 };
    }
}
