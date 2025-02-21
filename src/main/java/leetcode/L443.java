package leetcode;

public class L443 {
    public int compress(char[] chars) {
        int p = 0, q = 0, n = chars.length;
        char[] result = new char[n];

        while (q < n) {
            char cur = chars[q];
            int cnt = 0;
            while (q < n && cur == chars[q]) {
                cnt++;
                q++;
            }
            result[p++] = cur;
            if (cnt > 1) {
                char[] t = String.valueOf(cnt).toCharArray();
                for (char tc : t) {
                    result[p++] = tc;
                }
            }
        }
        return p;
    }
}
