package com.program.part1;

public class Test2_1 {
	/**
	 * @Mr.马
	 * 打印两个有序链表的公共部分
	 * 题目：给定两个有序链表的头指针head1和head2，打印两个链表的公共部分
	 * 思路：注意是两个有序链表，有序意味着数字的顺序排列好了。那么只需要挨着比较即可。
	 * 当head1的值小于head2的值，移动head1到下一个位置。
	 * 当head2的值小于head1的值，移动head2到下一个位置。
	 * 当head1等于head2，将两个链表头指针都移动一个位置。
	 * 任意一个链表头到达null，结束整个过程。
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public void printCommonPart(Node head1,Node head2){
		System.out.println("Common Part: ");
		while(head1 != null && head2 != null){
			if(head1.value < head2.value){
				head1 = head1.next;
			}else if(head2.value < head1.value){
				head2 = head2.next;
			}else {
				System.out.println(head1.value + " ");
				head1 = head1.next;
				head2 = head2.next;
			}
		}
		System.out.println();
	}
}
