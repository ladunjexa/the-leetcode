class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int N = str1.length(), K =str2.length();

        if(!((str1 + str2).equals(str2 + str1)))
            return "";
        
        return str1.substring(0, greatestCommonDivisor(N, K));
    }

    public int greatestCommonDivisor(int i, int j) {
        return (j == 0) ? i : greatestCommonDivisor(j, i % j);
    }
}
