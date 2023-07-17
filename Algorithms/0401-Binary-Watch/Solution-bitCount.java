class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        if(turnedOn < 0 || turnedOn > 10)
            return new ArrayList<>();
        
        List<String> out = new ArrayList<>();

        for(int h = 0; h <= 11; h++) {
            for(int m = 0; m <= 59; m++) {
                int sum = Integer.bitCount(h) + Integer.bitCount(m);
                if(sum == turnedOn)
                    out.add(String.format("%d:%02d", h, m));
            }
        }

        return out;
    }
}
