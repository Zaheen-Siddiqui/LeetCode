class Solution {
    public boolean isPalindrome(int x) {
        int rev = 0, temp = x;
        while (x>0){
            // rem = x % 10;
            rev = 10*rev + x % 10;
            x = x/10;
        }
        if (temp == rev)
            return true;
        return false;
    }
}
