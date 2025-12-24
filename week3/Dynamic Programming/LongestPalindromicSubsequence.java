//problem  is : Find the length of the longest palindromic subsequence in a string. and we know a subsequence preserves order but not necessarily continuity
public class LongestPalindromicSubsequence {
    public int calculate(char[] str){
        int T[][] = new int[str.length][str.length];
        for(int i=0; i < str.length; i++){ //this is base case i.e. single character is always a palindrome.
            T[i][i] = 1;
        }
        for(int l = 2; l <= str.length; l++){
            for(int i = 0; i < str.length-l + 1; i++){
                int j = i + l - 1;
                if(l == 2 && str[i] == str[j]){
                    T[i][j] = 2;
                }else if(str[i] == str[j]){ // Characters match
                    T[i][j] = T[i + 1][j-1] + 2;
                }else{                     //Characters don't match
                    T[i][j] = Math.max(T[i + 1][j], T[i][j - 1]);
                }
            }
        }
        return T[0][str.length-1];
    }
    public static void main(String args[]){
        LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
        String str = "agbdba";
        String str1 = "bbbab";
        String str2 = "cbbd";

        int r1 = lps.calculate(str.toCharArray());
        int r2 = lps.calculate(str1.toCharArray());
        int r3 = lps.calculate(str2.toCharArray());
        System.out.print(r1 + " " + r2 + " " + r3);
    }
}
