package com.program.test;
/**
 * 
 * @author 杰
 *反转单向和双向链表
 *题目：分别实现反转单向链表和反转双向链表的函数
 *要求：如果链表长度为N，时间复杂度要求为O(N)，额外空间复杂度要求为O(1)
 *思路：需要有一个Node保存着当前头指针指向的下一个节点，还需要一个Node去指向当前头指针的前一个节点，这样三个指针各自往前移动，让头指针的next指向前一个节点即可
 */
public class Test2_4 {
	public static void main(String[] args) {

	}
	public Node reverseList(Node head){
		Node pre = null;
		Node next = null;
		while(head != null){
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return head;
	}
	public DoubleNode reverseList(DoubleNode head){
		DoubleNode pre = null;
		DoubleNode next = null;
		while(head != null){
			next = head.next;
			head.next = pre;
			head.last = next;
			pre = head;
			head = next;
		}
		return head;
	}
}
