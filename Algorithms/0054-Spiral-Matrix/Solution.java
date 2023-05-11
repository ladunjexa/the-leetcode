class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralVector = new ArrayList<>();
        
        int N = matrix.length - 1, M = matrix[0].length - 1, T = 0, L = 0;

        if(matrix == null || N == -1)
            return spiralVector;

        while(T <= N && L <= M) {
            for(int i = L; i <= M; i++) // Traverse top row
                spiralVector.add(matrix[T][i]); 
            T++;

            for(int i = T; i <= N; i++) // Traverse right column
                spiralVector.add(matrix[i][M]); 
            M--;

            if(T <= N) { 
                for(int i = M; i >= L; i--) // Traverse bottom row
                    spiralVector.add(matrix[N][i]);
                N--;
            }

            if(L <= M) {  
                for(int i = N; i >= T; i--) // Traverse left column
                spiralVector.add(matrix[i][L]);
                L++;
            }
        }

        return spiralVector;
    }
}
