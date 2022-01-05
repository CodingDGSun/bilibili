package com.codingdgsun.java;

/**
 * @author SunJie
 * @Description
 * @Project: bilibili
 * @Package com.codingdgsun.java
 * @date 2022/1/5 7:44 PM
 */
//05 Java中双指针删除有序数组中重复项问题

/**
 * 问题：
 * 不使用额外数组，原地删除有序数组中的重复项，使每个元素只出现一次。返回删除后的数组的长度。
 *
 * 举例：
 * [2,3,3,4,4,5]
 * 输出：4

 * 分析：
 * 1、数组有序（升序或降序）
 * 2、不能使用额外数组
 * 3、不用输出删除后的数组，只需返回数组长度
 *
 * 解法：双指针
 * 定义2个指针，左指针 left，右指针 right
 * 当左指针 left和右指针 right指向的元素【不相等】时，左指针右移一个，将右指针指向的元素赋值给左指针位置，右指针右移一个
 * 当左指针 left和右指针 right指向的元素【相等】时，左指针坐标不变，右指针坐标右移一个
 * 遍历完数组后，返回left坐标+1，即为处理后的数组长度
 *
 * 操作流程如下
 * 原数组：[2,3,3,4,4,5]
 * left：0，指向：2；right：1，指向：3
 *      2不等于3，则左指针右移一个，将右指针指向的元素赋值给左指针位置，右指针右移一个
 * left：1，指向：3；right：2，指向：3；数组变为：[2,3,3,4,4,5]
 *      3等于3，则左指针坐标不变，右指针坐标右移一个
 * left：1，指向：3；right：3，指向：4；数组变为：[2,3,3,4,4,5]
 *      3不等于4，则左指针右移一个，将右指针指向的元素赋值给左指针位置，右指针右移一个
 * left：2，指向：4；right：4，指向：4；数组变为：[2,3,4,4,4,5]
 *      4等于4，则左指针坐标不变，右指针坐标右移一个
 * left：2，指向：4；right：5，指向：5；数组变为：[2,3,4,4,4,5]
 *      4不等于5，则左指针右移一个，将右指针指向的元素赋值给左指针位置，右指针右移一个
 * left：3，指向：5；right：6 ，此时，right，等于数组长度，不小于数组长度，不满足循环条件，结束循环；最终数组变为：[2,3,4,5,4,5]
 *
 * 返回left坐标+1，则为数组长度：3 + 1 =4
 */
public class Demo05 {
    public static void main(String[] args) {
        int[] arrays = new int[]{2, 3, 3, 4, 4, 5};
        System.out.print("数组为：");
        for (int array : arrays) {
            System.out.print(array + "\t");
        }

        int len = getLength(arrays);
        System.out.println("\n删除重复项后的数组长度为：" + len);
//        for (int array : arrays) {
//            System.out.print(array + "\t");
//        }
    }

    private static int getLength(int[] arrays) {
        if (arrays == null || arrays.length == 0) {
            //数组为空，或者数组长度为0，返回0
            return 0;
        }
        int left = 0;//左指针
        //right 右指针
        for (int right = 1; right < arrays.length; right++) {
            if (arrays[left] != arrays[right]) {
                //左指针指向的元素（以下简称：左元素）与右指针指向的元素（以下简称：右元素）不相等
                // 则左指针往后移动一个
                // 再将右元素赋值给左元素
                left++;
                arrays[left] = arrays[right];
            }
            //反之，左右元素相等，左指针不变，右指针往后移动一个 right++
        }

        return left + 1;//返回左指针坐标 + 1，则为数组的长度
    }
}