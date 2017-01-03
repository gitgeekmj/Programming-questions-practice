package com.program.part1;

/**
 * 
 * @author 杰
 * 一种怪异的节点删除方式
 * 题目：链表节点值类型为int型，给定一个链表中的节点node，但不给定整个链表的头节点。如何在链表中删除node？请实现这个函数，并分析这会出现哪些问题
 * 要求：时间复杂度为O(1)
 * 思路：要做到删除这个操作较为容易，但会带来很大的问题。
 * 只知道中间节点如何删除它，我们一般删除节点的方式是节点的前一个节点指向该节点的后一个节点，从而删除。本题中无法找到该节点的前一个节点，所以只能这样：
 * 将下一个节点的值赋值到本节点，然后删除下一个节点即可，即就是本节点复制后指向next.next。、
 * 会出现什么问题：
 * 第一个问题：
 * 无法删除一个链表中的最后一个节点，因为最后一个节点没有下一个节点，也无法找到上一个节点，所欲无法删除尾节点。
 * 第二个问题：
 * 这种删除方式在本质上根本就不是删除了node节点，而是改变其值，删除了下一个节点。在实际的工程中会有很大的隐患。比如：工程上的一个节点代表着很复杂的结构，节点的复制相当困难和复杂，甚至改变节点值都是不允许的。
 */
public class Test2_16 {
	public void removeNodeWired(Node node){
		if(node == null){
			return;
		}
		Node next = node.next;
		if(next == null){
			throw new RuntimeException("can not remove last node");
		}
		node.value = node.next.value;
		node.next = node.next.next;
	}
}
