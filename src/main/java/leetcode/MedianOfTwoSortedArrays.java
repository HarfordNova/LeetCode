package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0, high = nums1.length;
        int subArraySize = (nums1.length + nums2.length + 1) / 2;

        while (low <= high) {
            int sliceIndexA = (low + high) / 2;
            int sliceIndexB = subArraySize - sliceIndexA;
            int maxLeftA = sliceIndexA == 0 ? Integer.MIN_VALUE : nums1[sliceIndexA - 1];
            int minRightA = sliceIndexA == nums1.length ? Integer.MAX_VALUE : nums1[sliceIndexA];
            int minRightB = sliceIndexB == nums2.length ? Integer.MAX_VALUE : nums2[sliceIndexB];
            int maxLeftB = sliceIndexB == 0 ? Integer.MIN_VALUE : nums2[sliceIndexB-1];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if (isEven(nums1.length + nums2.length))
                    return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
                else
                    return (double) Math.max(maxLeftA, maxLeftB);

            }
            if (maxLeftA > minRightB)
                high = sliceIndexA - 1;
            if (maxLeftB > minRightA)
                low = sliceIndexA + 1;
        }

        throw new IllegalArgumentException();
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {

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

    private boolean isEven(int num) {
        if (num % 2 == 0)
            return true;
        else
            return false;
    }
}