package _16_search;

/**
 * 二分查找变形问题
 * 1. 查找第一个值等于给定值的元素
 * 2. 查找最后一个值等于给定值的元素
 * 3. 查找第一个大于等于给定值的元素
 * 4. 查找最后一个小于等于给定值的元素
 */
public class SearchTest {
    public static void main(String[] args) {
        SearchTest searchTest = new SearchTest();
        int[] arr = {1, 3, 3, 4, 4, 4, 4, 4, 5, 5, 6, 7, 8};
        System.out.println(searchTest.binarySearch4(arr, 3));
        int[] arr2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(searchTest.search2(arr2, 3));
    }

    /**
     * 4.1 查找第一个值等于给定值的元素
     * 代码简洁，但逻辑比较复杂
     *
     * @param arr
     * @param value
     * @return
     */
    public int binarySearch11(int[] arr, int value) {
        if (arr == null || arr.length == 0) return -1;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int middle = (low + high) >> 1;
            int midValue = arr[middle];
            if (midValue >= value) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        if (low < arr.length && arr[low] == value) {
            return low;
        } else {
            return -1;
        }
    }

    /**
     * 4.2 查找第一个值等于给定值的元素
     * 逻辑简单清晰
     *
     * @param a
     * @param value
     * @return
     */
    public int binarySearch12(int[] a, int value) {
        if (a == null || a.length == 0) return -1;
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == 0) || (a[mid - 1] != value)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 5. 查找最后一个值等于给定值的元素
     *
     * @param arr
     * @param value
     * @return
     */
    public int binarySearch2(int[] arr, int value) {
        if (arr == null || arr.length == 0) return -1;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int middle = (low + high) >> 1;
            int midValue = arr[middle];
            if (midValue < value) {
                low = middle + 1;
            } else if (midValue > value) {
                high = middle - 1;
            } else {
                if (middle == arr.length - 1 || arr[middle + 1] != value) {
                    return middle;
                } else {
                    low = middle + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 6. 查找第一个大于等于给定值的元素
     *
     * @param arr
     * @param value
     * @return
     */
    public int binarySearch3(int[] arr, int value) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int middle = (low + high) >> 1;
            if (arr[middle] >= value) {
                if (middle == 0 || arr[middle - 1] < value) {
                    return middle;
                } else {
                    high = middle - 1;
                }
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

    /**
     * 7. 查找最后一个小于等于给定值的元素
     *
     * @param arr
     * @param value
     * @return
     */
    public int binarySearch4(int[] arr, int value) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int middle = (low + high) >> 1;
            if (arr[middle] <= value) {
                if (middle == n - 1 || arr[middle + 1] > value) {
                    return middle;
                } else {
                    low = middle + 1;
                }
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }

    /**
     * 8. 二分查找
     * <p>
     * LeetCode 704
     *
     * @param nums
     * @param target
     * @return
     */
    public int search1(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int middle = (low + high) >> 1;
            int midValue = nums[middle];
            if (midValue < target) {
                low = middle + 1;
            } else if (midValue > target) {
                high = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    /**
     * 9. 搜索旋转排序数组
     * <p>
     * LeetCode 33
     * <p>
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     * 你可以假设数组中不存在重复的元素。
     * 你的算法时间复杂度必须是 O(log n) 级别。
     * <p>
     * 示例 1:
     * 输入: nums = [4,5,6,7,0,1,2], target = 0
     * 输出: 4
     * <p>
     * 示例 2:
     * 输入: nums = [4,5,6,7,0,1,2], target = 3
     * 输出: -1
     * <p>
     * 题目分析：
     * 以中间索引为基点，将数组分割成两个数组 num1 和 num2 。
     * 如果 middle 索引元素大于 num1 的第一个元素，则 num1 为有序数组， num2 为旋转数组，反过来则 num1 为旋转数组，num2 为有序数组；
     * 判断目标值target是否在 num1 数组中，是则进行二分查找，否则继续分割 num2 旋转数组，以此类推
     *
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        return realSearch(nums, low, high, target);
    }

    private int realSearch(int[] nums, int low, int high, int target) {
        if (low > high) return -1;
        int middle = (low + high) >> 1;
        if (nums[middle] >= nums[low]) {
            // low - middle 是有序数组
            if (nums[low] <= target && nums[middle] >= target) {
                return binarySearch(nums, low, middle, target);
            } else {
                return realSearch(nums, middle + 1, high, target);
            }
        } else {
            // middle ~ high 是有序数组
            if (nums[middle] <= target && nums[high] >= target) {
                return binarySearch(nums, middle, high, target);
            } else {
                return realSearch(nums, low, middle - 1, target);
            }
        }
    }

    private int binarySearch(int[] nums, int low, int high, int target) {
        if (nums == null || nums.length == 0) return -1;
        while (low <= high) {
            int middle = (low + high) >> 1;
            int midValue = nums[middle];
            if (midValue < target) {
                low = middle + 1;
            } else if (midValue > target) {
                high = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}














