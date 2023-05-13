class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder out = new StringBuilder();

        while(columnNumber > 0) {
            columnNumber--;
            char c = (char) (columnNumber % 26 + 'A');
            columnNumber /= 26;
            out.append(c);
        }

        out.reverse();
        return out.toString();
    }
}
