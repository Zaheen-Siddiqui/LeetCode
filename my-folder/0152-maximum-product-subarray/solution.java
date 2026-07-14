class Solution {
    public int maxProduct(int[] nums) {
        int maxEnding = nums[0], minEnding = nums[0], answer = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            int tempMax = Math.max(curr, 
                            Math.max(maxEnding * curr, minEnding * curr));

            int tempMin = Math.min(curr, 
                            Math.min(maxEnding * curr, minEnding * curr));

            maxEnding = tempMax;
            minEnding = tempMin;

            answer = Math.max(answer, maxEnding);
        }

        return answer;
    }
}
