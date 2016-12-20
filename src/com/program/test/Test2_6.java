package com.program.test;

public class Test2_6 {

	/**
	 * @param args
	 * 环形单链表的约瑟夫问题
	 * 题目：犹太人的自杀方式，41个人排成一个圆圈，由第一个人开始报数，报数到第3个人就自杀，再由下一个人重新报1，报数到第3个人就自杀，依次这样。
	 * 请使用单向环形链表描述该结构并呈现整个自杀过程。
	 * 输入：一个环形单向链表的头节点head和报数的值m
	 * 返回：最后生存下来的节点，且这个节点自己组成环形单向链表，其他节点都删除。
	 * 思路：过程就如同题目描述一样
	 * 如果链表为空或者链表节点数为1，或者m的值小于1，则不用调整就直接返回
	 * 在环形链表中遍历每个节点，不断转圈，不断让每个节点报数
	 * 当报数到达m时，就删除当前报数的节点。
	 * 删除节点后，别忘了把剩下的节点继续连成环状，继续转圈报数，继续删除。
	 * 不停的删除，直到环形链表中只剩一个节点，过程结束
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 
	 * @param head
	 * @param m
	 * @return
	 * 此为普通解法，很明显，每删除掉一个节点，都需要遍历m次，一共需要删除的节点数为n-1
	 * 所以该解法的时间复杂度为O(n*m)
	 */
	public Node josephusKill1(Node head,int m){
		if(head == null || head.next == head || m < 1){
			return head;
		}
		Node last = head;
		while(last.next != head){
			last = last.next;
		}
		int count = 0;
		while(head != last){
			if(++count == m){
				last.next = head.next;
				count = 0;
			}else {
				last = last.next;
			}
			head = last.next;
		}
		return head;
	}
	/**
	 *进阶问题：如果链表节点数为N，想在时间复杂度为O(N)时完成原问题的要求，该怎么实现？
	 *思路：原方法解题花费时间长的根本在于一开始不知道哪个节点最后会活下来，所以依靠不断的删除淘汰节点最终才能确定。
	 *是否有办法直接确定最后活下来的节点是哪个？
	 */
	public Node josephusKill2(Node head,int m){
		if(head == null || head.next == head || m < 1){
			return head;
		}
		Node cur = head.next;
		int tmp = 1;//tmp代表链表的长度
		while(cur != head){
			tmp++;
			cur = cur.next;
		}
		tmp = getLive(tmp,m);//这里tmp代表幸运节点的编号
		while(--tmp != 0){
			head = head.next;
		}
		head.next = head;
		return head;
	}
	public int getLive(int i, int m) {
		if(i == 1){
			return 1;
		}
		return (getLive(i - 1,m) + m - 1) % i + 1;
	}
	
}
