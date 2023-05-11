class Solution {
    public int maximumWealth(int[][] accounts) {
        int N = accounts.length, max = getCustomerWealth(accounts, 0), i = 0;
        
        if(N == 1)
            return max;
        
        while(i < N) {
            int current = getCustomerWealth(accounts, i++);
            if(current > max)
                max = current;
        }

        return max;
    }

    public int getCustomerWealth(int[][] accounts, int c) {
        int M = accounts[c].length, total = accounts[c][0], i = 1;
        while(i < M)
            total += accounts[c][i++];
        
        return total;
    }
}
