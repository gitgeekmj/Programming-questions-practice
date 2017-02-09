package com.program.part7;

import java.util.ArrayList;

public class list07 {
	public static void main(String[] args) {
			ListNode l1 = new ListNode(1);
			ListNode l2 = new ListNode(2);
			ListNode l3 = new ListNode(3);
			ListNode l4 = new ListNode(2);
			ListNode l5 = new ListNode(2);
			ListNode l6 = new ListNode(3);
			ListNode l7 = new ListNode(2);
			ListNode l8 = new ListNode(1);
			l1.next = l2;
			l2.next = l3;
			l3.next = l4;
			l4.next = l5;
			l5.next = l6;
			l6.next = l7;
			l7.next = l8;
			list07 list = new list07();
			list.isPalindrome(l1);
	}
    public boolean isPalindrome(ListNode pHead) {
    	if(pHead == null){
    		return false;
    	}
        ArrayList<Integer> arr = new ArrayList<>();
        while(pHead != null){
        	arr.add(pHead.val);
        	pHead = pHead.next;
        }
        int p0 = 0;
        int pn = arr.size()-1;
        while(p0 != pn){
        	if(arr.get(p0) == arr.get(pn)){
        		p0++;
        		if(p0 == pn){
        			return true;
        		}
        		pn--;
        	}else{
        		return false;
        	}
        }
        return true;
    }
}
