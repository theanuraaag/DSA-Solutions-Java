// https://leetcode.com/problems/rotate-image/

class Solution {
    public void swap(int[][] matrix, int i, int j)
    {
        int temp = matrix[i][j];
        matrix[i][j]=matrix[j][i];
        matrix[j][i]=temp; 
    }
    
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n= matrix[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=i;j<n;j++)
            {
               swap(matrix, i,j);
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<m/2;j++)
            {
                int temp=matrix[i][j];
                matrix[i][j] =matrix[i][m-1-j];
                matrix[i][m-1-j] = temp;

            }
        }

    }
}


// Time Complexity : O(N^2)
// Space Complexity : O(1)
