class Solution {
    public void sortColors(int[] nums) {
        int zp=0, op= 0, sp = 0;
        for(int i = 0; i <= nums.length - 1; i++){
            if(nums[i] == 0)
                zp++;
            else if(nums[i] == 1)
                op++;
            else
                sp++;
        }
        for(int i = 0; i <= nums.length - 1; i++){
            if(zp > 0){
                nums[i] = 0;
                zp--;
            }
            else if(op > 0){
                nums[i] = 1;
                op--;
            }
            else if(sp > 0){
                nums[i] = 2;
                sp--;
            }
            // else
            //     continue;
        }
    }
}
