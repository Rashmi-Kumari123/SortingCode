public class LongestCommonSubsequence {
    public int lcsDynamic(String str1,String str2){
    
        int temp[][] = new int[str1.length() + 1][str2.length() + 1];
        int max = 0;
        for(int i=1; i < temp.length; i++){
            for(int j=1; j < temp[i].length; j++){
                if(str1.charAt(i-1)== str2.charAt(j-1)) {
                    temp[i][j] = temp[i - 1][j - 1] + 1;
                }
                else{
                    temp[i][j] = Math.max(temp[i][j-1],temp[i-1][j]);
                }
                if(temp[i][j] > max){
                    max = temp[i][j];
                }
            }
        }
        return max;
    }
    public static void main(String args[]){
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String str1 = "abcdef";
        String str2 = "acbcf";
        
        int length = lcs.lcsDynamic(str1, str2);
        System.out.print("length of common subsequence found between strings : " + length);
        System.out.println();
    }

    
}
