package com.program.part7;

public class list1 {
	public static void main(String[] args) {
		int[] A = {1,3,4,5,7};
		int[] nxt = {1,2,3,4,0};
		list1 list = new list1();
		list.insert2(A,nxt,2);
	}
	/**
	 * 环形链表插入
	 * @param A
	 * @param nxt
	 * @param val
	 * @return
	 */
    public ListNode insert(int[] A, int[] nxt, int val) {
    	ListNode ins = new ListNode(val);
    	if(A == null || A.length == 0){
    		ins.next = ins;
    		return ins;
    	}
    	ListNode list = new ListNode(A[0]);
    	ListNode head = list;
    	for(int i = 0; i < nxt.length - 1; i++){
    		list.next = new ListNode(A[nxt[i]]);
    		list = list.next;
    	}
    	list.next = head;
    	ListNode temp = head;
    	if(ins.val > list.val){
    		list.next = ins;
    		ins.next = head;
    		return head;
    	}
    	for(int i = 0; i < nxt.length; i++){
    		if(ins.val <= head.val){
    			list.next = ins;
    			ins.next = head;
    			break;
    		}
    		list = head;
    		head = head.next;
    	}
    	head = temp;
        return head.val > ins.val ? ins : head;
    }
    /**
     * 单链表插入
     * @param A
     * @param nxt
     * @param val
     * @return
     */
    public ListNode insert2(int[] A, int[] nxt, int val) {
        if(A==null||A.length==0){
            return new ListNode(val);
        }
        ListNode head = new ListNode(A[0]);
        ListNode p = head;
        ListNode r = null;
        for(int i=0;i<A.length-1;i++){
            r = new ListNode(A[nxt[i]]);
            p.next = r;
            p = r;
        }
           
        ListNode pre = head;
        ListNode next = head.next;
        while(next!=null){
            if(val>=pre.val&&val<=next.val)
                break;
            pre = next;
            next = next.next;
        }
          
        ListNode newNode = new ListNode(val);
        newNode.next = next;
        pre.next = newNode;
           
        if(val<head.val){
            return newNode;
        }else{
            return head;
        }
     }
}
