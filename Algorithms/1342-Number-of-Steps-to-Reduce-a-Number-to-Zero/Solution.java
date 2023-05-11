class Solution {
    public int numberOfSteps(int num) {
        if(num == 0)
            return 0;
        
        return numberOfSteps(num, -1);
    }

    public int numberOfSteps(int num, int steps) {
        if(num == 0)
            return steps;

        return (num % 2 == 0) ? numberOfSteps(num / 2, steps + 1) : numberOfSteps((num - 1) / 2, steps + 2);
    }
}
