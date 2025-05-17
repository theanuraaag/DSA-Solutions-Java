// https://leetcode.com/problems/majority-element/description/

// Brute Force Approach 
// @ we can use nested loops to calculate frequencies of each element and then print the element which count is more than the majority number 

// Time Complexity : O(N*N)
// Space Complexity : O(1)


// Better Approach using HashMap
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            mp.put(nums[i], mp.getOrDefault(nums[i],0)+1);

            if(mp.get(nums[i]) > nums.length/2){
                return nums[i];
            }
        }
        return -1;
    }
}

// Time Complexity : O(N)
// Space Complexity : O(N)


// Moore's Voting Algorithm 
class Solution {
    public int majorityElement(int[] nums) {
        int count=0;
        int element=0;
        for(int i=0;i<nums.length;i++)
        {
            if(count==0)
            {
                count=1;
                element=nums[i];
            }
            else if(nums[i] == element)
            {
                count++;
            }
            else{
                count--;
            }
        }
        return element;
    }
}
// Time Complexity : O(N)
// Space Complexity : O(1)