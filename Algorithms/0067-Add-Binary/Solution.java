class Solution {
    public String addBinary(String a, String b) {
        StringBuilder binarySum = new StringBuilder();
        int n = a.length() - 1, k = b.length() - 1, immed = 0;

        while(n >= 0 || k >= 0) {
            int sum = immed;

            if(n >= 0) {
                sum += a.charAt(n) - '0';
                n--;
            }
            if(k >= 0) {
                sum += b.charAt(k) - '0';
                k--;
            }

            immed = (sum > 1) ? 1 : 0;
            binarySum.append(sum % 2);
        }

        if(immed != 0)
            binarySum.append(immed);

        return binarySum.reverse().toString();
    }
}