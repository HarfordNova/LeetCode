package leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TwoSumTests {

	@Test
	@DisplayName("[2, 7, 11, 15], 9, [0, 1]")
	void addsTwoNumbers() {
		TwoSum twoSum = new TwoSum();
		int[] a = {2, 7, 11, 15};
		assertArrayEquals(new int[]{0, 1}, twoSum.twoSum(a, 9), "Given nums = [2, 7, 11, 15], target = 9, should return [0, 1]");
	}

	// @ParameterizedTest(name = "nums:{0}, target:{1}, return:{2}")
	// @CsvSource({
	// 		"0,    1,   1",
	// 		"1,    2,   3",
	// 		"49,  51, 100",
	// 		"1,  100, 101"
	// })
	// void add(int first, int second, int expectedResult) {
	// 	Calculator calculator = new Calculator();
	// 	assertEquals(expectedResult, calculator.add(first, second),
	// 			() -> first + " + " + second + " should equal " + expectedResult);
	// }
}