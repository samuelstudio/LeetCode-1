package leetcode.backtrack.leet_zh_10;

public class Solution {
    /*
     * Title: 10. 正则表达式匹配
     * Link : https://leetcode-cn.com/problems/regular-expression-matching/
     * Label: ["字符串", "动态规划", "回溯算法"]
     * Level: Hard
     * Desc :
     *给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。

        '.' 匹配任意单个字符
        '*' 匹配零个或多个前面的那一个元素
        所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。

        说明:

        s 可能为空，且只包含从 a-z 的小写字母。
        p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
        示例 1:

        输入:
        s = "aa"
        p = "a"
        输出: false
        解释: "a" 无法匹配 "aa" 整个字符串。
        示例 2:

        输入:
        s = "aa"
        p = "a*"
        输出: true
        解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
        示例 3:

        输入:
        s = "ab"
        p = ".*"
        输出: true
        解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
        示例 4:

        输入:
        s = "aab"
        p = "c*a*b"
        输出: true
        解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
        示例 5:

        输入:
        s = "mississippi"
        p = "mis*is*p*."
        输出: false
     * 执行用时 : 32   ms
     * 内存消耗 : 38.3 MB
     * */

    public boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0);
    }

    private boolean isMatch(String s, int i, String p, int j) {
        if (j == p.length())
            return i == s.length();
        if (j == p.length() - 1 || p.charAt(j + 1) != '*') {
            return (i != s.length() && (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i))) && isMatch(s, i + 1, p, j + 1);
        }
        do {
            if (isMatch(s, i, p, j + 2)) {
                return true;
            }
            i++;
        } while (i <= s.length() && (s.charAt(i - 1) == p.charAt(j) || p.charAt(j) == '.'));
        return false;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        String[][] testCase = {
//                {"aa", "a"},
                {"aa", "a*"},
//                {"ab", ".*"},
                {"aab", "c*a*b"},
//                {"mississippi", "mis*is*p*."},
        };
        for (int i = 0; i < testCase.length; i++) {
            System.out.println(ss.isMatch(testCase[i][0], testCase[i][1]));
        }
    }
}