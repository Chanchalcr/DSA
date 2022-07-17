class Solution {
    public void rotate(int[][] matrix) {
        int N = matrix.length, M = matrix[0].length;
        int[] arr = new int[N*M];
        int k=0;
        for (int i = 0; i < M; i++) {
            for (int j = N-1; j >=0 ; j--) {
                 arr[k++]  = matrix[j][i];
            }
        }
        k=0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j]= arr[k++];
            }
        }
    }
}