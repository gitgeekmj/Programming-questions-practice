package com.program.part1;

import java.util.Stack;

public class Test2_10 {

	/**
	 * @param args
	 * 两个单链表生成相加链表
	 * 题目：假设链表中每一个节点的值都在0~9之间，那么链表整体就可以代表一个整数
	 * 例如9->3->7，可以代表整数937
	 * 给定两个这种链表的头节点head1和head2，请生成代表两个整数相加值的结果链表。
	 * 例如：链表1为9->3->7，链表2为6->3，最后生成新的结果链表为1->0->0->0.
	 * 思路：第一种比较直观，将两个链表先算出各自的整数，然后求出两个整数的和，最后将这个和转换成链表的形式
	 * 这种方法有一个很大的问题，如果链表长度很长，表达的是一个很大的整数，因此，转成系统中的int类型时会发生溢出
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public Node assList1(Node head1,Node head2){
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		while(head1 != null){
			s1.push(head1.value);
			head1 = head1.next;
		}
		while(head2 != null){
			s2.push(head2.value);
			head2 = head2.next;
		}
		int ca = 0;
		int n1 = 0;
		int n2 = 0;
		int n = 0;
		Node node = null;
		Node pre = null;
		while(!s1.isEmpty() || !s2.isEmpty()){
			n1 = s1.isEmpty() ? 0 : s1.pop();
			n2 = s2.isEmpty() ? 0 : s2.pop();
			n = n1 + n2 + ca;
			pre = node;
			node = new Node(n % 10);
			node.next = pre;
			ca = n / 10;
		}
		if (ca == 1){
			pre = node;
			node = new Node(1);
			node.next = pre;
		}
		return node;
	}

}
