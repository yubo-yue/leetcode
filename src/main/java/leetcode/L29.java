package leetcode;

public class L29 {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        long result = 0;
        while (a >= b) {
            long temp = b, multiple = 1;
            while (a >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            a -= temp;
            result += multiple;
        }
        return (dividend > 0) == (divisor > 0) ? (int) result : -(int) result;
    }

    public static void main(String[] args) {
        L29 solution = new L29();
        int dividend = 10, divisor = 3;
        int result = solution.divide(dividend, divisor);
        System.out.println("Quotient: " + result);
    }
}
