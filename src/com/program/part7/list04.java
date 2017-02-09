package com.program.part7;

import java.util.ArrayList;

public class list04 {
    public int[] findCommonParts(ListNode headA, ListNode headB) {
    	if(headA == null || headB == null){
    		return null;
    	}
        ArrayList<Integer> arr = new ArrayList<>();
    	while(headA != null && headB != null){
    		if(headA.val == headB.val){
    			arr.add(headA.val);
    			headA = headA.next;
    			headB = headB.next;
    		}else if(headA.val < headB.val){
    			headA = headA.next;
    		}else{
    			headB = headB.next;
    		}
    	}
    	int[] record = new int[arr.size()];
    	for(int i = 0; i < arr.size(); i++){
    		record[i] = arr.get(i);
    	}
    	return record;
    }
}
