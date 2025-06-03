// https://leetcode.com/problems/search-insert-position/description/


class Solution {
    public int searchInsert(int[] nums, int target) {
         ArrayList<Integer> arr=new ArrayList<>();
         for(int i=0;i<nums.length;i++)
         {
             arr.add(nums[i]);
         }
         if(arr.contains(target))
         {
            return arr.indexOf(target);
         }
         else{
            arr.add(target);
            arr.sort(Collections.reverseOrder());
             Collections.reverse(arr);
              return arr.indexOf(target);
         }
    }
}

// Time Complexity : O(N)
// Space Complexity : O(N)