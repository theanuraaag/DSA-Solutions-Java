// https://leetcode.com/problems/maximum-subarray

// Brute Force Approach 
class Solution {
    public int maxSubArray(int[] nums) {
        int largest=Integer.MIN_VALUE;
        if(nums.length == 1)
        {
            return nums[0];
        }
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i;j<nums.length;j++)
            {   
                int sum=0;
                for(int k=i;k<=j;k++)
                {
                    sum = sum+ nums[k];
                }
                largest= Math.max(largest,sum);
            }
        }
        return largest;
    }
}


// Time Complexity : O(N^3)
// Space Complexity : O(1)


// Better Approach
class Solution {
    public int maxSubArray(int[] nums) {
        int largest=Integer.MIN_VALUE;
        if(nums.length == 1)
        {
            return nums[0];
        }
        for(int i=0;i<nums.length;i++)
        {
            int sum=0;
            for(int j=i;j<nums.length;j++)
            {   
                sum = sum + nums[j];
                largest= Math.max(largest,sum);
            }
        }
        return largest;
    }
}

// Time Complexity : O(N^2)
// Space Complexity : O(1)


// Optimal Approach - Kadane's Algorithm 
class Solution {
    public int maxSubArray(int[] nums) {
        int largest=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
           sum = sum+nums[i];
           if(sum>largest){
            largest=sum;
           }

           if(sum < 0){
            sum=0;
           }
        }
        return largest;
    }
}

// Time Complexity : O(N)
// Space Complexity : O(1)