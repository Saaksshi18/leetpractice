class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int leftRem = 0, rightRem = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                leftRem++;
            } else if (ch == ')') {
                if (leftRem > 0) leftRem--;
                else rightRem++;
            }
        }

        Set<String> res = new HashSet<>();
        dfs(s, 0, leftRem, rightRem, 0, 0, new StringBuilder(), res);
        return new ArrayList<>(res);
    }

    private void dfs(String s, int i, int leftRem, int rightRem,
                     int open, int close, StringBuilder path, Set<String> res) {
        if (i == s.length()) {
            if (leftRem == 0 && rightRem == 0) {
                res.add(path.toString());
            }
            return;
        }

        char ch = s.charAt(i);

        // Option 1: remove current paren
        if (ch == '(' && leftRem > 0) {
            dfs(s, i + 1, leftRem - 1, rightRem, open, close, path, res);
        } else if (ch == ')' && rightRem > 0) {
            dfs(s, i + 1, leftRem, rightRem - 1, open, close, path, res);
        }

        // Option 2: keep current char
        path.append(ch);
        if (ch != '(' && ch != ')') {
            dfs(s, i + 1, leftRem, rightRem, open, close, path, res);
        } else if (ch == '(') {
            dfs(s, i + 1, leftRem, rightRem, open + 1, close, path, res);
        } else if (close < open) { // keep ')' only if prefix stays valid
            dfs(s, i + 1, leftRem, rightRem, open, close + 1, path, res);
        }
        path.deleteCharAt(path.length() - 1); // backtrack
    }
}