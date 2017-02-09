package com.program.part7;

import java.util.ArrayList;

public class list03 {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(360);
		ListNode l2 = new ListNode(220);
		ListNode l3 = new ListNode(2);
		// ListNode l4 = new ListNode(563);
		// ListNode l5 = new ListNode(1);
		l1.next = l2;
		l2.next = l3;
		// l3.next = l4;
		// l4.next = l5;
		list03 list = new list03();
		list.listDivide3(l1, 2);
	}

	/**
	 * 根据目标数 划分链表 不在意先后顺序版
	 * 
	 * @param head
	 * @param val
	 * @return
	 */
	public ListNode listDivide(ListNode head, int val) {
		if (head == null) {
			return head;
		}
		ListNode pre = new ListNode(val);
		ListNode temp1 = pre;
		ListNode temp2 = pre;
		ListNode nex = head;
		ListNode temp3 = null;
		int i = 1;
		while (head != null) {
			if (head.val <= temp1.val) {
				nex = new ListNode(head.val);
				if (i == 1) {
					temp3 = nex;
					i--;
				}
				nex.next = pre;
				pre = nex;
				head = head.next;
			} else {
				temp2.next = new ListNode(head.val);
				temp2 = temp2.next;
				head = head.next;
			}
		}
		if (temp1.next == null) {
			temp3.next = null;
		} else {
			temp3.next = temp1.next;
		}
		return pre;
	}

	public ListNode listDivide2(ListNode head, int val) {
		ArrayList<Integer> arr = new ArrayList<>();
		ListNode temp = head;
		while (temp != null) {
			arr.add(temp.val);
			temp = temp.next;
		}
		int p0 = 0;
		int pn = arr.size() - 1;
		int m = 0;
		while (m <= pn) {
			if (arr.get(m) == val) {
				m++;
			} else if (arr.get(m) < val) {
				if (arr.get(p0) < val) {
					p0++;
					m++;
				} else {
					int mid = arr.get(m);
					arr.set(m, arr.get(p0));
					arr.set(p0, mid);
					p0++;
					m++;
				}
			} else if (arr.get(m) > val) {
				if (arr.get(pn) > val) {
					pn--;
				} else if (m < pn) {
					int mid = arr.get(m);
					arr.set(m, arr.get(pn));
					arr.set(pn, mid);
					pn--;
				} else {
					pn--;
				}
			}
		}
		temp = head;
		for (int i = 0; i < arr.size(); i++) {
			temp.val = arr.get(i);
			temp = temp.next;
		}
		return head;
	}

	public ListNode listDivide3(ListNode head, int val) {
		ListNode pre1 = new ListNode(0);
		ListNode pre2 = pre1;
		ListNode aft1 = new ListNode(0);
		ListNode aft2 = aft1;
		while (head != null) {
			if (head.val <= val) {
				pre2.next = head;
				pre2 = pre2.next;
			} else {
				aft2.next = head;
				aft2 = aft2.next;
			}
			head = head.next;
		}
		pre2.next = aft1.next;
		aft2.next = null;
		return pre1.next;
	}
	/**
	 * 相等排中间 的 链表划分问题
	 * @param head
	 * @param val
	 * @return
	 */
	public ListNode listDivide4(ListNode head, int val) {
		ListNode pre1 = new ListNode(0);
		ListNode pre2 = pre1;
		ListNode mid1 = new ListNode(0);
		ListNode mid2 = mid1;
		ListNode aft1 = new ListNode(0);
		ListNode aft2 = aft1;
		while (head != null) {
			if (head.val < val) {
				pre2.next = head;
				pre2 = pre2.next;
			} else if (head.val == val) {
				mid2.next = head;
				mid2 = mid2.next;
			} else if (head.val > val) {
				aft2.next = head;
				aft2 = aft2.next;
			}
			head = head.next;
		}
		pre2.next = mid1.next;
		mid1.next = aft1.next;
		aft2.next = null;
		return pre2.next;
	}
}
