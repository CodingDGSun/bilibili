package com.codingdgsun.java;

/**
 * @author SunJie
 * @Description
 * @Project: bilibili
 * @Package com.codingdgsun.java
 * @date 2022/1/5 10:30 PM
 */
//06 Java中寻找数组中心下标问题

/**
 * 问题：Java中寻找数组中心下标问题
 * 数组中一个元素的下标，此元素左侧所有元素之和与此元素右侧所有之和相等，
 * 则此元素的数组下标为：数组的中心下标
 *
 * 如果不存在中心下标，返回-1
 * 如果存在多个数组下标，则返回最靠左的一个中心下标
 *
 * 分析：
 * 中心下标可能在数组两端 [0,0] -> 0
 * 可能存在多个中心下标 [-1,1,0,0,0] -> 2
 * 中心下标元素左侧所有元素之和：简称为左边之和
 * 中心下标元素右侧所有元素之和：简称为右边之和
 * 数组总和 = 左边之和 + 右边之和 + 中心元素
 * 左边之和 + 中心元素 = 右边之和 + 中心元素 = 数组总和 - 左边之和
 *
 * 解法：
 * 1、求出原数组总和 sum
 * 2、从左依次遍历数组，累加在一个变量中，左边之和：leftSum
 * 3、当leftSum + 正在遍历的当前数组值 = sum - 左边之和（正在遍历的当前数组值，依次遍历）时，
 *    则正在遍历的当前数组值的下标为：中心下标
 *
 * 如果遍历完数组都没有找到中心数组，则返回-1
 */
public class Demo06 {
    public static void main(String[] args) {
        int[] arrays = new int[]{2, 5, 3, 4, 3};

        int sum = 0;
        for (int array : arrays) {
            sum += array;
        }
        System.out.println("数组总和为：" + sum);

        int index = getCenterIndex(sum, arrays);
        System.out.println("数组中心下标为：" + index);
    }

    private static int getCenterIndex(int sum, int[] arrays) {
        int leftSum = 0;
        for (int i = 0; i < arrays.length; i++) {
            leftSum = leftSum + arrays[i];//中心坐标元素值+中心坐标左侧所有数组之和
            if (leftSum == sum) {
                return i;
            }
            sum = sum - arrays[i];//中心坐标元素值+中心坐标右侧所有数组之和
        }
        return -1;
    }
}
