package leetcode;

public class L4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int total = len2 + len1;
        if (total %2 == 1) {
            int mid = total / 2;
            return getKthElement(nums1, nums2, mid+1);
        }
        int mid1 = total / 2 - 1;
        int mid2 = total / 2;
        return (getKthElement(nums1, nums2, mid1+1) + getKthElement(nums1, nums2, mid2+1)) / 2.0;
    }

    private double getKthElement(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int index1 = 0, index2 = 0;
        while (true) {
            if (index1 == len1) {
                return nums2[index2 + k - 1];
            }

            if (index2 == len2) {
                return nums1[index1 + k - 1];
            }

            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            int half = k / 2;
            int newIndex1 = Math.min(len1, index1+half) - 1;
            int newIndex2 = Math.min(len2, index2+half) - 1;

            if (nums1[newIndex1] < nums2[newIndex2]) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1+1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2+1;
            }
        }
    }

    public static void main(String[] args) {
        L4 algo = new L4();
        double median = algo.findMedianSortedArrays(new int[] {1,3}, new int[]{2,4});
        System.out.println(median);
    }
}
