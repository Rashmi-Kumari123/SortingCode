public class WildCardMatching {
    public boolean isMatch(String s, String p) {
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();
        
        // Preprocessing pattern: like replace multiple * with one * or remove consecutive '*'
        //e.g a**b***c --> a*b*c 
        int writeIndex = 0;
        boolean isFirst = true;
        for (int i = 0; i < pattern.length; i++) {
            if (pattern[i] == '*') {
                if (isFirst) {
                    pattern[writeIndex++] = pattern[i];
                    isFirst = false;
                }
            }
            else {
                pattern[writeIndex++] = pattern[i];
                isFirst = true;
            }
        }
        boolean T[][] = new boolean[str.length + 1][writeIndex + 1];
        T[0][0] = true; // Base case: empty string matches empty pattern
        if (writeIndex > 0 && pattern[0] == '*') { // Base case: pattern starting with '*' can match empty string
            T[0][1] = true;
        }
        
        for (int i = 1; i <= str.length; i++) {
            for (int j = 1; j <= writeIndex; j++) {
                if (pattern[j-1] == '?' || str[i-1] == pattern[j-1]) {
                    T[i][j] = T[i-1][j-1];
                } else if (pattern[j-1] == '*') {
                    T[i][j] = T[i-1][j] || T[i][j-1]; // Matching 0 or more chars
                }
            }
        }
        return T[str.length][writeIndex];
    }
    public static void main(String args[]) {
        WildCardMatching wcm = new WildCardMatching();
        System.out.println(wcm.isMatch("aa", "*"));
        System.out.println(wcm.isMatch("xbylmz", "x?y*z"));
        System.out.println(wcm.isMatch("cb", "?a"));
    }
}