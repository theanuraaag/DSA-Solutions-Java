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



// Optimal Approach
class Solution {
    public List<Integer> majorityElement(int[] arr) {
        int count1 =0;
        int count2 = 0;
        int element1 = Integer.MIN_VALUE;
        int element2 = Integer.MIN_VALUE;

        List<Integer> list = new ArrayList<>();

        for(int i=0; i<arr.length; i++){
            if(count1 == 0 && arr[i] != element2){
                element1 = arr[i];
                count1++;
            }
            else if(count2 ==0 && arr[i] != element1){
                element2 = arr[i];
                count2++;                
            }
            else if(arr[i] == element1){
                count1++;
            }
            else if(arr[i] == element2){
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }

        count1 =0;
        count2 =0;

        for(int i=0; i<arr.length; i++){
            if(arr[i] == element1){
                count1++;
            }
            if(arr[i] == element2){
                count2++;
            }
        }

        if(count1 > arr.length/3){
            list.add(element1);
        }
        if(count2 > arr.length/3 && element2 != element1){
            list.add(element2);
        }

        return list;
    }
}
// Time Complexity : O(N)
// Space Complexity : O(1)