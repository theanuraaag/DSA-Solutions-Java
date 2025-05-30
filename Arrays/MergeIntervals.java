// https://leetcode.com/problems/merge-intervals/description/


class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));

        Stack<int[]> stack = new Stack<>();
        for (int[] interval: intervals) {
            int start = interval[0];
            int end = interval[1];
            if (!stack.isEmpty() && stack.peek()[1] >= start) {
                int[] val = stack.pop();
                start = val[0];
                end = Math.max(end, val[1]);
            }

            stack.push(new int[]{start, end});
        }   

        int n = stack.size();

        int[][] result = new int[n][2];

        int index = n - 1;
        while(!stack.isEmpty()) {
            int[] val = stack.pop();
            result[index][0] = val[0];
            result[index][1] = val[1];
            index--;
        }

        return result;
    }
}

// Time Complexity : O(NlogN)
// Space Complexity : O(N) 