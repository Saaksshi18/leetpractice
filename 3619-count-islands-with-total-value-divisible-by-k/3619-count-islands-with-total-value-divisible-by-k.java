
class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    long sum = dfs(grid, i, j, m, n);

                    if (sum % k == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private long dfs(int[][] grid, int i, int j, int m, int n) {
        // Base case: out of bounds or water/already visited
        if (i < 0 || i >= m || j < 0 || j >= n
                || grid[i][j] == 0) {
            return 0;
        }

        // Store the cell's value and mark it visited
        long value = grid[i][j];
        grid[i][j] = 0;

        // Explore all four directions
        value += dfs(grid, i - 1, j, m, n); // Up
        value += dfs(grid, i + 1, j, m, n); // Down
        value += dfs(grid, i, j - 1, m, n); // Left
        value += dfs(grid, i, j + 1, m, n); // Right

        return value;
    }
}
