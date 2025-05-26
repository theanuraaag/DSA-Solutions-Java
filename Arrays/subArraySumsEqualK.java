// https://leetcode.com/problems/subarray-sum-equals-k/

// Brute Approach
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count =0;
        
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++)
            {
                int sum=0;
                for(int n=i;n<=j;n++){
                    sum =sum+nums[n];
                }
                if(sum==k)
                {
                    count++;
                }
            }
        }
        return count;

    }
}

// Time Complexity : O(N^3)
// Space Complexity : O(1)


// Better Approach
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count =0;
        
        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++)
            {
                sum =sum+nums[j];
                if(sum==k)
                {
                    count++;
                }
            }
        }
        return count;

    }
}

// Time Complexity : O(N^2)
// Space Complexity : O(1)


// Optimal Approach using Maps
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count =0;
        Map<Integer,Integer> mp = new HashMap<>();
        int preSum = 0;
        mp.put(0,1);
        for(int i=0;i<nums.length;i++){
            preSum= preSum+nums[i];

            int sub = preSum -k;

            count = count + mp.getOrDefault(sub,0);
            mp.put(preSum,mp.getOrDefault(preSum,0)+1);
        }
        return count;

    }
}

// Time Complexity : O(N)
// Space Complexity : O(N)