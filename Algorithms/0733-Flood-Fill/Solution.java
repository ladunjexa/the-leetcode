class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        floodFill(image, sr, sc, color, image[sr][sc]);
        return image;
    }
    
    private void floodFill(int[][] image, int row, int col, int color, int value) {
        if((row < 0 || row >= image.length) || (col < 0 || col >= image[0].length))
            return;
        
        if(image[row][col] != value || image[row][col] == color)
            return;
        
        image[row][col] = color;
        floodFill(image, row + 1, col, color, value);
        floodFill(image, row - 1, col, color, value);
        floodFill(image, row, col + 1, color, value);
        floodFill(image, row, col - 1, color, value);

    }
}
