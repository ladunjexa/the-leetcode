class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] warmer = new int[temperatures.length];
        Stack<Integer> stack = new Stack<Integer>();

        for(int i = temperatures.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()])
                stack.pop();
            
            warmer[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }

        return warmer;
    }
}
