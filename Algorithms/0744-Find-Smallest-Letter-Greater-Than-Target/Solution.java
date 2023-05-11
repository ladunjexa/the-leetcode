class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0, high = letters.length - 1;
        char out = letters[0];

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(letters[mid] > target) {
                out = letters[mid];
                high = mid - 1;
            } else
                low = mid + 1;
        }

        return out;     
    }
}
