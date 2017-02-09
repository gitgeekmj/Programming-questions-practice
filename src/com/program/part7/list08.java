package com.program.part7;

public class list08 {
	public static void main(String[] args) {
		RandomListNode l1 = new RandomListNode(1);
		RandomListNode l2 = new RandomListNode(2);
		RandomListNode l3 = new RandomListNode(3);
		RandomListNode l4 = new RandomListNode(4);
		RandomListNode l5 = new RandomListNode(5);
		RandomListNode l6 = new RandomListNode(6);
		RandomListNode l7 = new RandomListNode(7);
		RandomListNode l8 = new RandomListNode(8);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		l7.next = l8;
		l1.random = l5;
		l3.random = l8;
		l5.random = l1;
		list08 list = new list08();
		list.Clone(l1);
	}
    public RandomListNode Clone(RandomListNode pHead){
    	if(pHead == null){
    		return null;
    	}
    	RandomListNode ran1 = new RandomListNode(0);
    	RandomListNode ran2 = ran1;
    	RandomListNode list = pHead;
    	while(list != null){
    		ran1.next = new RandomListNode(list.label);
    		ran1 = ran1.next;
    		list = list.next;
    	}
    	ran1 = ran2;
    	while(pHead != null){
    		ran1.next.random = pHead.random;
    		ran1 = ran1.next;
    		pHead = pHead.next;
    	}
    	return ran2.next;
    }
}
