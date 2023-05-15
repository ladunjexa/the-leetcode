class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int M = matrix[0].length, low = 0, high = matrix.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2, min = matrix[mid][0];
                
            if(min <= target && target <= matrix[mid][M - 1])
                return binarySearch(matrix[mid], 0, M - 1, target);
            else if(min < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        
        return false;
    }

    private boolean binarySearch(int[] row, int low, int high, int target) {
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(row[mid] == target)
                return true;
            else if(row[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return false;
    }
}
