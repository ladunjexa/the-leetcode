class Solution {

    public String intToRoman(int num) {
        String[][] s = {
            {"","I","II","III","IV","V","VI","VII","VIII","IX"}, // ones
            {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"}, // tens
            {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"}, // hundreds
            {"","M","MM","MMM"} // thousands
        };

        return s[3][num / 1000] + s[2][(num % 1000) / 100] + s[1][(num % 100) / 10] + s[0][num % 10];
    }

}