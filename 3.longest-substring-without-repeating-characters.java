import java.util.HashSet;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (28.15%)
 * Total Accepted:    866K
 * Total Submissions: 3.1M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "abcabcbb"
 * Output: 3 
 * Explanation: The answer is "abc", with the length of 3. 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3. 
 * ⁠            Note that the answer must be a substring, "pwke" is a
 * subsequence and not a substring.
 * 
 * 
 * 
 * 
 */
class Solution {
    // 解决方案一：
    // 对于非空字符串，从第二个字符起挨个字符比较，直到遇到重复字符，得到一个长度
    // 遇到重复字符时，从此字符在前面字符串中位置的后面一位开始新的循环比较
    // 所有循环完成时，返回最长的长度
    // 对于空字符串，返回0
    public int lengthOfLongestSubstring1(String s) {
        int mLen = s.length() == 0 ? 0 : 1;
        int startIndex = 1;
        while (startIndex <= s.length() - mLen) {
            int len = 1;
            for (int i = startIndex; i < s.length(); i++) {
                int index = s.substring(startIndex - 1, i).indexOf(s.substring(i, i + 1));
                if (index == -1) {
                    len++;
                    continue;
                } else {
                    startIndex = startIndex + index + 1;
                    break;
                }
            }
            if (len > mLen)
                mLen = len;
        }

        return mLen;
    }

    //方案二，判断所有可能额字符串组合。此方案最慢。
    public int lengthOfLongestSubstring2(String s) {
        if(s.length()>50)
            return lengthOfLongestSubstring1(s);
        for (int i = s.length(); i > 0; i--) {
            for (int j = 0; j <= s.length() - i; j++) {
                String sub = s.substring(j, i + j);
                boolean dup=false;
                for (char c : sub.toCharArray()) {
                    if(sub.split(String.valueOf(c), 3).length>2){
                        dup=true;
                        break;
                    }
                }
                if (!dup) {
                    return i;
                }
            }
        }
        return 0;
    }
    //类似方案一，但是省掉了很多substring操作
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); 
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
