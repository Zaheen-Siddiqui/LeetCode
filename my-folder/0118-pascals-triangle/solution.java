class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> previousRow = null;
        int n;
        for (int i = 0; i< numRows; i++){
            List<Integer> currentRow = new ArrayList<>();
            if (i > 0) {
                previousRow = answer.get(i - 1);
            }
            for( int j = 0; j<=i; j++){
                if(j==0 || j==i)
                    n=1;
                else{
                    n = previousRow.get(j-1) + previousRow.get(j);
                }
                currentRow.add(n);
            }
            answer.add(currentRow);
        }  
        return answer;      
    }
}
