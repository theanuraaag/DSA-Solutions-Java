// https://leetcode.com/problems/missing-number/

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int ans=0;
        for(int i=0;i<=n;i++)
        {
            boolean found = false;
            for(int j=0;j<n;j++)
            {
                if(nums[j] == i)
                {
                    found = true;
                    break;
                }
            }
            if(!found) return i;

        }
        return -1;
    }
}

// Time Complexity : O(NxN)
// Space Complexity O(1)


// Optimal Approach 
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n*(n+1)/2;
        int actualSum = 0;
        for(int i:nums)
        {
            actualSum += i;
        }
        return expectedSum-actualSum;
    }
}

// Time Complexity : O(N)
// Space Complexity O(1)