class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        for(int i = 0; i <= rowIndex; i++) {
            int coeff = 1;
            // Calculate C(rowIndex, k)
            for(int j = 1; j <= i; j++)
                coeff = (int) Math.round((double) coeff * (rowIndex - i + j) / j);
            
            row.add(coeff);
        }

        return row;
    }
}
