class Solution {
    public String reverseWords(String s) {
        String[] parts = s.trim().split("\\s+");
        int n = parts.length;
        s = parts[n-1];
        for (int i = n - 2; i >= 0; i--){
            s = s + " " + parts[i]; 
        }  
        return s;
    }
}
