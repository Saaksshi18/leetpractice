class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int MOD = 1_000_000_007;

        long[][] dp = new long[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) continue;
                if (i == m - 1 && j == n - 1) continue;

                // Try moving right (dir = 0), then down (dir = 1)
                for (int dir = 0; dir < 2; dir++) {
                    int r = i, c = j;
                    int d = dir;
                    // take the initial step
                    if (d == 0) c++; else r++;

                    while (r < m && c < n && grid[r][c] == 1) {
                        if (d == 0) {      // entered moving right -> turn down
                            r++;
                            d = 1;
                        } else {           // entered moving down -> turn right
                            c++;
                            d = 0;
                        }
                    }

                    if (r < m && c < n) {
                        dp[r][c] = (dp[r][c] + dp[i][j]) % MOD;
                    }
                }
            }
        }

        return (int) dp[m - 1][n - 1];
    }
}