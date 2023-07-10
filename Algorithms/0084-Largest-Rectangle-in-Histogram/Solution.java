class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<Integer>();

        int N = heights.length, largestRectangle = 0;

        for(int i = 0; i <= N; i++) {

            while(!stack.empty() && (i == N || heights[stack.peek()] >= heights[i])) {
                int area = heights[stack.peek()];
                stack.pop();

                area *= (stack.empty()) ? i : i - stack.peek() - 1;

                largestRectangle = Math.max(largestRectangle, area);
            }

            stack.push(i);
        }

        return largestRectangle;
    }
}
