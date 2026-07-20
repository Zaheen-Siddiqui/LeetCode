class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int i =0;
        String strs1 = strs[0];
        String strs2 = strs[strs.length-1];
        while(i<strs1.length()){
            if(strs1.charAt(i)==strs2.charAt(i)){
                i++;
            }
            else{
                break;
            }
        }
       if(i==0){
        return "";
       }
       else{
        return strs1.substring(0,i);
       }
    }
}
