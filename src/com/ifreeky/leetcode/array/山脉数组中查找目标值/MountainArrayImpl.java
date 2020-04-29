package com.ifreeky.leetcode.array.山脉数组中查找目标值;

/**
 * @author ifreeky
 * @since 29 四月 2020
 */
public class MountainArrayImpl implements MountainArray{

    public static Integer[] mountainArr = {1,5,2};
    public static Integer transferCount = 0;

    @Override
    public int get(int index) {
        if (transferCount >= 100){
            throw new RuntimeException("调用超次数了");
        }
        return mountainArr[index];
    }

    @Override
    public int length() {
        return mountainArr.length;
    }
}
