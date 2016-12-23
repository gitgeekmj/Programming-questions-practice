package com.program.test;

import java.util.HashSet;

/**
 * 
 * @author 杰
 * 删除无序链表中值重复出现的节点
 * 题目：给定一个无序单链表的头节点head，删除其中值重复出现的节点
 * 例如：1->2->3->4->4->2->1->1->null,删除值重复的节点之后为1->2->3->4->null
 * 请按以下要求实现两种方法
 * 方法一（要求一）：如果链表长度为N，时间复杂度达到O(N)
 * 方法二（要求二）：额外空间复杂度为O(1)
 */
public class Test2_13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 方法一：利用哈希表。时间复杂度为O(N)，额外空间复杂度为O(N)
	 * 生成一个哈希表，因为头节点是不需要删除的点，所以首先将头节点的值放入哈希表。
	 * 从头节点的下一个值开始遍历，每遇到一个节点，判断该节点的值在不在哈希表中，如果在，说明重复，删除该节点，如果不在，说明为新节点将值放入哈希表
	 */
	public void removeRep1(Node head){
		if(head == null){
			return;
		}
		HashSet<Integer> set = new HashSet<Integer>();
		Node pre = head;
		Node cur = head.next;
		set.add(head.value);
		while(cur != null){
			if(set.contains(cur.value)){
				pre.next = cur.next;
			}else{
				set.add(cur.value);
				pre = cur;
			}
			cur = cur.next;
		}
	}
	/**
	 * 方法二 类似选择排序的过程，时间复杂度为O(N^2),额外空间复杂度为O(1)
	 * 比如链表1->2->3->4->4->2->1->1->null
	 * 首先是头节点，节点值为1，往后检查所有值为1的节点，全部删除。类似这样的过程，处理每个节点。
	 */
	public void removeRep2(Node head){
		Node cur = head;
		Node pre = null;
		Node next = null;
		while(cur != null){
			pre = cur;
			next = cur.next;
			while(next != null){
				if(cur.value == next.value){
					pre.next = next.next;
				}else{
					pre = next;
				}
				next = next.next;
			}
			cur = cur.next;
		}
	}
}
