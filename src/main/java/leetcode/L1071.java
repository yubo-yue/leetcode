package leetcode;

public class L1071 {
    public String gcdOfStrings(String str1, String str2) {
        if (!str1.concat(str2).equals(str2.concat(str1))) {
            return "";
        }

        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private int gcd(int a, int b) {
        int reminder = a % b;
        while (reminder > 0) {
            a = b;
            b = reminder;
            reminder = a % b;
        }
        return b;
    }
}
