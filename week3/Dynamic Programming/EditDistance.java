// package week3.DP;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; //operations handling when word2 is empty and maapping with word1
        }
        
        for (int i = 0; i <= m; i++) { // loop handling edit operation if having empty string in word1 and checking with word2
            dp[i][0] = i; //rows keep changing i.e operations and colums fixed
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];// Characters match, no operation needed,value will same as diagonal one
                } else {
                    // Taking minimum of three operations:
                    // 1. Replace: dp[i-1][j-1] + 1 // daigonal se aayegi value
                    // 2. Delete: dp[i-1][j] + 1  // top se aayegi value
                    // 3. Insert: dp[i][j-1] + 1 // left se aayegi value
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[m][n]; // storing minimum operations to transform the entire word1 into word2.
    }
    public static void main(String[] args) {
        EditDistance solution = new EditDistance();
        String word1 = "horse";
        String word2 = "ros";
        int result1 = solution.minDistance(word1, word2);
        System.out.println("  Minimum Edit Distance: " + result1);

        String word3 = "intention";
        String word4 = "execution";
        int result2 = solution.minDistance(word3, word4);
        System.out.println("  Minimum Edit Distance: " + result2);
    } 
}

