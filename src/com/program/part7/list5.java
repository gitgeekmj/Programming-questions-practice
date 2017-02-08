package com.program.part7;

import java.util.ArrayList;

public class list5 {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		ListNode l7 = new ListNode(7);
		ListNode l8 = new ListNode(8);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		l7.next = l8;
		list5 list = new list5();
		list.inverse(l1, 3);
	}
    public ListNode inverse(ListNode head, int k) {
        if(head == null){
        	return null;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
        	arr.add(temp.val);
        	temp = temp.next;
        }
        temp = head;
        int pre = 0;
        int last = 0;
        int i = 1;
        while(last < arr.size()){
        	if(i == k){
        		if(arr.size() >= last){
        			backward(arr,pre,last);
        			pre = pre + k;
        			i = 0;
        		}else{
        			return head;
        		}
        	}else{
        		i++;
        		last++;
        	}
        }
        for(int j = 0; j < arr.size(); j++){
        	temp.val = arr.get(j);
        	temp = temp.next;
        }
        return head;
    }
    public void backward(ArrayList<Integer> arr, int begin, int end){
    	if(arr == null){
    		return;
    	}
    	while(begin != end){
    		int temp = arr.get(begin);
    		arr.set(begin, arr.get(end));
    		arr.set(end, temp);
    		begin++;
    		if(begin == end){
    			break;
    		}
    		end--;
    	}
    }
}
