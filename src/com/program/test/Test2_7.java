package com.program.test;

import java.util.Stack;

public class Test2_7 {

	/**
	 * @param args
	 * 判断一个链表是否为回文结构
	 * 题目：给定一个链表的头节点head，请判断该链表是否为回文结构
	 * 思路：使用一个栈结构，遍历整个链表，将每个节点压入栈，如果是回文结构，那么出栈的节点值应该和入栈的节点值相等，由此判断
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean isPalindrome1(Node head){
		Stack<Node> stack = new Stack<Node>();
		Node cur = head;
		while(cur != null){
			stack.push(cur);
			cur = cur.next;
		}
		while(head != null){
			if(head.value != stack.pop().value){
				return false;
			}
			head = head.next;
		}
		return true;
	}
	/**
	 * 进阶：如果链表长度为N，要求时间复杂度为O(N)，额外空间复杂度为O(1)
	 * 思路：将这个链表分成两个半区，左半区与右半区
	 * 改变链表右半区的结构，使整个右半区反转，最后指向中间节点，将左半区第一个节点叫做leftStart,右半区第一个节点叫做rightStart
	 * leftStart和rightStart同时向中间点移动，移动每一步都比较两个节点的值是否一样，如果都一样，说明链表为回文结构，否则不是
	 * 但无论最后返回什么，都应该在返回前把链表恢复成原来的样子
	 * 链表恢复后，返回结果
	 */
	public boolean isPalindrom2(Node head){
		if(head == null || head.next == null){
			return true;
		}
		Node n1 = head;
		Node n2 = head;
		while(n2.next != null && n2.next.next != null){//查找中间节点
			n1 = n1.next;//n1->中部
			n2 = n2.next.next;//n2->结尾			
		}
		n2 = n1.next;//
		n1.next = null;
		Node n3 = null;
		while(n2 != null){
			n3 = n2.next;
			n2.next = n1;
			n1 = n2;
			n2 = n3;
		}
		n3 = n1;
		n2 = head;
		boolean res = true;
		while(n1 != null && n2 != null){
			if(n1.value != n2.value){
				res = false;
				break;
			}
			n1 = n1.next;
			n2 = n2.next;
		}
		n1 = n3.next;
		n3.next = null;
		while(n1 != null){
			n2 = n1.next;
			n1.next = n3;
			n3 = n1;
			n1 = n2;
		}
		return res;
	}
	

}
