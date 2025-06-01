// https://leetcode.com/problems/maximum-product-subarray/description/


class Solution {
    public int maxProduct(int[] nums) {
        int lp_temp = 1;
        int n = nums.length-1;
        int rp_temp = 1;
        int max_product = Integer.MIN_VALUE;
        for(int i=0; i<=n; i++){
            lp_temp*=nums[i];
            rp_temp*=nums[n-i];
            max_product = Math.max(max_product,Math.max(lp_temp,rp_temp));
            if(lp_temp==0){
                lp_temp=1;
            }
            if(rp_temp==0){
                rp_temp=1;
            }
        }
        return max_product;
    }
}


// Time Complexity : O(N)
// Space Complexity : O(1)