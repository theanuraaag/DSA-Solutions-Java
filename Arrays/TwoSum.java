// https://leetcode.com/problems/two-sum/description/

// Brute Force
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i=0;i<nums.length-1;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[i]+nums[j] == target)
                {
                    result[0]=i;
                    result[1]=j;
                    return result;
                }
            }
        }
        return result;
    }
}

// Time Complexity : O(N*N)
// Space Complexity : O(1)

// Optimised Approach using HashMap 
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            Integer index = mp.get(nums[i]);
            if(index != null){
                return new int[]{i,index};
            }
            mp.put(target - nums[i],i);
        }
        return nums;
    }
}

// Time Complexity : O(N)
// Space Complexity : O(N)