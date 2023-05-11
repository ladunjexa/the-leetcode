class Solution {
    public double average(int[] salary) {
        int len = salary.length;
        Arrays.sort(salary);
        double sum = 0;

        for(int i = 1; i < len - 1; i++)
            sum += salary[i];
        
        return ((double) sum / (len - 2));
    }
}