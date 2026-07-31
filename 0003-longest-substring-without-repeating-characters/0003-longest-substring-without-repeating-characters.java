import java.util.Arrays;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        int[] hash = new int[256];
        Arrays.fill(hash, -1);

        int left = 0, right = 0;
        int maxLen = 0;

        while (right < s.length()) {

            if (hash[s.charAt(right)] != -1) {
                left = Math.max(left, hash[s.charAt(right)] + 1);
            }

            hash[s.charAt(right)] = right;

            maxLen = Math.max(maxLen, right - left + 1);

            right++;
        }

        return maxLen;
    }
}