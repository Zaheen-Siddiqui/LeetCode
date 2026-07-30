class Solution {
    public void moveZeroes(int[] nums) {
        int[] nums2 = Arrays.copyOf(nums, nums.length);
        // int[] nums2 = new int [nums.length];
        int j = 0, count = 0;
        for(int i = 0; i < nums2.length; i++){
            if(nums2[i] == 0){
                count++;
                continue;
            }
            
            nums[j] = nums[i];
            j++;
        }
        
        while(count != 0){
            nums[j] = 0; 
            j++; 
            count--;
        } 
    }
}
