class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] suf = new int[m + 1];

        Arrays.fill(suf, -1);

        suf[m] = n;

        int i = n - 1;
        int j = m - 1;

        while (i >= 0 && j >= 0) {
            if (word1.charAt(i) == word2.charAt(j)) {
                suf[j] = i;
                j--;
            }
            i--;
        }

        int[] ans = new int[m];
        int pos = 0;
        boolean usedMismatch = false;

        for (int k = 0; k < m; k++) {
            while (pos < n) {

                if (word1.charAt(pos) == word2.charAt(k)) {
                    ans[k] = pos++;
                    break;
                }

                if (!usedMismatch) {
                    boolean canUseMismatch =
                        k == m - 1 ||
                        (suf[k + 1] != -1 && suf[k + 1] > pos);

                    if (canUseMismatch) {
                        usedMismatch = true;
                        ans[k] = pos++;
                        break;
                    }
                }

                pos++;
            }

            if (pos > n || ans[k] == 0 && k > 0 && ans[k] <= ans[k - 1]) {
                return new int[0];
            }
        }

        return ans;
    }
}
