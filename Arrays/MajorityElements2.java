// https://leetcode.com/problems/majority-element-ii/description/

// Brute Approach
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int count =0;
        for(int i=0;i<nums.length;i++)
        {
            if(list.size() == 0 || list.get(0) != nums[i] )
            {
                count =0;
                for(int j=0;j<nums.length;j++)
                {
                    if(nums[j] == nums[i])
                    {
                        count++;
                    }
                }
                if(count > nums.length/3)
                {
                    list.add(nums[i]);
                }
            }

            if(list.size() == 2) break;
        }
        return list;
    }
}

// Time Complexity : O(N*N)
// Space Complexity : O(1)


// Better Approach
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums);
        List<Integer>arr=new ArrayList<>();
        HashMap<Integer,Integer>hash=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hash.put(nums[i],hash.getOrDefault(nums[i],0)+1);
        }
        for(int k:hash.keySet()){
            if(hash.get(k)>nums.length/3){
                arr.add(k);
            }
        }
        return arr;
    }
}

// Time Complexity : O(N)
// Space Complexity : O(N)
