// Problem Link : https://leetcode.com/problems/set-matrix-zeroes/description/ 

class Solution {
    public void setZeroes(int[][] matrix) {
        int n= matrix.length;
        int m= matrix[0].length;

        int[] row = new int[n];
        int[] col = new int[m];

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j] == 0 )
                {
                    row[i]=1;
                    col[j]=1;
                }
            }
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(row[i]==1 || col[j]==1)
                {
                    matrix[i][j]=0;
                }
            }
        }
    }
}

// Time and Space Complexity 

// Time Complexity : O(n*m)
// Space Complexity : O(n+m )


// Optimal Approach 
class Solution {
    public void setZeroes(int[][] matrix) {
        int n=matrix.length;
        int m= matrix[0].length;

        boolean firstRow =false;
        boolean firstCol =false;

        for(int i=0;i<n;i++)
        {
            if(matrix[i][0] == 0)
            {
                firstCol = true;
            }
        }
        for(int j=0;j<m;j++)
        {
            if(matrix[0][j] == 0)
            {
                firstRow = true;
            }
        }
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                if(matrix[i][j]==0)
                {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                if(matrix[i][0] == 0 || matrix[0][j]==0)
                {
                    matrix[i][j]=0;
                }
            }
        }

        if(firstRow)
        {
            for(int j=0;j<m;j++)
            {
                matrix[0][j] =0;
            }
        }
        if(firstCol)
        {
            for(int i=0;i<n;i++)
            {
                matrix[i][0] =0;
            }
        }
    }
}

// Time Complexity : O(n*m)
// Space Complexity : O(1)