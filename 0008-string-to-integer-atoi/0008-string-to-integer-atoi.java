class Solution {

    public int myAtoi(String s) {
        int i = 0;
        int n = s.length();
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        int sign = 1;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }
        return helper(s, i, 0L, sign);
    }

    private int helper(String s, int i, long num, int sign) {

        if (i >= s.length() || !Character.isDigit(s.charAt(i))) {
            return (int)(sign * num);
        }

    
        num = num * 10 + (s.charAt(i) - '0');

     
        if (sign * num <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        if (sign * num >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }


        return helper(s, i + 1, num, sign);
    }
}