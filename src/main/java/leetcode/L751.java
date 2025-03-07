package leetcode;

import java.util.ArrayList;
import java.util.List;

public class L751 {
    public List<String> ipToCIDR(String ip, int n) {
        long start = ipToLong(ip);
        List<String> ans = new ArrayList<>();

        while (n > 0) {
            int mask = Math.max(33 - bitLength(start & -start), 33 - bitLength(n));
            if (start == 0) {
                mask = 33 - bitLength(n);
            }
            ans.add(longToIp(start, mask));
            start += (1 << (32 - mask));
            n -= (1 << (32 - mask));
        }
        return ans;
    }

    private long ipToLong(String ip) {
        long ans = 0;
        for (String xxx : ip.split("\\.")) {
            ans = ans * 256 + Integer.valueOf(xxx);
        }
        return ans;
    }

    private String longToIp(long x, int mask) {
        return String.format("%s.%s.%s.%s/%s", x >> 24, (x >> 16) % 256, (x >> 8) % 256, x % 256, mask);
    }

    private int bitLength(long x) {
        if (x == 0) {
            return 1;
        }
        int ans = 0;
        while (x > 0) {
            x >>= 1;
            ans++;
        }
        return ans;
    }
}


