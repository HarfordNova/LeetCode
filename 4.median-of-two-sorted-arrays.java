/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (25.99%)
 * Total Accepted:    412.9K
 * Total Submissions: 1.6M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * Example 1:
 * 
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * The median is 2.0
 * 
 * 
 * Example 2:
 * 
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 * 
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length == 0 && nums2.length == 1)
            return nums2[0] / 1.0;
        if (nums2.length == 0 && nums1.length == 1)
            return nums1[0] / 1.0;

        List<Integer> nums = new ArrayList<>();
        for (int n : nums1) {
            nums.add(n);
        }
        for (int n : nums2) {
            nums.add(n);
        }
        Collections.sort(nums);
        return getMedianOfArray(nums);
    }

    private boolean isEven(int num) {
        if (num % 2 == 0)
            return true;
        else
            return false;
    }

    private double getMedianOfArray(int[] nums) {
        if (nums.length == 0)
            return 0.0;
        double median = 0.0;
        if (isEven(nums.length)) {
            int medianIndex = nums.length / 2;
            median = (nums[medianIndex - 1] + nums[medianIndex]) / 2.0;
        } else {
            median = nums[nums.length / 2];
        }
        return median;
    }

    private double getMedianOfArray(List<Integer> nums) {
        if (nums.size() == 0)
            return 0.0;
        double median = 0.0;
        if (isEven(nums.size())) {
            int medianIndex = nums.size() / 2;
            median = (nums.get(medianIndex - 1) + nums.get(medianIndex)) / 2.0;
        } else {
            median = nums.get(nums.size() / 2);
        }
        return median;
    }
}
