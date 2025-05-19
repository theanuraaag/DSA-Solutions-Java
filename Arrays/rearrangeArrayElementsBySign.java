// https://leetcode.com/problems/rearrange-array-elements-by-sign/

// Brute Approach 
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] positiveArray = new int[nums.length/2];
        int[] negativeArray = new int[nums.length/2];
        int pos=0;
        int neg=0;
        for(int i=0;i<nums.length;i++)
        {
           if(nums[i] >0)
           {
            positiveArray[pos++] = nums[i];
           }
           else{
            negativeArray[neg++] = nums[i];
           }
        }
     
        pos=0;
        neg=0;
        for(int i=0;i<nums.length;i++)
        {
            if(i%2 == 0)
            {
                nums[i] = positiveArray[pos++];
            }
            else {
                nums[i] = negativeArray[neg++];
            }
        }
        return nums;
    }
}

// Time Complexity : O(2N)
// Space Complexity : O(N)


// Optimal Approach 
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] result = new int[nums.length];
        int pos=0;
        int neg=1;
        for(int i=0;i<nums.length;i++)
        {
           if(nums[i] < 0  )
           {
            result[neg] = nums[i];
            neg+=2;
           }
           else{
            result[pos] = nums[i];
            pos+=2;
           }
        }
     
        
        return result;
    }
}

// Time Complexity : O(N)
// Space Complexity : O(N)