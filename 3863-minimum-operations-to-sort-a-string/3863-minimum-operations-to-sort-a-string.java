class Solution {
    public int minOperations(String s) {
        int n = s.length();

        boolean sorted = true;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < s.charAt(i - 1)) { sorted = false; break; }
        }
        if (sorted) return 0;
        if (n == 2) return -1;

        char min = 'z', max = 'a';
        for (int i = 0; i < n; i++) {
            min = (char) Math.min(min, s.charAt(i));
            max = (char) Math.max(max, s.charAt(i));
        }

        char first = s.charAt(0), last = s.charAt(n - 1);

        if (first == min || last == max) return 1;

        // min exists in s[0..n-2]?  max exists in s[1..n-1]?
        boolean minInPrefix = false, maxInSuffix = false;
        for (int i = 0; i < n - 1; i++) if (s.charAt(i) == min) { minInPrefix = true; break; }
        for (int i = 1; i < n; i++) if (s.charAt(i) == max) { maxInSuffix = true; break; }

        if (!minInPrefix && !maxInSuffix) return 3;
        return 2;
    }
}