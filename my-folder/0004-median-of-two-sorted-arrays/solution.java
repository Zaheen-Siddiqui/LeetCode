class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        // Always binary search the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int low = 0;
        int high = m;

        while (low <= high) {

            // Partition nums1
            int partition1 = (low + high) / 2;

            // Partition nums2
            int partition2 = (m + n + 1) / 2 - partition1;


            // Values around partitions
            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE 
                                             : nums1[partition1 - 1];

            int minRight1 = (partition1 == m) ? Integer.MAX_VALUE 
                                              : nums1[partition1];

            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE 
                                             : nums2[partition2 - 1];

            int minRight2 = (partition2 == n) ? Integer.MAX_VALUE 
                                              : nums2[partition2];


            // Correct partition found
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {

                // Odd total length
                if ((m + n) % 2 == 1) {
                    return Math.max(maxLeft1, maxLeft2);
                }

                // Even total length
                return (Math.max(maxLeft1, maxLeft2) 
                      + Math.min(minRight1, minRight2)) / 2.0;
            }

            // Move partition1 left
            else if (maxLeft1 > minRight2) {
                high = partition1 - 1;
            }

            // Move partition1 right
            else {
                low = partition1 + 1;
            }
        }

        return 0.0; // unreachable
    }
}
