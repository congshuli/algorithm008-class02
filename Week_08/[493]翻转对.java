//给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。 
//
// 你需要返回给定数组中的重要翻转对的数量。 
//
// 示例 1: 
//
// 
//输入: [1,3,2,3,1]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: [2,4,3,5,1]
//输出: 3
// 
//
// 注意: 
//
// 
// 给定数组的长度不会超过50000。 
// 输入数组中的所有数字都在32位整数的表示范围内。 
// 
// Related Topics 排序 树状数组 线段树 二分查找 分治算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reversePairs(int[] nums) {
        if(nums.length==0) return 0;
        return mergeAndCount(nums,0,nums.length-1);
    }

    public int mergeAndCount(int[] nums, int l, int r) {
        if (l >= r) {
            return 0;
        } else {
            int mid = l + r >>> 1;
            int allCount = mergeAndCount(nums, l, mid) + mergeAndCount(nums, mid + 1, r);
            int l1 = l;
            int l2 = mid + 1;
            for (int i = l1; i < mid + 1; i++) {
                while (l2 <= r && (long)nums[i] > (long)nums[l2] * 2) {
                    l2++;
                }
                allCount += l2 - (mid + 1);
            }
            doMerge(nums, l, mid, r);
            return allCount;
        }
    }

    public void doMerge(int[] nums, int l, int mid, int r) {
        int i1 = l, i2 = mid + 1;
        int[] arr = new int[r - l + 1];
        int i = 0;
        while (i1 <= mid && i2 <= r) {
            if (nums[i1] < nums[i2]) {
                arr[i++] = nums[i1++];
            } else {
                arr[i++] = nums[i2++];
            }
        }
        while (i1 <= mid) {
            arr[i++] = nums[i1++];
        }
        while (i2 <= r) {
            arr[i++] = nums[i2++];
        }

        for (int j = l; j <= r; j++) {
            nums[j] = arr[j - l];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
