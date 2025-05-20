// https://leetcode.com/problems/permutations/description/

// using recursion
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] checked = new boolean[nums.length];

        calculate(nums, result,list, checked);

        return result;
    }
    private void calculate(int[] nums, List<List<Integer>> result, List<Integer> list, boolean[] checked){
        if(list.size() == nums.length)
        {
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(!checked[i]){
                list.add(nums[i]);
                checked[i] = true;
                calculate(nums, result, list, checked);
                checked[i]=false;
                list.remove(list.size()-1);
            }
        }
    }
}


// Time Complexity : O(N! * N)
// Space Complexity : O(N!*N)