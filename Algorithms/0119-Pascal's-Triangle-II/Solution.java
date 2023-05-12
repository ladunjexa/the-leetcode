class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        long coeff = 1;

        for (int k = 0; k <= rowIndex; k++) {
            row.add((int) coeff);
            coeff = coeff * (rowIndex - k) / (k + 1);
        }

        return row;
    }
}
