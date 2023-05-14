class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();

        for(int i = left; i <= right; i++)
            if(isSelfDivingNumber(i))
                result.add(i);

        return result;

    }
    public boolean isSelfDivingNumber(int n) {
        int remainder = 0, current = n;

        while(current != 0) {
            remainder = current % 10;
            if(remainder == 0 || n % remainder != 0)
                return false;
            current /= 10;
        }

        return true;
    }
}
