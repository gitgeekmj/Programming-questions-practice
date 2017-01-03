package com.program.part1;

public class Test2_2 {

	/**
	 * @Mr.马   
	 * 在单链表和双链表中删除倒数第K个节点   
	 * 题目：分别实现两个函数，一个可以删除单链表中倒数第k个节点，另一个可以删除双链表中倒数第k个节点
	 * 要求：如果链表长度为N，时间复杂度达到O(N)，额外空间复杂度达到O(1)
	 * 思路：
	 * 先说单链表：如果链表为空，或者k<1，不符合删除要求，直接返回即可。
	 * 当链表长度大于1时，从链表头开始，遍历每个元素，每遍历一个，k-1，直到遍历到链表为空。
	 * 此时如果k>=1，说明不存在要删除的元素
	 * 当k=0时，说明链表头为需要删除的元素，此时令head=head.next即可（相当于删掉了头）
	 * 当k<0时，说明要删除的节点在链表中间，这时删除一个节点就意味着让该节点的前一个节点指向该节点的后一个节点即可。
	 * 此时重新从头遍历链表，每经过一个元素，k+1，直到k=0为止。
	 * 因为第N-K个节点为目标节点的前一个节点，而当k<0时，x+k=0，第x个节点也就是目标节点的前一个节点
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public Node removeLastKthNode(Node head,int lastKth){
		if(head == null || lastKth < 1){
			return head;
		}
		Node cur = head;//遍历用节点cur
		while(cur != null){
			lastKth--;
			cur = cur.next;
		}
		if(lastKth == 0){
			return head.next;
		}
		if(lastKth < 0){
			cur = head;
			while(++lastKth != 0){
				cur = cur.next;
			}
				cur.next = cur.next.next;
		}
		return head;
	}
	
	public DoubleNode removeLastKthNode(DoubleNode head,int lastKth){
		if(head == null || lastKth < 1){
			return head;
		}
		DoubleNode cur = head;
		while(cur != null){
			cur = cur.next;
			lastKth--;
		}
		if(lastKth == 0){
			head = head.next;
			head.last = null;
		}
		if(lastKth < 0){
			cur = head;
			while(++lastKth != 0){
				cur = cur.next;
			}
			DoubleNode newNext = cur.next.next;
			head.next = newNext;
			if(newNext != null){
				newNext.last = cur;
			}
		}
		return head;
	}
}
