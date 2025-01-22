package leetcode;

public class L67 {

    public String addBinary(String a, String b) {
        StringBuilder buffer = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = carry;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            buffer.append(sum % 2);
            carry = sum / 2;
        }
        if (carry == 1) buffer.append(carry);
        return buffer.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1010", b = "1011";
        L67 algo = new L67();
        String r = algo.addBinary(a, b);
        System.out.println(r);
    }
}
