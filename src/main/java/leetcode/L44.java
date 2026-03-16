package leetcode;

public class L44 {

    public boolean isMatch(String s, String p) {
        int sIdx = 0, pIdx = 0;
        int starIdx = -1, sTmpIdx = -1;

        while (sIdx < s.length()) {
            // 1. 字符匹配成功或遇到 '?'
            if (pIdx < p.length() && (p.charAt(pIdx) == '?' || p.charAt(pIdx) == s.charAt(sIdx))) {
                sIdx++;
                pIdx++;
            } 
            // 2. 遇到 '*'，记录位置，先尝试匹配 0 个字符
            else if (pIdx < p.length() && p.charAt(pIdx) == '*') {
                starIdx = pIdx;
                sTmpIdx = sIdx;
                pIdx++;
            } 
            // 3. 匹配失败，但之前有 '*'，进行回溯
            else if (starIdx != -1) {
                pIdx = starIdx + 1; // 模式回到 '*' 的下一个
                sTmpIdx++;          // '*' 多吞掉一个 s 中的字符
                sIdx = sTmpIdx;     // s 重新从新位置开始匹配
            } 
            // 4. 彻底匹配失败
            else {
                return false;
            }
        }

        // 检查 p 中剩余字符是否全为 '*'
        while (pIdx < p.length() && p.charAt(pIdx) == '*') {
            pIdx++;
        }

        return pIdx == p.length();
    }

    //generate test case
    public static void main(String[] args) {
        L44 solution = new L44();
        String s = "adceb";
        String p = "*a*b";
        boolean result = solution.isMatch(s, p);
        System.out.println("Does the string match the pattern? " + result);
    }
}
