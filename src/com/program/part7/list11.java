package com.program.part7;

import java.util.HashMap;

public class list11 {
	/**
	 * 判断两个有环链表是否相交
	 * @param head1
	 * @param head2
	 * @param adjust0
	 * @param adjust1
	 * @return
	 */
    public boolean chkInter(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        if(chkLoop(head1) == false || chkLoop(head2) == false){
        	return false;
        }
        if(chkIntersect(head1,head2) != null){
        	return true;
        }else{
        	return false;
        }
    }
    /**
     * 判断是否有环
     * @param head
     * @return
     */
    public boolean chkLoop(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				fast = head;
				while (fast != slow) {
					fast = fast.next;
					slow = slow.next;
				}
				return true;
			}
		}
            return false;
    }
    /**
     * 判断是否相交
     * @param headA
     * @param headB
     * @return
     */
    public ListNode chkIntersect(ListNode headA, ListNode headB) {
        HashMap<ListNode,Integer> hm = new HashMap<>();
        HashMap<ListNode,Integer> hm2 = new HashMap<>();
        int i = 0;
        while(headA != null){
        	if(hm.containsKey(headA)){
        		break;
        	}
        	hm.put(headA, i);
        	i++;
        	headA = headA.next;
        }
        i = 0;
        while(headB != null){
        	if(hm.containsKey(headB)){
        		return headB;
        	}
        	if(hm2.containsKey(headB)){
        		break;
        	}
        	hm2.put(headB, i);
        	i++;
        	headB = headB.next;
        }
        return null;
    }
}
