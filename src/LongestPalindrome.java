/**
 * @author xiaosen
 * @date 2020/2/3 21:04
 * @description
 */
public class LongestPalindrome {

    public static void main(String[] args){
        System.out.println(longestPalindrome("baba"));
    }

    public static String longestPalindrome(String s){
        if (s==null){
            return s;
        }
        int length = s.length();
        if (length<2){
            return s;
        }
        boolean[][] dp = new boolean[length][length];
        int maxLength = 1;
        int start = 0;
        for (int j=1; j<length; j++){
            for (int i=0; i<j; i++){
                if (s.charAt(i)==s.charAt(j)){
                    if (j - i < 3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }else {
                    dp[i][j] = false;
                }

                if (dp[i][j]){
                    int curLen = j - i + 1;
                    if (curLen>maxLength){
                        maxLength = curLen;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLength);
    }
}
