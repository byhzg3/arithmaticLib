package 不同的子序列;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s，计算 s 的 不同非空子序列 的个数。因为结果可能很大，所以返回答案需要对 10^9 + 7 取余 。
 *
 * 字符串的 子序列 是经由原字符串删除一些（也可能不删除）字符但不改变剩余字符相对位置的一个新字符串。
 *
 * 例如，"ace" 是 "abcde" 的一个子序列，但 "aec" 不是。
 *
 */
public class h940 {
    public static int distinctSubseqII(String s) {
        Map<Character,Integer>  map =  new HashMap<>();
        int count = 0,mod = 1000000007;
        for (int i =0 ;i < s.length();i++){
            Character ch = s.charAt(i);
            boolean firstTime = map.get(ch)==null;
            Integer last = map.get(ch);
            map.put(ch,count);
            if (!firstTime){
                count = mod+(count+count)%mod-last;
            }else{
                count=(count+count+1);
            }
            count = count%mod;
        }
        return count;
    }
}
