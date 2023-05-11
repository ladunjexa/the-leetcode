class Solution {
    public int romanToInt(String s) {
        int result = 0, out = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            switch(s.charAt(i)) {
                case 'I': out = 1; break;
                case 'V': out = 5; break;
                case 'X': out = 10; break;
                case 'L': out = 50; break;
                case 'C': out = 100; break;
                case 'D': out = 500; break;
                case 'M': out = 1000; break;
            }
            if(out * 4 < result) result -= out;
            else result += out;
        }
        return result;
    }
}