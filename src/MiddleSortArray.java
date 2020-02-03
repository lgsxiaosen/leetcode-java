/**
 * @author xiaosen
 * @date 2020/2/3 11:18
 * 4.寻找两个有序数组的中位数
 */
public class MiddleSortArray {
    public static void main(String[] args){
        int[] a = {4, 5}, b = {1,2,3};
        System.out.println(findMedianSortedArrays(a, b));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if (n > m){
            return findMedianSortedArrays(nums2, nums1);
        }
        int iMin = 0, iMax = n;
        int middle = (n + m + 1)/2;
        while (iMin<=iMax){
            int i = (iMax + iMin)/2;
            int j = middle - i;
            // i需要增大
            if (j!=0&&i!=n&&nums2[j-1]>nums1[i]){
                iMin = i + 1;
            }else if (i!=0&&j!=m&&nums1[i-1]>nums2[j]){
                // i减小
                iMax = i - 1;
            }else {
                int maxLeft = 0;
                if (i==0){
                    maxLeft = nums2[j-1];
                }else if (j==0){
                    maxLeft = nums1[i-1];
                }else {
                    maxLeft = Math.max(nums1[i-1], nums2[j-1]);
                }
                // 奇数直接返回
                if ((m+n)%2==1){
                    return maxLeft;
                }
                int minRight = 0;
                if (i==n){
                    minRight = nums2[j];
                }else if (j==m){
                    minRight = nums1[i];
                }else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }




}
