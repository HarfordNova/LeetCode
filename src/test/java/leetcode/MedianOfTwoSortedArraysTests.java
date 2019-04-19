package leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * MedianOfTwoSortedArraysTests
 */
public class MedianOfTwoSortedArraysTests {

    @Test
	@DisplayName("[1, 3],[2], 2.0")
	void test1() {
		MedianOfTwoSortedArrays medianOfTwoSortedArrays=new MedianOfTwoSortedArrays();
		int[] nums1 = {1, 3};
		int[] nums2={2};
		assertEquals(2.0, medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2), "should return 2.0");
    }
    
    @Test
	@DisplayName("[1, 3],[2,4], 2.5")
	void test2() {
		MedianOfTwoSortedArrays medianOfTwoSortedArrays=new MedianOfTwoSortedArrays();
		int[] nums1 = {1, 3};
		int[] nums2={2,4};
		assertEquals(2.5, medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2), "should return 2.5");
    }
    
    @Test
	@DisplayName("[],[1], 1")
	void test3() {
		MedianOfTwoSortedArrays medianOfTwoSortedArrays=new MedianOfTwoSortedArrays();
		int[] nums1 = {};
		int[] nums2={1};
		assertEquals(1.0, medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2), "should return 1");
    }
    
    @Test
	@DisplayName("[],[2,3], 2.5")
	void test4() {
		MedianOfTwoSortedArrays medianOfTwoSortedArrays=new MedianOfTwoSortedArrays();
		int[] nums1 = {};
		int[] nums2={2,3};
		assertEquals(2.5, medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2), "should return 2.5");
	}
}