package com.codingdgsun.java;

import java.util.Random;

/**
 * @author SunJie
 * @Description
 * @Project: bilibili
 * @Package com.codingdgsun.java
 * @date 2022/1/1 8:48 AM
 */

/**
 * 01 Java中获取随机整数
 */
public class Demo01 {
    public static void main(String[] args) {
        Random random = new Random();
        //random.nextInt(num)代表：0至num之间的随机整数
        // 左边闭区间，右边开区间，左闭右开，包含左边界，不包含有边界
        // >=0,<num

        //1位整数
        int result = random.nextInt(10);//[0,10)即，[0,9]
        System.out.println("1位整数是：" + result);

        //2位整数
        result = random.nextInt(90) + 10;//[0,90) + 10，即，[10,100)，[10,99]
        System.out.println("2位整数是：" + result);

        //3位整数
        result = random.nextInt(900) + 100;//[0,900) + 100，即，[100,1000)，[100,999]
        System.out.println("3位整数是：" + result);

        //任意2个数区间的随机整数，包含边界
        // [min, max] 随机整数
        //公式：random.nextInt(max - min + 1) + min

        //获取[45,56]之间的随机整数
        result = random.nextInt(56 - 45 + 1) + 45;//random.nextInt(12) + 45 =>  [0,12) + 45 =>  [45,57) =>[45,56]
        System.out.println("[45,56]之间的随机整数是：" + result);
    }
}
