package com.codingdgsun.java;

/**
 * @author SunJie
 * @Description
 * @Project: bilibili
 * @Package com.codingdgsun.java
 * @date 2022/1/11 10:27 PM
 */
//09 Java中双指针求平方根问题

/**
 * 求一个正整数的平方根，不使用Math.sqrt()函数
 *
 * 分析：
 * 25 -> 5
 * 24 -> 4
 * 3 -> 1
 *
 * 解法：双指针法，二分法
 * 1、左指针left = 0；右指针right = num；中间值middle = (left + right) / 2；平方根变量：result
 * 比如：3和5，他们的中间值为 （3 + 5）/ 2 = 4
 * 2、循环条件 left <= right
 * 3、middle * middle <= num，说明，真实平方根比middle大，左指针需要右移，右指针不变
 * 将middle + 1 赋值给左指针left，记下middle的值，赋值给 result变量
 * 4、反之，(long)middle * middle > num，说明，真实平方根比middle小，右指针需要左移，左指针不变，
 * 将middle - 1 赋值给右指针right，此处不用管result变量，因为此时真实平方根比middle小，不用记录此result的变动
 *
 * 遍历完成后，返回 result即为平方根
 *
 * 比如：求13的平方根
 * left 0；right 13；middle 6；6*6 > 13
 *   left 0；right 6 -1 = 5；middle 2； 2 * 2 < 13；result = 2
 * left 3; right 5；middle 4；4 * 4 > 13
 *   left 3; right 3; middle 3; 3 * 3 < 13； result = 3
 * left 4 > right；返回 result 3
 */

public class Demo09 {
    public static void main(String[] args) {
//        System.out.println(Integer.MAX_VALUE);//21亿；2147483647
//        System.out.println(Long.MAX_VALUE);//9223372036854775807
//        System.out.println(getSqrt(2147483647));
        System.out.println(getSqrt(24));
    }

    public static int getSqrt(int num) {
        int result = -1;//初始化平方根
        int left = 0;//左指针
        int right = num;//右指针
        while (left <= right) {
            int middle = (left + right) / 2;
            if ((long) middle * middle <= num) {//long 很重要
                result = middle;
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return result;
    }
}
