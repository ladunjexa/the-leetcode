class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;
        
        String out = "";
        for(int i = 0; i < numRows; i++) {
            int increment = 2 * (numRows - 1);
            for(int j = i; j < s.length(); j += increment) {
                out += s.charAt(j);
                if( i >= 1 && i <= numRows - 2 && j + increment - 2 * i < s.length())
                    out += s.charAt(j + increment - 2 * i);
            }
        }

        return out;
    }
}
