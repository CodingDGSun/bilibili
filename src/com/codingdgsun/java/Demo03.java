package com.codingdgsun.java;

/**
 * @author SunJie
 * @Description
 * @Project: bilibili
 * @Package com.codingdgsun.java
 * @date 2022/1/4 5:35 PM
 */

/**
 * 03 Java中迭代反转链表问题
 * 问题：将单链表的顺序反转
 * 样例：1 -> 2 -> 3   反转为：3 -> 2 -> 1
 *
 * 分析：
 * 1（next节点指向2）、2（next节点指向3）、3（next节点指向null）
 * 要改变各自的next节点指向：
 * 1（next节点指向null）、2（next节点指向1）、3（next节点指向2）
 *
 * 解法：迭代法
 * 步骤：
 * 1、传入一个节点，标识为当前节点：current
 * 2、保存当前节点的下一个节点，在一个临时节点变量中：next
 * 3、设置当前节点的下一个节点，指向一个前节点变量：previous
 * 4、将当前current节点放入变量节点previous中
 * 5、将next节点变为current节点，依次遍历，当current为空时，返回previous节点，即"头结点"
 */
public class Demo03 {
    public static void main(String[] args) {
        //1 -> 2 -> 3 -> null
        ListNode node3 = new ListNode(3, null);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        System.out.println(node1);
        /**
         * 输出结果：
         * ListNode{
         *      value=1, next=ListNode{
         *          value=2, next=ListNode{
         *              value=3, next=null
         *          }
         *      }
         * }
         */

        // 3 -> 2 -> 1 -> null
        ListNode previous = reverseNode(node1);
        System.out.println(previous);
        /**
         * 输出结果：
         *ListNode{
         *      value=3, next=ListNode{
         *          value=2, next=ListNode{
         *              value=1, next=null
         *          }
         *      }
         * }
         */
    }

    //迭代方式
    private static ListNode reverseNode(ListNode head) {
        ListNode previous = null;//相对于下一个节点来说是前一个节点（将当前节点保存在此变量中）
        ListNode next;//相对于当前节点来说是后一个节点（将当前节点的下一个节点保存在此变量中）
        ListNode current = head;//当前节点

        while (current != null) {
            next = current.getNext();//将当前节点的下一个节点，保存在next临时节点中
            current.setNext(previous);//扭转当前节点的指向，设置指向的下一个节点，指向前一个节点
            previous = current;//相对于下一个节点来说是前一个节点（将当前节点保存在previous变量中）
            current = next;//将下一个节点，作为"当前节点"依次向下遍历
        }
        return previous;//返回最后一个节点，即"头"节点
    }
}