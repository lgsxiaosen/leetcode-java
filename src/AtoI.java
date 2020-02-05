/**
 * @author sen
 * @date 2020/2/5 09:17
 * 8. 字符串转换整数 (atoi)
 */
public class AtoI {


    public static int myAtoi(String str) {
        if (str==null){
            return 0;
        }
        String s = str.trim();
        int length = s.length();
        if (length<1){
            return 0;
        }
        int flag = 1;
        int i = 0;
        char[] c = s.toCharArray();
        if (c[0]=='-'||c[0]=='+'){
            i = 1;
            if (c[0]=='-'){
                flag = -1;
            }
        }
        int res = 0;
        int pop = 0;
        for (; i<length; i++){
            if (c[i]<'0'||c[i]>'9'){
                return res;
            }
            pop = (c[i]-48) * flag;
            if(res>Integer.MAX_VALUE/10||(res==Integer.MAX_VALUE/10&&pop>7)){
                return Integer.MAX_VALUE;
            }
            if (res<Integer.MIN_VALUE/10||(res==Integer.MIN_VALUE/10&&pop<-8)){
                return Integer.MIN_VALUE;
            }
            res = res*10+pop;
        }
        return res;
    }
}
