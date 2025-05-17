// https://leetcode.com/problems/sort-colors/

// Counting sort 
class Solution {
    public void sortColors(int[] nums) {
        int zero=0;
        int ones=0;
        int twos=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] == 0)
            {
                zero++;
            }
            else if(nums[i] ==1)
            {
                ones++;
            }
            else{
                twos++;
            }
        }
    
            for(int j=0;j<zero;j++)
            {
                nums[j] = 0;
            }
            for(int j=zero;j<ones+zero;j++)
            {
                nums[j] = 1;
            }
            for(int j=ones+zero;j<nums.length;j++)
            {
                nums[j]=2;
            }
    }
}
// Time Complexity : O(N)
// Space Complexity : O(1)


// Dutch National Flag Algorithm Approach
class Solution {
    public void swap(int[] nums, int i, int j)
    {
        int temp=0;
        temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void sortColors(int[] nums) {
        int low=0;
        int mid=0;
        int high = nums.length-1;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[mid] ==0)
            {
                swap(nums,low,mid);
                low++;
                mid++;
            }
            else if(nums[mid] ==1)
            {
                mid++;
            }
            else if(nums[mid] ==2)
            {
                swap(nums,mid,high);
                high--;
            }
        }
    }
}

// Time Complexity : O(N)
// Space Complexity : O(1)