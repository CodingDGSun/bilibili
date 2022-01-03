package com.codingdgsun.java;

/**
 * @author SunJie
 * @Description
 * @Project: bilibili
 * @Package com.codingdgsun.java
 * @date 2022/1/3 8:56 PM
 */

import java.util.Random;

/**
 * 02 Java数组中左最大右最大问题
 * 问题：Java数组中左最大右最大，差绝对值最大问题
 * 给定一个数组，分隔成两个区域，找出两个区域中的，各自最大值
 * 要求两个区域中各自最大值之差的绝对值最大，并且左边区域和右边区域至少有一个元素
 *
 * 分析：
 * 1、原数组长度至少为2，这样才能分成左右2个区域
 * 2、找出两个区域，各自的最大值
 * 3、两个最大值之差的绝对值，要求最大
 *
 * 举例：
 * [5,3] -> 左边最大：5；右边最大：3，差的绝对值最大为：2
 *
 * [3,11,44]
 * -> [3]和[11,44]。左边最大：3；右边最大：44，差的绝对值为：41
 * -> [3,11]和[44]。左边最大：11；右边最大：44，差的绝对值为：33
 * 结果为：左边最大：3；右边最大：44，差的绝对值最大为：41
 *
 * [46,12,43,10]
 * -> [46]和[12,43,10]。左边最大：46；右边最大：43，差的绝对值为：3
 * -> [46,12]和[43,10]。左边最大：46；右边最大：43，差的绝对值为：3
 * -> [46,12,43]和[10]。左边最大：46；右边最大：10，差的绝对值为：36
 * 结果为：左边最大：46；右边最大：10，差的绝对值最大为：36
 *
 * 解法：
 * 1、找出原数组的最大值 max
 * 2、找出第一个元素maxLeft和最后一个元素maxRight，选择最小的一个
 * 3、用max与选择的值之差，即为结果
 */
public class Demo02 {
    public static void main(String[] args) {
        Random random = new Random();
        //保证数组至少有2个元素
        int length = random.nextInt(10) + 2;//[0,10) +2 => [2,12)即，[2,11]
        System.out.println("数组长度为：" + length);
        int[] arrays = new int[length];

        for (int i = 0; i < length; i++) {
            arrays[i] = random.nextInt(100);//[0,100)即，[0,99]
        }
        System.out.print("数组为：");
        for (int array : arrays) {
            System.out.print(array + "\t");
        }

        System.out.println();
        int differ = getDiffer(arrays);

        System.out.println("左区域与右区域，各自最大值，差的绝对值最大为：" + differ);
    }

    private static int getDiffer(int[] a) {
        if (a == null) {
            //数组为空
            return 0;
        }

        int length = a.length;
        if (length == 0 || length == 1) {
            //数组中没有元素或只有1个元素
            return 0;
        } else {
            //数组中元素个数大于等于2个
            int max = getMax(a, length);
            int maxLeft = a[0];//第一个元素
            int maxRight = a[length - 1];//最后一个元素
            System.out.println("数组中最大值是：" + max + ", 第一个元素是：" + maxLeft + ", 最后一个元素是：" + maxRight);
            if (maxLeft < maxRight) {
                //第一个元素作为左区域，max在右区域
                System.out.println("左边最大：" + maxLeft + ", 右边最大：" + max);
                return max - maxLeft;
            } else {
                //最后一个元素作为右区域，max在左区域
                System.out.println("左边最大：" + max + ", 右边最大：" + maxRight);
                return max - maxRight;
            }
        }
    }

    private static int getMax(int[] a, int length) {
        int max = a[0];
        for (int i = 1; i < length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }
}