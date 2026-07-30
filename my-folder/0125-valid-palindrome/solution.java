class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            char lc = s.charAt(i);
            char rc = s.charAt(j);

            if (!((lc >= 'A' && lc <= 'Z') || (lc >= 'a' && lc <= 'z') || (lc >= '0' && lc <= '9')))
                i++;
            else if (!((rc >= 'A' && rc <= 'Z') || (rc >= 'a' && rc <= 'z') || (rc >= '0' && rc <= '9')))
                j--;
            else {
                if (lc >= 'A' && lc <= 'Z') lc += 32;
                if (rc >= 'A' && rc <= 'Z') rc += 32;
                if (lc != rc) return false;
                i++; j--;
            }
        }

        return true;
    }
}

