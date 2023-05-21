class Solution {
    public boolean checkIfExist(int[] arr) {
        int N = arr.length;

        for(int i = 0; i < N * N; i++) {
            int a = i / N, b = i % N;
            if((isValid(a, 0, N) && isValid(b, 0, N)) && a != b && arr[a] == 2 * arr[b])
                return true;
        }

        return false;
    }

    private boolean isValid(int x, int l, int r) {
        return l <= x && x < r;
    }
}
