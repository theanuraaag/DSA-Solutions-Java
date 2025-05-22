// https://leetcode.com/problems/longest-consecutive-sequence/

// Brute Force Approach 
class Solution {
    public boolean linearSearch(int[] nums, int target)
    {
        for(int i=0;i<nums.length;i++)
        {
            if(target == nums[i])
            {
                return true;
            }
        }
        return false;
    }
    public int longestConsecutive(int[] nums) {
        int longest =1;
        int count = 0;
        int x;
        if(nums.length < 1) return 0;
        for(int i=0;i<nums.length;i++)
        {
            x = nums[i];
            count = 1;

            while(linearSearch(nums, x+1) == true)
            {
                x=x+1;
                count++;
            }
            longest = Math.max(longest,count);
        } 
        return longest;  
    }
}
// Time Complexity : O(N^2)
// Space Complexity : O(1)


// Better Approach - Sorting 
class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int longest = 1;
        int count =0;
        int lastSmaller = Integer.MIN_VALUE;
        if(nums.length<1) return 0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]-1 == lastSmaller)
            {
                count++;
                lastSmaller = nums[i];
            }
            else if(nums[i] != lastSmaller){
                count =1;
                lastSmaller=nums[i];
            }
            longest = Math.max(longest,count);
        }
        return longest;
    }
}
// Time Complexity : O(N Log N)
// Space Complexity : O(1)


// Optimal Approach - using set
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        int longest = 1;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        for(int i : set)
        {
            if(!set.contains(i-1)){
                int count = 1;
                int x = i;
                while(set.contains(x+1))
                {
                    x++;
                    count++;
                }
                longest = Math.max(longest,count);
            }
        }
        return longest;
    }
}
// Time Complexity : O(N)
// Space Complexity : O(N)