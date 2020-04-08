package com.ifreeky.leetcode.旋转矩阵;

/**
 * 题目：https://leetcode-cn.com/problems/rotate-matrix-lcci/
 * 思路
 * <p>
 * 参考官方题解 https://leetcode-cn.com/problems/rotate-matrix-lcci/solution/xuan-zhuan-ju-zhen-by-leetcode-solution/
 * 方法三，先按照中线水平翻转，然后按照对角线翻转。
 * </p>
 *
 * @author ifreeky
 * @since 07 四月 2020
 */
public class Solution {

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int temp;

        int mid = matrix.length >> 1;

        for (int i = 0; i < mid; i++) {
            for (int j = 0; j < matrix.length; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - i - 1][j];
                matrix[matrix.length - i - 1][j] = temp;
            }
        }

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
