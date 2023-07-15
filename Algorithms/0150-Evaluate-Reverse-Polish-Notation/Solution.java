class Solution {
    private int index;

    public int evalRPN(String[] tokens) {
        index = tokens.length - 1;
        return evalExpression(tokens);    
    }

    private int evalExpression(String[] tokens) {
        if(index < 0)
            return -1;
        
        if(!isOperator(tokens[index]))
            return Integer.parseInt(tokens[index--]);
        
        String operator = tokens[index--];
        int rightOp = evalExpression(tokens), leftOp = evalExpression(tokens);
        
        if(operator.equals("+"))
            return leftOp + rightOp;
        else if(operator.equals("-"))
            return leftOp - rightOp;
        else if(operator.equals("*"))
            return leftOp * rightOp;
        else if(operator.equals("/"))
            return leftOp / rightOp;
        else
            return -1;
    }

    private boolean isOperator(String s) {
        return s.length() == 1 && !Character.isDigit(s.charAt(0));
    }
}
