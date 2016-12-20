package com.program.test;

public class Test2_3 {

	/**
	 * @Mr.马
	 * 删除链表的中间节点和a/b处的节点
	 * 题目：给定链表的头结点head，实现删除链表的中间节点的函数
	 * 思路：如果链表长度为1或者为空，不需要调整，直接返回即可。
	 * 如果链表长度为2，那么需要删掉第1个节点
	 * 如果链表长度为3，那么需要删除第2个节点
	 * 如果链表长度为4，那么需要删除第2个节点
	 * 如果链表长度为5，那么需要删除第3个节点
	 * 按照这样的规律，就是说链表每增加2，要删除的节点的位置就加1。
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public Node removeMidNode(Node head){
		if(head == null || head.next == null){
			return head;
		}
		if(head.next.next == null){
			return head.next;
		}
		Node pre = head;
		Node cur = head.next.next;
		while(cur.next != null && cur.next.next != null){
			pre = pre.next;
			cur = cur.next.next;
		}
		pre.next = pre.next.next;
		return head;
	}
	/**
	 * 进阶问题，思考第一个点是：如何根据链表长度n，以及a与b的值决定该删除的节点是哪一个节点呢？
	 * 先计算double r = ((double)(a*n))/((double)b)的值，然后r向上取整之后的整数值代表该删除的节点是第几个节点
	 */
	public Node removeByRatio(Node head,int a,int b){
		if(a < 1 || a > b){
			return head;
		}
		int n = 0;
		Node cur = head;
		while(cur != null){
			cur = cur.next;
			n++;
		}
		n = (int)Math.ceil((double)(a*n)/(double)b);
		if(n == 1){
			head = head.next;
		}
		if(n > 1){
			cur = head;
			while(--n != 0){
				cur = cur.next;
			}
			cur.next = cur.next.next;
		}
		return head;
	}
}
