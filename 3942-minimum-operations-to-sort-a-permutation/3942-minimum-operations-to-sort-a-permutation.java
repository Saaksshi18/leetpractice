class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int k = nums[0];
        int best = Integer.MAX_VALUE;

        // Case A: increasing rotation
        boolean inc = true;
        for (int i = 0; i < n; i++) {
            if (nums[i] != (i + k) % n) { inc = false; break; }
        }
        if (inc) {
            best = (k == 0) ? 0 : Math.min(n - k, k + 2);
        }

        // Case B: decreasing rotation
        boolean dec = true;
        for (int i = 0; i < n; i++) {
            if (nums[i] != ((k - i) % n + n) % n) { dec = false; break; }
        }
        if (dec) {
            int kp = (k + 1) % n;
            best = Math.min(best, 1 + Math.min((n - kp) % n, kp));
        }

        return best == Integer.MAX_VALUE ? -1 : best;
    }
}