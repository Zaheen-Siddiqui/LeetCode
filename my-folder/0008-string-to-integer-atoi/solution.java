class Solution {
    public int myAtoi(String s) {
        s = s.trim();

        if (s.length() == 0)
            return 0;

        long num = 0;
        int i = 0;
        boolean is_neg = false;

        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            if (s.charAt(i) == '-')
                is_neg = true;
            i++;
        }

        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            num = num * 10 + (s.charAt(i) - '0');

            if (!is_neg && num > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;

            if (is_neg && -num < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;

            i++;
        }

        return is_neg ? (int)-num : (int)num;
    }
}
