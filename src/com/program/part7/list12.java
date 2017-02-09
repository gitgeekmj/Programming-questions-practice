package com.program.part7;

import java.util.HashMap;

public class list12 {
	/**
	 * 无论是否有环  判断是否相交
	 * @param head1
	 * @param head2
	 * @param adjust0
	 * @param adjust1
	 * @return
	 */
    public boolean chkInter(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        HashMap<ListNode,Integer> hm = new HashMap<>();
        HashMap<ListNode,Integer> hm2 = new HashMap<>();
        int i = 0;
        while(head1 != null){
        	if(hm.containsKey(head1)){
        		break;
        	}
        	hm.put(head1, i);
        	i++;
        	head1 = head1.next;
        }
        i = 0;
        while(head2 != null){
        	if(hm.containsKey(head2)){
        		return true;
        	}
        	if(hm2.containsKey(head2)){
        		break;
        	}
        	hm2.put(head2, i);
        	i++;
        	head2 = head2.next;
        }
        return false;
    }
}
