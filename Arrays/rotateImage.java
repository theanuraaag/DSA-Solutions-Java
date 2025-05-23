// https://leetcode.com/problems/rotate-image/

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++){
            for (int j = i+1; j < n; j++){
                int val = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = val;
            }
        }

        for (int i = 0; i < n; i++){
            int start = 0, end = n-1;
            while (start < end){
                int val = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = val;
                start += 1;
                end -= 1;
            }
        }

    }
}


// Time Complexity : O(N^2)
// Space Complexity : O(1)