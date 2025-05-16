// https://leetcode.com/problems/max-consecutive-ones/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count =0;
        int maxCount=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] == 1)
            {
                count++;
                maxCount = Math.max(maxCount,count);
            }
            else count = 0;
        }
        return maxCount;
    }
}

// Time Complexity : O(N)
// Space Complexity : O(1)