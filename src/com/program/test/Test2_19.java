package com.program.test;
/**
 * 
 * @author 杰
 * 按照左右半区的方式重新组合单链表
 * 题目：给定一个单链表的头部节点head，链表长度为N，如果N为偶数，那么前N/2个节点算作左半区，其余算作右半区；
 * 如果N为奇数，那么前N/2个节点算作左半区，后N/2+1个节点算作右半区。左半区从左到右依次记为L1->L2->...，右半区从左到右
 * 依次记为R1->R2...，请将单链表调整成L1->R1->L2->R2...的形式。
 */
public class Test2_19 {
	public void relocate(Node head){
		if(head == null || head.next == null){
			return;
		}
		Node mid = head;
		Node right = head.next;
		while(right.next != null && right.next.next != null){
			mid = mid.next;
			right = right.next.next;
		}
		right = mid.next;
		mid.next = null;
		mergeLR(head,right);
	}

	private void mergeLR(Node left, Node right) {
		Node next = null;
		while(left.next != null){
			next = right.next;
			right.next = left.next;
			left.next = right;
			left = right.next;
			right = next;
		}
		left.next = right;
	}
}
