// https://leetcode.com/problems/reverse-pairs/description/


class Solution {
    public int reversePairs(int[] nums) {
        return mergesort(nums,0,nums.length-1);
    }
    int mergesort(int[] nums, int low, int high){
        int count = 0;
        if(low >= high)return count;
        int mid = low + (high - low)/2;
        count+= mergesort(nums,low,mid);
        count+= mergesort(nums,mid+1,high);
        count += countpairs(nums,low,mid,high);
        merge(nums,low,mid,high);
        return count;
    }
    void merge(int nums[], int low, int mid, int high){
        int left = low;
        int right = mid + 1;
        List<Integer> temp = new ArrayList<>();
        while(left <= mid && right<=high){
            if(nums[left] <= nums[right])temp.add(nums[left++]);
            else temp.add(nums[right++]);
        }
        while(left<=mid)temp.add(nums[left++]);
        while(right <= high)temp.add(nums[right++]);
        for(int i = low; i <= high;i++){
            nums[i] = temp.get(i-low);
        }
    }
    int countpairs(int[] nums, int low, int mid, int high){
        int count = 0;
        int right = mid + 1;
        for(int i = low; i <= mid;i++){
            while(right <= high && nums[i] > 2L * nums[right])right++;
            count += (right - (mid+1));
        }
        return count;
    }
}


// Time Complexity : O(NLogN)
// Space Complexity : O(N)