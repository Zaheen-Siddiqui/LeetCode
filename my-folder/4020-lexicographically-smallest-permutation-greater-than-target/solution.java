class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder ans = new StringBuilder();

        // Try to match target from left to right
        for (int i = 0; i < n; i++) {
            int cur = target.charAt(i) - 'a';

            // We can keep this position equal to target
            if (count[cur] > 0) {
                ans.append(target.charAt(i));
                count[cur]--;
                continue;
            }

            // Cannot match target[i].
            // Try the smallest character greater than target[i].
            for (int c = cur + 1; c < 26; c++) {
                if (count[c] > 0) {
                    ans.append((char) ('a' + c));
                    count[c]--;

                    appendRemaining(ans, count);
                    return ans.toString();
                }
            }

            // No larger character at this position.
            // Backtrack to an earlier position.
            while (ans.length() > 0) {
                int last = ans.charAt(ans.length() - 1) - 'a';
                ans.deleteCharAt(ans.length() - 1);
                count[last]++;

                int pos = ans.length();
                int need = target.charAt(pos) - 'a';

                // Try to make this earlier position larger
                for (int c = need + 1; c < 26; c++) {
                    if (count[c] > 0) {
                        ans.append((char) ('a' + c));
                        count[c]--;

                        appendRemaining(ans, count);
                        return ans.toString();
                    }
                }
            }

            return "";
        }

        // We matched target exactly.
        // Need a STRICTLY greater permutation, so backtrack.
        while (ans.length() > 0) {
            int last = ans.charAt(ans.length() - 1) - 'a';
            ans.deleteCharAt(ans.length() - 1);
            count[last]++;

            int pos = ans.length();
            int need = target.charAt(pos) - 'a';

            for (int c = need + 1; c < 26; c++) {
                if (count[c] > 0) {
                    ans.append((char) ('a' + c));
                    count[c]--;

                    appendRemaining(ans, count);
                    return ans.toString();
                }
            }
        }

        return "";
    }

    private void appendRemaining(StringBuilder ans, int[] count) {
        for (int c = 0; c < 26; c++) {
            while (count[c] > 0) {
                ans.append((char) ('a' + c));
                count[c]--;
            }
        }
    }
}

