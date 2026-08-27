class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();

        int left = 0;
        int ones = 0;
        int minLen = Integer.MAX_VALUE;
        String answer = "";

        for (int right = 0; right < n; right++) {
            if (s.charAt(right) == '1') {
                ones++;
            }

            // We have more than k ones, so move left
            while (ones > k) {
                if (s.charAt(left) == '1') {
                    ones--;
                }
                left++;
            }

            // Exactly k ones
            if (ones == k) {
                // Remove unnecessary leading zeros.
                while (left < right && s.charAt(left) == '0') {
                    left++;
                }

                int len = right - left + 1;
                String candidate = s.substring(left, right + 1);

                if (len < minLen) {
                    minLen = len;
                    answer = candidate;
                } else if (len == minLen && candidate.compareTo(answer) < 0) {
                    answer = candidate;
                }
            }
        }

        return answer;
    }
}

