package com.program.part1;
/**
 * 
 * @author 杰
 * 单链表的选择排序
 * 题目：给定一个无序单链表的头节点head，实现单链表的选择排序
 * 要求：额外空间复杂度为O(1)
 * 思路：根据要求就知道不能把链表装进数组等容器中排序，排好序再重新连接。
 * 其实是在让你用有限的变量，完成选择排序的过程。
 * 先搞清楚什么是选择排序：从未排序的部分中找到最小值，然后放在排好序的部分的尾部，逐渐将未排序的部分缩小，最后整个序列就有序了
 */
public class Test2_15 {
	public Node selectionSort(Node head){
		Node tail = null;
		Node cur = head;
		Node smallPre = null;
		Node small = null;
		while(cur != null){
			small = cur;
			smallPre = getSmallestPreNode(cur);
			if(smallPre != null){
				small = smallPre.next;
				smallPre.next = small.next;
			}
			cur = cur == small ? cur.next : cur;
			if(tail == null){
				head = small;
			}else{
				tail.next = small;
			}
			tail = small;
		}
		return head;
	}

	private static Node getSmallestPreNode(Node head) {
		Node smallPre = null;
		Node small = head;
		Node pre = head;
		Node cur = head.next;
		while(cur != null){
			if(cur.value < small.value){
				smallPre = pre;
				small = cur;
			}
			pre = cur;
			cur = cur.next;
		}
		return smallPre;
	}
}
