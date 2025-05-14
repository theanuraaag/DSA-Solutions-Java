// https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/

class Solution {
    public boolean check(int[] nums) {
        if(nums.length <= 2) return true;
        int i,count;
        i=count=0;
        while(i<nums.length)
        {
            if(i==nums.length-1 && nums[i]>nums[0])
           { count++;}
            else if(i < nums.length-1 && nums[i]>nums[i+1])
           { count++;}
           i++;
        }
        if(count<=1) return true;
        else return false;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(1)