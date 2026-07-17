class Solution {
    public int removeDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        int j = 1;
        for(int i = 1; i <= nums.length - 1; i++){
            while(j <= nums.length - 1){
                if(list.get(i - 1) != nums[j]){
                    list.add(nums[j]);
                    j++;
                    break;
                }
                j++;
            }
        }
        for(int i = 0; i <= list.size() - 1; i++){
            nums[i] = list.get(i);
        }
        return list.size();
    }
}
