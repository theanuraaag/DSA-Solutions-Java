// https://leetcode.com/problems/kth-largest-element-in-an-array/description/ 

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        return nums[n-k];
    }
}

// Time Complexity : O(NLogN)
// Space : O(LogN) 