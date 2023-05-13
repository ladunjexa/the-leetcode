class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for(int i =0; i <= n; i++)
            result[i] = countBitsRec(i);

        return result;
    }

    private int countBitsRec(int n) {
        if(n == 0 || n == 1)
            return n;

        return countBitsRec(n / 2) + ((n % 2 == 0) ? 0 : 1);
    }
}
