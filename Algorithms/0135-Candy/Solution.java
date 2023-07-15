class Solution {
    public int candy(int[] ratings) {
        int N = ratings.length, k = 0;

        if(N == 1) 
            return 1;

        int[] candies = new int[N];
        Arrays.fill(candies, 1);

        for(int i = 1; i < N; i++)
            if(ratings[i - 1] < ratings[i])
                candies[i] = candies[i - 1] + 1;
        
        for(int i = N - 2; i >= 0; i--)
            if(ratings[i + 1] < ratings[i])
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
        
        for(int i = 0; i < N; k += candies[i++]);

        return k;
    }
}
