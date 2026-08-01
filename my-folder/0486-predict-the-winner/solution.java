class Solution {
    private Integer[][] memo;
    private int[] nums;

    public boolean predictTheWinner(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        memo = new Integer[n][n];

        return dfs(0, n - 1) >= 0;
    }

    private int dfs(int left, int right) {
        if (left == right) {
            return nums[left];
        }

        if (memo[left][right] != null) {
            return memo[left][right];
        }

        int pickLeft = nums[left] - dfs(left + 1, right);
        int pickRight = nums[right] - dfs(left, right - 1);

        memo[left][right] = Math.max(pickLeft, pickRight);
        return memo[left][right];
    }
}
