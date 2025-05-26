// https://leetcode.com/problems/spiral-matrix/description/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n= matrix[0].length;
        int startRow = 0;
        int endRow = m-1;
        int startCol = 0;
        int endCol = n-1;
        List <Integer> list = new ArrayList<>();
        while(startRow <= endRow && startCol <= endCol)
        {
            for(int i=startCol; i <= endCol;i++)
            {
                list.add(matrix[startRow][i]);
            }
            ++startRow;
            for(int i=startRow;i <=endRow;i++)
            {
                list.add(matrix[i][endCol]);
            }
            --endCol;
           if(startRow <= endRow)
            {
                for(int i=endCol;i >= startCol;i--)
                {
                    list.add(matrix[endRow][i]);
                }
                --endRow;           
            }
            if(startCol <= endCol)
            {
                for(int i=endRow;i >= startRow;i--)
                {
                    list.add(matrix[i][startCol]);
                }
                ++startCol;
            }
        }
        return list;
    }
}

// Time Complexity : O(M*N)
// Space Complexity : O(1)