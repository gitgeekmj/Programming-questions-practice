package com.program.test;
/**
 * 
 * @author 杰
 * 向有序的环形单链表中插入新节点
 * 题目：一个环形单链表从头节点head开始不降序，同时由最后的节点指回头节点。给定这样一个环形单链表的头节点head和一个整数num，请生成节点值为num的新节点，并插入到这个环形链表中，保证调整后的链表依然有序
 * 要求：时间复杂度为O(N),空间复杂度为O(1)
 * 思路：1.生成节点值为num的新节点，记为node
 * 2.如果链表为空，让node自己组成环形链表，然后直接返回node。
 * 3.如果链表不为空，令变量pre=head，cur=head.next，然后令pre和cur同步移动下去，
 * 如果遇到pre的节点值小于或等于num，并且cur的节点值大于或等于num，说明node应该在
 * pre与cur节点之间插入，插入node，然后返回head即可
 * 4.如果pre和cur转了一圈，这期间都没有发现步骤3所说的情况，说明node应该插入到头节点的前面。
 * 之所以会发生这种情况，因为node节点值要么大于所有节点，要么小于所有节点
 * 5.如果node节点值比链表中的其他节点值大，返回原来的头节点即可，如果node节点比
 * 链表中的所有节点值小，那么应该把node作为新的头节点返回。
 */
public class Test2_17 {
	public Node insertNum(Node head,int num){
		Node node = new Node(num);
		if(head == null){
			node.next = node;
			return node;
		}
		Node pre = head;
		Node cur = head.next;
		while(cur != head){
			if(pre.value <= num && cur.value >= num){
				break;
			}
			pre = cur;
			cur = cur.next;
		}
		pre.next = node;
		node.next = cur;
		return head.value < num ? head : node;
	}
}
