// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

// Using set 
class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for(int i:nums)
        {
            set.add(i);
        }
        int index=0;
        for(int it: set)
        {
            nums[index] =it;
            index++;
        }
        return index;
    }
}

// Time Complexity : O(NLogN)
// Space Complexity : O(N)

// Two Pointer Approach 
class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        for(int j=1;j<nums.length;j++)
        {
            if(nums[j] != nums[i])
            {
                nums[i+1] = nums[j];
                i++;
            }
        }
       return i+1;
    }
}


// Time Complexity : O(N)
// Space Complexity : O(1)