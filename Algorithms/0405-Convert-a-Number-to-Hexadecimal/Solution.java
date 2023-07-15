class Solution {
    public String toHex(int num) {
        String[] hexSymbols = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

        if(num == 0)
            return hexSymbols[0];

        StringBuilder hexCode = new StringBuilder();
        int mask = 15; // mask to extract the lower 4 bots of num (0b1111)
        
        while(num != 0) {
            int d = num & mask;
            hexCode.insert(0, hexSymbols[d]);
            num >>>= 4; // shift num to the right by 4 bits (unsigned shift)
        }

        return hexCode.toString();
    }
}
