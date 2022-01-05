package com.codingdgsun.java;

/**
 * @author SunJie
 * @Description
 * @Project: bilibili
 * @Package com.codingdgsun.java
 * @date 2022/1/5 6:53 PM
 */
//04 Java中的稀疏数组

/**
 * 简介：
 * 当一个数组中大部分元素是0，或者是一个相同的值时，可以使用稀疏数组来保存该数组。
 * 并且稀疏数组，行数为：原来数组中非0元素个数+1；列数为：3。即：稀疏数组列数总是3。
  */
public class Demo04 {
    public static void main(String[] args) {
        System.out.println("原来数组为：");
        int[][] array1 = new int[5][6];
        array1[1][3] = 4;
        array1[3][4] = 6;
        int sum = 0;//非0的元素个数
        for (int[] arrays : array1) {
            for (int array : arrays) {
                System.out.print(array + "\t");
                if (array != 0) {
                    sum++;
                }
            }
            System.out.println();
        }
        System.out.println("原来数组中，非0的元素个数为：" + sum);

        int[][] array2 = new int[sum + 1][3];//稀疏数组，行数为：原来数组中非0元素个数+1，即：sum+1行，3列

        array2[0][0] = array1.length;//稀疏数组第一行第一列：原数组行数
        array2[0][1] = array1[0].length;//稀疏数组第一行第二列：原数组列数
        array2[0][2] = sum;//稀疏数组第一行第三列：原数组中非0的元素个数

        int count = 0;//非0的元素个数，即稀疏数组所在行索引
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[i].length; j++) {
                if (array1[i][j] != 0) {
                    count++;//稀疏数组所在行索引
                    array2[count][0] = i;//稀疏数组第count行第一列，是原数组非0的元素的所在行索引
                    array2[count][1] = j;//稀疏数组第count行第二列，是原数组非0的元素的所在列索引
                    array2[count][2] = array1[i][j];//稀疏数组第count行第三列，是原数组非0的元素值
                }
            }
        }

        System.out.println("稀疏数组为：");
        printArray(array2);//输出稀疏数组

        System.out.println("将稀疏数组还原成正常数组为：");

        //定义二维数组，稀疏数组第一行第一列：原数组行数，第一行第二列：原数组列数
        int[][] array3 = new int[array2[0][0]][array2[0][1]];//数组初始化后，每个元素都为0
        for (int i = 1; i < array2.length; i++) {
            //从稀疏数组，第二行开始遍历，即 i 为1
            //稀疏数组，第i行第一列是原数组非0元素的行索引，
            // 第i行第二列是原数组非0元素的列索引，第i行第三列的值是原数组的元素值
            array3[array2[i][0]][array2[i][1]] = array2[i][2];
        }

        printArray(array3);//输出还原后的数组
    }

    private static void printArray(int[][] arrays) {
        for (int[] array : arrays) {
            for (int num : array) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }
}
/**
 * 输出结果：
 * 原来数组为：
 * 0	0	0	0	0	0
 * 0	0	0	4	0	0
 * 0	0	0	0	0	0
 * 0	0	0	0	6	0
 * 0	0	0	0	0	0
 * 原来数组中，非0的元素个数为：2
 * 稀疏数组为：
 * 5	6	2
 * 1	3	4
 * 3	4	6
 * 将稀疏数组还原成正常数组为：
 * 0	0	0	0	0	0
 * 0	0	0	4	0	0
 * 0	0	0	0	0	0
 * 0	0	0	0	6	0
 * 0	0	0	0	0	0
 */
