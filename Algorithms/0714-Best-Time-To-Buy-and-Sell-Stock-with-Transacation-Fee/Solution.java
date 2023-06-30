class Solution {
    public int maxProfit(int[] prices, int fee) {
        int N = prices.length, b = prices[0], s = 0, p =0;

        if(N == 0)
            return 0;

        for(int i = 1; i < N; i++) {
            b = Math.min(b, prices[i] - p);
            s = Math.max(p, prices[i] - b - fee);
            p = s;
        }

        return p;
    }
}
