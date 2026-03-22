package leetcode;

public class L273 {

    private static final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        StringBuilder ans = new StringBuilder();
        for (int i = THOUSANDS.length-1; i >= 0; i--) {
            int x = num / (int) Math.pow(1000, i) % 1000;
            if (x == 0) {
                continue;
            }

            if (x>=100) {
                add(ans, LESS_THAN_20[x/100] + " Hundred");
            }
            if (x%100 < 20) {
                add(ans, LESS_THAN_20[x%100]);
            } else {
                add(ans, TENS[x/10%10]);
                add(ans, LESS_THAN_20[x%10]);
            }
            add(ans, THOUSANDS[i]);
        }
        return ans.toString();
    }
    void add(StringBuilder ans, String s) {
        if (s.isEmpty()) {
            return;
        }
        if (ans.length() > 0) {
            ans.append(" ");
        }
        ans.append(s);
    }

    // generate test case
    public static void main(String[] args) {
        L273 solution = new L273();
        int num = 1_223_345_345;
        String result = solution.numberToWords(num);
        System.out.printf("Number %d in words: %s%n", num, result);
    }
}
