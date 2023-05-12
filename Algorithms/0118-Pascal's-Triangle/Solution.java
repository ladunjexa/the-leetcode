class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        List<Integer> current = new ArrayList<>(), previous = new ArrayList<>();

        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j <= i; j++)
                current.add(i != 0 && j > 0 && j < i ? (previous.get(j - 1) + previous.get(j)) : 1);
            
            pascalTriangle.add(current);
            previous = current;
            current = new ArrayList<>();
        }
        
        return pascalTriangle;
    }
}
