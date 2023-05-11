class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for(int i = len - 1; i >= 0; i--) { // iterate over array from top to base
            if(digits[i] < 9) { // if digits[i] is less than 9 means can be increment by one
                digits[i]++;
                return digits;
            }
            digits[i] = 0; // otherwise, it have to be 9 means can be changed to 0
        }

        // conditional block executed when all digits in the original are 9, 
        // that is, you can increase the array by 1 and  replace the first cell with 1
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }
}