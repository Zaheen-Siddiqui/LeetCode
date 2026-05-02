class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if(s.length() == 1 && s.charAt(0) != ' ')
            return 1;
        int j = 0;
        for( int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' ')
                j = i;
        }
        if(s.charAt(j) == ' ')
            return s.substring(j).length()-1;
        return s.substring(j).length();
    }
}
