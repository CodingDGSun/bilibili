package com.codingdgsun.java;
import java.util.Random;

/**
 * @author SunJie
 * @Description
 * @Project: bilibili
 * @Package com.codingdgsun.java
 * @date 2022/1/8 10:46 PM
 */
//08 Java中将数字转换为反转的数字数组

/**
 * 问题：Java中将数字转换为反转的数字数组
 * 1234 => [4,3,2,1]
 * 0 => [0]
 * 分析：
 * 将数字中的每个数字，逆序放入一个数组中
 *
 * 解法：
 * 步骤：
 * 1、将数字转成字符串，获取字符串长度
 * 2、新建同样长度的int数组
 * 3、逆序将字符串中的每个字符，转成整型，再与48之差，放入int数组中
 */
public class Demo08 {
    public static void main(String[] args) {
        Random random = new Random();
        int num = random.nextInt(10000);//[0, 10000)
        System.out.println("数字为：" + num);
        String str = String.valueOf(num);
        int len = str.length();
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            char c = str.charAt(len - i - 1);//逆序获取字符
            //字符'0'的ASCII码（将字符转成int整型，其实是转成ASCII码）为：48；
            //字符'9'的ASCII码为：57；
            array[i] = (int) c - 48;//将字符转成整数，即获取ASCII码，比如：字符'0'转成整型后为：48，再减去 48，得到数字0
        }

        System.out.println("反转后的数字数组为：");
        for (int a : array) {
            System.out.print(a + "\t");
        }
    }
}
