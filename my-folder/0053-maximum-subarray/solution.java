class Solution {
    public int maxSubArray(int[] nums) {
        int CurrentSum = nums[0], MaxSum = nums[0];
        for (int i = 1; i<=nums.length-1; i++){
            CurrentSum = CurrentSum + nums[i];
            if(CurrentSum < nums[i])
                CurrentSum = nums[i];
            MaxSum = Math.max(MaxSum, CurrentSum);
        }
        return MaxSum;
    }
}
