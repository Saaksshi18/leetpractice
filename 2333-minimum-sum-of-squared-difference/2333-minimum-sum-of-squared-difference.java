class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2, sum = 0;
        long[] d = new long[n + 1];
        for (int i = 0; i < n; i++) {
            d[i] = Math.abs(nums1[i] - nums2[i]);
            sum += d[i];
        }
        if (sum <= k) return 0;

        Arrays.sort(d, 0, n);              // ascending
        for (int i = 0; i < n / 2; i++) {  // reverse to descending
            long t = d[i]; d[i] = d[n - 1 - i]; d[n - 1 - i] = t;
        }
        d[n] = 0;

        int i = 0;
        while (i < n) {
            long cnt = i + 1;
            long cost = cnt * (d[i] - d[i + 1]);
            if (cost <= k) { k -= cost; i++; }
            else break;
        }

        long cnt = i + 1;
        long level = d[i] - k / cnt;
        long rem = k % cnt;

        long total = (cnt - rem) * level * level + rem * (level - 1) * (level - 1);
        for (int j = i + 1; j < n; j++) total += d[j] * d[j];
        return total;
    }
}