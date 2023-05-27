class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int p = 0, len = flowerbed.length;

        if(n == 0)
            return true;

        if(n > getMaxFlowers(len))
            return false;

        if(len == 1)
            return !(flowerbed[0] == 1);

        if(flowerbed[0] == 0 && flowerbed[1] == 0)
            p++;
        
        if(1 != len - 1 && flowerbed[len - 1] == 0 && flowerbed[len - 2] == 0) 
            p++;
            
        for(int i = 1; i < len - 1; i++) {
            if(flowerbed[i - 1] != 1 && flowerbed[i + 1] != 1 && flowerbed[i] != 1) {
                p++;
                flowerbed[i] = 1;
            }
        }

        return n <= p;
    }

    private int getMaxFlowers(int n) {
        return (n % 2 == 0) ? n / 2 : (n / 2) + 1;
    }
}
