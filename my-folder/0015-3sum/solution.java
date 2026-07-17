class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
         Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length;
        if(n<3) 
            return new ArrayList<>(set); 
        
        for(int i = 0; i < n - 2; i++){
            if(i > 0 && nums[i] == nums[i - 1]) 
                continue;
            
            int right = n - 1;
            int left = i + 1;

            while(left < right){
                long sum = (long) nums[i] + (long) nums[left] + (long) nums[right];

                if(sum == 0){
                    set.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        right--;
                        left++;
                }
                else if (sum > 0)
                    right--;
                else
                    left++;
            }
        }
        return new ArrayList<>(set);
    }
}
