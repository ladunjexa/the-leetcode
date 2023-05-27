class Solution {
    public int largestAltitude(int[] gain) {
        int N = gain.length;
        int current = 0, highest = 0;
        
        for(int i = 0; i < N; i++) {
            current += gain[i];
            highest = Math.max(highest, current);
        }

        return highest;
    }
}
