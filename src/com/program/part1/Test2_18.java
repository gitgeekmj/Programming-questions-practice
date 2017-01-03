package com.program.part1;
/**
 * 
 * @author 杰
 * 合并两个有序的单链表
 * 题目：给定两个有序单链表的头节点head1和head2，请合并两个有序链表，合并后的链表依然有序，并返回合并后链表的头节点
 * 思路：1.如果两个链表中有一个为空，说明无需合并过程，返回另一个链表的头节点即可。
 * 2.比较head1和head2的值，小的节点也是合并后链表的最小节点，也就是新链表的头节点，记为head；
 * 在接下来的过程中哪个链表的头节点的值更小，另一个链表的所有节点都会依次插入到这个链表中。
 */
public class Test2_18 {
	public Node merge(Node head1,Node head2){
		if(head1 == null || head2 == null){
			return head1 != null ? head1 : head2;
		}
		Node head = head1.value < head2.value ? head1 : head2;
		Node cur1 = head == head1 ? head1 : head2;
		Node cur2 = head == head1 ? head2 : head1;
		Node pre = null;
		Node next = null;
		while(cur1 != null && cur2 != null){
			if(cur1.value <= cur2.value){
				pre = cur1;
				cur1 = cur1.next;
			}else {
				next = cur2.next;
				pre.next = cur2;
				pre = cur2;
				cur2 = next;
			}
		}
		pre.next = cur1 == null ? cur2 :cur1;
		return head;
	}
}
