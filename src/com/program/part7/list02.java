package com.program.part7;

public class list02 {
    public boolean removeNode(ListNode pNode) {
        if(pNode.next == null || pNode == null){
        	return false;
        }
        while(pNode != null){
        	pNode.val = pNode.next.val;
        	if(pNode.val == pNode.next.val && pNode.next.next == null){
        		pNode.next = null;
        		break;
        	}
        	pNode = pNode.next;
        }
        return true;
    }
    public boolean removeNode2(ListNode pNode){
    	if(pNode.next == null || pNode == null){
        	return false;
        }
    	pNode.val = pNode.next.val;
    	pNode.next = pNode.next.next;
    	return true;
    }
}
