package com.program.part7;

public class list9 {
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
		int[] record = {4,6,7,8,4,13,17,21,22,26,28,31,35,39,41,42,46,50,54,59,60,65,67,71,74,76,78,83,85,86,87,88,93,98,102,106,108,110,111,116,119,123,125,126,129,132,136,137,140,144,146,151,155,156,157,159,164,165,169,172,177,178,183,186,190,193,194,198,203,205,207,210,214,218,221,226,227,231,232,237,239,244,246,251,253,255,260,264,268,270,271,275,279,282,284,286,290,292,293,296,300,301,303,304,307,309,314,315,317,318,320,324,328,332,333,337,340,342,345,347,351,356,357,361,365,369,372,377,381,384,386,391,396,398,401,404,407,412,417,419,424,426,427,429,431,433,435,440,443,445,449,453,455,457,462,465,466,469,473,475,480,482,487,492,496,499,504,507,510,513,514,516,519,524,525,526,529,534,538,542,546,547,551,552,553,558,562,563,564,567,568,571,576,579,581,586,587,590,593,596,600,602,607,611,613,618,621,624,628,631,636,638,639,641,643,648,650,653,657,658,661,666,670,674,675,676,680,682,685};
		list9 list = new list9();
		ListNode head = list.creatList(record);
		System.out.println(list.chkLoop(head, 1));
	}
    public int chkLoop(ListNode head, int adjust) {
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(fast != null && fast.next != null){
        	if(slow != fast){
        		slow = slow.next;
        		fast = fast.next.next;
        	}else{
        		fast = head;
        		while(fast != slow){
        			fast = fast.next;
        			slow = slow.next;
        		}
        		return fast.val;
        	}
        }
        return -1;
    }
    public int chkLoop2(ListNode head, int adjust) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
            fast = head;
        	while(fast!=slow){
            fast = fast.next;
            slow = slow.next;
        	}
        	return fast.val;
            }
        }
            return -1;

    }
    public ListNode creatList(int[] A) {
        if(A==null||A.length==0){
            return null;
        }
        ListNode head = new ListNode(A[0]);
        ListNode p = head;
        ListNode r = null;
        for(int i=0;i<A.length-1;i++){
            r = new ListNode(A[i]);
            p.next = r;
            p = r;
        }
        return head.next;
    }
}
