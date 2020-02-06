/**
 * @author sen
 * 2020/2/6 10:20
 * 10. 正则表达式匹配
 */
public class IsMatch {

    public static void main(String[] args){
        System.out.println(isMatch("aab", "c*a*b*"));
    }

    public static boolean isMatch(String s, String p){
        int ls = s.length(), lp = p.length();
        boolean[][] dp = new boolean[ls + 1][lp + 1];
        dp[0][0] = true;
        // 初始化，即s的前0个字符和p的前i个字符能否匹配
        // 除了p为*，其他都不匹配
        for (int i = 0; i < lp; i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        for (int i=0; i<ls; i++){
            for (int j=0; j<lp; j++){
                if (p.charAt(j)=='*'){
                    //如果前一个元素不匹配 且不为任意元素
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                    }
                }else if (p.charAt(j)==s.charAt(i)||p.charAt(j)=='.'){
                    dp[i+1][j+1] = dp[i][j];
                }
            }
        }
        return dp[ls][lp];
    }
}
