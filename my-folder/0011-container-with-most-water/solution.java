class Solution {
    public int maxArea(int[] height) {
        if(height.length <= 1)
            return 0;
        
        int left = 0, right = height.length - 1;
        int max = Integer.MIN_VALUE, Area;

        while(left < right){
            Area = Math.min(height[left], height[right]) * Math.abs(right - left);
            max = Math.max(max, Area);

            if(height[left] > height[right])
                right--;
                
            else if(height[left] <= height[right]) 
                left++;
        }

        return max;
    }
}
