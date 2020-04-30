package com.ifreeky.leetcode.hashTable.快乐数;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目：https://leetcode-cn.com/problems/happy-number/
 * @author ifreeky
 * @since 30 四月 2020
 */
public class Solution {

    public boolean isHappy(int n) {
        Set<Integer> unHappySet = new HashSet<>();
        while (n != 1 && !unHappySet.contains(n)) {
            unHappySet.add(n);
            n = getNextNum(n);
        }
        return 1 == n;
    }

    private int getNextNum(int n) {
        int sum = 0;
        while (n > 0) {
            int i = n % 10;
            n = n / 10;
            sum += i * i;
        }
        return sum;
    }

}
