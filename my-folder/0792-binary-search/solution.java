class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid = (start + end) / 2;
        while(start <= end){
            if(target < nums[mid]){
                end = mid - 1;
                mid = (start + end) / 2;
            }
            else if(target > nums[mid]){
                start = mid + 1;
                mid = (start + end) / 2;
            }
            else
                return mid;
        }

        return -1;
    }
}
