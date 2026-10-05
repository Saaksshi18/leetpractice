class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];

        // Create StringBuilder for every row
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int row = 0;
        boolean goingDown = true;

        for (int i = 0; i < s.length(); i++) {

            // Put current character in current row
            rows[row].append(s.charAt(i));

            // Change direction at top or bottom
            if (row == numRows - 1) {
                goingDown = false;
            } 
            else if (row == 0) {
                goingDown = true;
            }

            // Move to next row
            if (goingDown) {
                row++;
            } else {
                row--;
            }
        }

        // Combine all rows
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            answer.append(rows[i]);
        }

        return answer.toString();
    }
}