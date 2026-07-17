class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int curr = 0, max = 0;
        for(int num : nums){
            if(num == 1){
                curr++;
            }
            else{
                if(curr >  max)
                    max = curr;
                curr = 0;
            }
        }
        if(curr >  max)
            return curr;
        return max;
    }
}
