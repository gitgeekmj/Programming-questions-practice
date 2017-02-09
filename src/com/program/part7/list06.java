package com.program.part7;

public class list06 {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(2);
		ListNode l5 = new ListNode(2);
		ListNode l6 = new ListNode(6);
		ListNode l7 = new ListNode(7);
		ListNode l8 = new ListNode(8);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		l7.next = l8;
		list06 list = new list06();
		list.clear(l1, 2);
	}

	public ListNode clear(ListNode head, int val) {
		ListNode pre = new ListNode(0);
		ListNode head2 = pre;
		while (head != null) {
			while (head.val == val) {
				head = head.next;
			}
			pre.next = head;
			pre = pre.next;
			head = head.next;
		}
		return head2.next;
	}
}
