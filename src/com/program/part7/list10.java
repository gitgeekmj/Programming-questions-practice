package com.program.part7;

import java.util.HashMap;

public class list10 {
	/**
	 * 判断两个无环链表是否相交
	 * 下方为不省空间的做法
	 * 空间复杂度为O(1)的方法为   统计两个链表的长度，让长链表先遍历到两个链表剩余部分一样长时，同时遍历两个链表，节点一旦相等，意味着相交
	 * @param headA
	 * @param headB
	 * @return
	 */
    public boolean chkIntersect(ListNode headA, ListNode headB) {
        HashMap<ListNode,Integer> hm = new HashMap<>();
        int i = 0;
        while(headA != null){
        	hm.put(headA, i);
        	i++;
        	headA = headA.next;
        }
        while(headB != null){
        	if(hm.containsKey(headB)){
        		return true;
        	}else{
        		headB = headB.next;
        	}
        }
        return false;
    }
}
