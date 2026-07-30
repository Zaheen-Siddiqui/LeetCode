class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        
        return x == reverse(x);
    }
    public int reverse(int x) {
        long rev = 0;

        while (x != 0) {
            int rem = x % 10;
            rev = rev * 10 + rem;
            x /= 10;
        }

        if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) rev;
    }
}
