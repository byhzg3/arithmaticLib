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
    public static void main(String[] args) {
        System.out.println();
    }
    public int distinctSubseqII(String s) {
        Map<Character,Integer>  map =  new HashMap<>();
        int count = 0,mod = 1000000007,tmp;
        for (int i =0 ;i < s.length();i++){
            tmp = count+1;
            if (map.containsKey(s.charAt(i))){
                tmp = tmp - map.get(s.charAt(i));
                if (tmp<=0){
                    tmp+=mod;
                }
            }
            count= tmp+count;
            count= count % mod;
            map.put(s.charAt(i),(map.getOrDefault(s.charAt(i),0)+tmp)%mod);
        }
        return count;
    }
}
