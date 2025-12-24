// problem is to determine if a text string matches a pattern where '.' matches any single character and '*' matches zero or more of the preceding element.
public class RegexMatching {
    public boolean matchRegex(char[] text, char[] pattern) {
        boolean T[][] = new boolean[text.length + 1][pattern.length + 1];

        T[0][0] = true; //base case: Empty string matches empty pattern
        //Dealing with patterns like a* or a*b* or a*b*c*
        for (int i = 1; i < T[0].length; i++) {
            if (pattern[i-1] == '*') {
                T[0][i] = T[0][i - 2];
            }
        }

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                if (pattern[j - 1] == '.' || pattern[j - 1] == text[i - 1]) {
                    T[i][j] = T[i-1][j-1];
                } else if (pattern[j - 1] == '*')  {
                    T[i][j] = T[i][j - 2]; //considering matching zero occurrences
                    if (pattern[j-2] == '.' || pattern[j - 2] == text[i - 1]) { //checking if the preceding character matches, then also considering matching one or more occurrences
                        T[i][j] = T[i][j] | T[i - 1][j];
                    }
                } else {
                    T[i][j] = false;
                }
            }
        }
        return T[text.length][pattern.length];
    }

    public static void main(String args[]){
        RegexMatching rm = new RegexMatching();
        System.out.println(rm.matchRegex("Tusha".toCharArray(),"Tushar*a*b*".toCharArray()));
        System.out.println(rm.matchRegex("".toCharArray(),"a*b*".toCharArray()));
        System.out.println(rm.matchRegex("abbbbccc".toCharArray(),"a*ab*bbbbc*".toCharArray()));
        System.out.println(rm.matchRegex("abbbbccc".toCharArray(),"aa*bbb*bbbc*".toCharArray()));
        System.out.println(rm.matchRegex("abbbbccc".toCharArray(),".*bcc".toCharArray()));
        System.out.println(rm.matchRegex("abbbbccc".toCharArray(),".*bcc*".toCharArray()));
        System.out.println(rm.matchRegex("abbbbccc".toCharArray(),".*bcc*".toCharArray()));
        System.out.println(rm.matchRegex("aaa".toCharArray(),"ab*a*c*a".toCharArray()));
        System.out.println(rm.matchRegex("aa".toCharArray(), "a*".toCharArray()));
    }
}
