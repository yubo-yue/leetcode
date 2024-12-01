package leetcode;

public class L605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int[] a = new int[flowerbed.length + 2];
        System.arraycopy(flowerbed, 0, a, 1, flowerbed.length);

        for (int i = 1; i < a.length - 1; i++) {
            if (a[i - 1] == 0 && a[i] == 0 && a[i + 1] == 0) {
                a[i] = 1;
                n--;
            }
        }
        return n <= 0;
    }
}
