class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }
        
        Integer[][] memo = new Integer[n][n];
        return solve(0, n - 1, prefix, memo);
    }
    
    private int solve(int i, int j, int[] prefix, Integer[][] memo) {
        if (i == j) return 0;
        if (memo[i][j] != null) return memo[i][j];
        
        int best = 0;
        for (int k = i; k < j; k++) {
            int left = prefix[k + 1] - prefix[i];
            int right = prefix[j + 1] - prefix[k + 1];
            
            if (left < right) {
                best = Math.max(best, left + solve(i, k, prefix, memo));
            } else if (left > right) {
                best = Math.max(best, right + solve(k + 1, j, prefix, memo));
            } else {
                best = Math.max(best, left + solve(i, k, prefix, memo));
                best = Math.max(best, right + solve(k + 1, j, prefix, memo));
            }
        }
        
        memo[i][j] = best;
        return best;
    }
}