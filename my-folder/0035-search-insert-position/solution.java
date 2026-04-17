class Solution {
    public int searchInsert(int[] nums, int target) {
        int ini = 0;
        int end = nums.length-1;

        while(ini <= end){
            int mid = ini+(end-ini)/2;

            if (nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
                end = mid-1;
            }
            else{
                ini = mid+1;
            }
        }

        return ini;
    }
}
