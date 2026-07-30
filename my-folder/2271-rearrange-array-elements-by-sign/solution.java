class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n]; // output array should be in same size of input array
        int posIndex = 0;
        int negIndex = 1;
        for (int num : nums){
            if (num>0) {
                result[posIndex] = num;
                posIndex = posIndex += 2;
            }

            else{
                result[negIndex] = num;
                negIndex = negIndex += 2;
            }
        }

        return result;
    }
}
