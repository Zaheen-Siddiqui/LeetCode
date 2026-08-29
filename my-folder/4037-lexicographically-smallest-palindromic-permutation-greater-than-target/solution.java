class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();

        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int odd = 0;
        int oddChar = -1;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                odd++;
                oddChar = i;
            }
        }

        if (odd > 1) {
            return "";
        }

        int halfLen = n / 2;

        int[] half = new int[26];

        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
        }

        String best = null;

        int[] remaining = half.clone();

        boolean possible = true;

        for (int i = 0; i < halfLen; i++) {
            int c = target.charAt(i) - 'a';

            if (remaining[c] == 0) {
                possible = false;
                break;
            }

            remaining[c]--;
        }

        if (possible) {
            String left = target.substring(0, halfLen);

            String palindrome = buildPalindrome(left, oddChar);

            if (palindrome.compareTo(target) > 0) {
                best = palindrome;
            }
        }


        for (int pos = halfLen - 1; pos >= 0; pos--) {
            remaining = half.clone();

            boolean ok = true;

            for (int i = 0; i < pos; i++) {
                int c = target.charAt(i) - 'a';

                if (remaining[c] == 0) {
                    ok = false;
                    break;
                }

                remaining[c]--;
            }

            if (!ok) {
                continue;
            }

            int targetChar = target.charAt(pos) - 'a';
            int chosen = -1;

            for (int c = targetChar + 1; c < 26; c++) {
                if (remaining[c] > 0) {
                    chosen = c;
                    break;
                }
            }

            if (chosen == -1) {
                continue;
            }

            remaining[chosen]--;

            StringBuilder left = new StringBuilder();

            for (int i = 0; i < pos; i++) {
                left.append(target.charAt(i));
            }

            left.append((char) ('a' + chosen));

            for (int c = 0; c < 26; c++) {
                while (remaining[c] > 0) {
                    left.append((char) ('a' + c));
                    remaining[c]--;
                }
            }

            String palindrome = buildPalindrome(left.toString(), oddChar);

            if (palindrome.compareTo(target) > 0) {
                if (best == null || palindrome.compareTo(best) < 0) {
                    best = palindrome;
                }
            }
        }

        return best == null ? "" : best;
    }

    private String buildPalindrome(String left, int oddChar) {
        StringBuilder result = new StringBuilder();

        result.append(left);

        if (oddChar != -1) {
            result.append((char) ('a' + oddChar));
        }

        for (int i = left.length() - 1; i >= 0; i--) {
            result.append(left.charAt(i));
        }

        return result.toString();
    }
}
