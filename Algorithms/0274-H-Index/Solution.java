class Solution {
    public int hIndex(int[] citations) {
        if(citations.length == 1 && citations[0] != 0)
            return 1;

        int[] sortedCitations = Arrays.stream(citations).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();

        int max = Integer.MIN_VALUE, numElementsGreaterThanN = 0;

        for(int i = 0; i < sortedCitations.length; i++) {
            if(sortedCitations[i] > i)
                numElementsGreaterThanN++;
            max = Math.max(max, numElementsGreaterThanN);
        }

        return max;
    }
}
