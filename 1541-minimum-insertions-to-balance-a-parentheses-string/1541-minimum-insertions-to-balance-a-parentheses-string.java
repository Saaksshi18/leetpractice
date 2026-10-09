
class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int open = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                open++;
            } else {
                // If this ')' is not followed by another ')',
                // insert a ')' to complete the pair.
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    insertions++;
                }

                // The pair '))' needs one matching '('.
                if (open > 0) {
                    open--;
                } else {
                    // Insert a '(' to match this '))'.
                    insertions++;
                }
            }
        }

        // Every remaining '(' needs two ')'.
        insertions += open * 2;

        return insertions;
    }
}
