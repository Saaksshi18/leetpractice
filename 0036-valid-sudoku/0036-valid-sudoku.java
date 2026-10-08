class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch == '.') continue;

                if (!seen.add(ch + " in row " + r)
                 || !seen.add(ch + " in col " + c)
                 || !seen.add(ch + " in box " + (r / 3) + "-" + (c / 3))) {
                    return false;
                }
            }
        }
        return true;
    }
}