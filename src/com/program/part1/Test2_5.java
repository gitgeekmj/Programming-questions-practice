package com.program.part1;
/**
 * 
 * @author 杰
 *反转部分单向链表
 *题目：给定一个单向链表的头结点head，以及两个整数form和to，在单向链表上把第from个节点到第to个节点这一部分进行反转
 *要求：如果链表长度为N，时间复杂度要求为O(N)，额外空间复杂度要求为O(1)，如果不满足1<=from<=to<=N,则不用调整
 *思路：首先需要明确的是，会存在换头问题，就是调整区间包括头节点的话就会有换头现象，所以函数返回应该为头节点
 *第一步判断1<=from<=to<=N,如果不满足，则直接返回原来的头节点
 *第二步找到第from-1个节点fPro和第to+1个节点tPos。fPro是要反转部分的前一个节点，tPos是反转部分的后一个节点。把反转部分先反转，然后正确连接fPre和tPos。
 *此时如果fPre为null，说明反转部分是包含头节点的，则返回新的头节点，也就是没反转之前反转部分的最后一个节点，如果fPos不为null，则返回旧的头节点
 */
public class Test2_5 {
	public static void main(String[] args) {

	}
	public Node reversePart(Node head,int from,int to){
		int len = 0;
		Node node1 = head;
		Node fPre = null;
		Node tPos = null;
		while(node1 != null){
			len++;
			//这两个条件没有包含两种情况 to>len 和 fPre==null
			fPre = len == from - 1 ? node1 : fPre;
			tPos = len == to + 1 ? node1 : tPos;
			node1 = node1.next;
		}
		if(from > to || from < 1 || to > len){
			return head;
		}
		node1 = fPre == null ? head : fPre.next;
		Node node2 = node1.next;
		node1.next = tPos;
		Node next = null;
		while(node2 != tPos){
			next = node2.next;
			node2.next = node1;
			node1 = node2;
			node2 = next;
		}
		if(fPre != null){
			fPre.next = node1;
			return head;
		}
		return node1;
	}
}
