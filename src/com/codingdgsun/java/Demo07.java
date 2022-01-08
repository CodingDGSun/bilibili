package com.codingdgsun.java;

/**
 * @author SunJie
 * @Description
 * @Project: bilibili
 * @Package com.codingdgsun.java
 * @date 2022/1/8 10:13 PM
 */
//07 Java中常见的ASCII码
public class Demo07 {
    public static void main(String[] args) {
        char a = '0';
        char b = 'A';
        char c = 'a';

        int ascii_a = a;
        System.out.println("字符\'0\'的ASCII码为：" + ascii_a);
        //有0至9字符，9比0大9
        char nine = (char) (ascii_a + 9);//字符 '9'
        System.out.println(nine);

        int ascii_b = b;
        System.out.println("字符\'A\'的ASCII码为：" + ascii_b);
        //有26个字母，Z比A大25
        char Z = (char) (ascii_b + 25);//字符 'Z'
        System.out.println(Z);

        int ascii_c = c;
        System.out.println("字符\'a\'的ASCII码为：" + ascii_c);
        //有26个字母，z比a大25
        char z = (char) (ascii_c + 25);//字符 'z'
        System.out.println(z);
    }
}