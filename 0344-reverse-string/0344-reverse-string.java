class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        String r = "";

        for (int i = n - 1; i >= 0; i--) {
            r = r + s[i];
        }

        for (int i = 0; i < n; i++) {
            s[i] = r.charAt(i);
        }
    }
}