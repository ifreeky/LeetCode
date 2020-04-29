package com.ifreeky.leetcode.array.山脉数组中查找目标值;

/**
 * 题目：https://leetcode-cn.com/problems/find-in-mountain-array/
 * 思路
 * <p>
 *     这道题很明确在考二分查找，
 *     1. 找到峰顶
 *     2. 将数组分为递增数组以及递减数组
 *     3. 先在递增数组中寻找，如果没有，在去递减数组中寻找
 * </p>
 * 注：二分写法有点不熟练，这个代码不是很好
 * @author ifreeky
 * @since 29 四月 2020
 */
public class Solution {

    public int findInMountainArray(int target, MountainArray mountainArr) {

        int lo = 0, hi = mountainArr.length() - 1;
        while (lo + 1 < hi) {
            int mid = (lo + hi) >> 1;
            int midValue = mountainArr.get(mid);
            if (midValue > mountainArr.get(mid - 1)) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        int peakInx = mountainArr.get(lo) > mountainArr.get(hi) ? lo : hi;
        int midPer = getPerValue(target, mountainArr, 0, peakInx);

        return midPer > -1 ? midPer : getLastValue(target, mountainArr, peakInx, mountainArr.length() - 1);
    }

    private int getPerValue(int target, MountainArray mountainArr, int lo, int hi) {
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            int midValue = mountainArr.get(mid);

            if (midValue == target) {
                return mid;
            }
            if (midValue > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    private int getLastValue(int target, MountainArray mountainArr, int lo, int hi) {
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            int midValue = mountainArr.get(mid);

            if (midValue == target) {
                return mid;
            }
            if (midValue > target) {
                lo = mid + 1;
            } else {
                hi = mid -1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        MountainArray mountainArray = new MountainArrayImpl();
        int inMountainArray = solution.findInMountainArray(2, mountainArray);
        System.out.println(inMountainArray);
    }

}
