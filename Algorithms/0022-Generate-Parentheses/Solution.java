class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> parenthesis = new LinkedList<>();
        generateParenthesis(n, n, "", parenthesis);
        return parenthesis;
    }

    private void generateParenthesis(int open, int close, String current, List<String> gap) {
        if(open > 0)
            generateParenthesis(open - 1, close, current + "(", gap);

        if(close > open)
            generateParenthesis(open, close - 1, current + ")", gap);

        if(open == 0 && close == 0)
            gap.add(current);
    }
}