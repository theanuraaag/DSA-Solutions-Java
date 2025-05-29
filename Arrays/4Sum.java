// https://leetcode.com/problems/4sum/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0;i<n-1;i++){
            for(int j = i+1;j<n-2; j++){
                long target2 = (long)target - (long)nums[i] - (long)nums[j];
                int left = j+1;
                int right = n-1;
                while(left<right){
                    if(nums[left] + nums[right] > target2){
                        right--;
                    }
                    else if(nums[left] + nums[right] < target2){
                        left++;
                    }
                    else{
                        List<Integer> quad = new ArrayList<>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[left]);
                        quad.add(nums[right]);
                        ans.add(quad);
                        while(left<right && nums[left]==nums[left+1])left++;
                        while(left<right && nums[right]==nums[right-1])right--;
                        left++;
                        right--;
                    }
                }while(j<n-2 && nums[j] == nums[j+1])j++;
            }while(i<n-1 && nums[i] == nums[i+1])i++;
        }
        return ans;
    }
}

// Time Complexity : O(N^3)
// Space Complexity : O(1)