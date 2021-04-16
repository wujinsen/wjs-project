package cn.wjs.array;

/**
 *
 * 二分查找法
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9};
        System.out.println(binarySearch(nums, 0));
        System.out.println(searchInsert(nums, 10));
    }

    public static int binarySearch(int[] nums, int target) {

        int n = nums.length;
        if (nums == null || n <= 0) {
            return -1;
        }

        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int middle = low + ((high - low) / 2);// 防止溢出 等同于(left + right)/2
            if (nums[middle] > target) {
                high = middle - 1;
            } else if (nums[middle] < target) {
                low = middle + 1;
            } else {
                return middle;
            }
        }
        return high + 1;
    }

    /**
     * 暴力解法
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

}


