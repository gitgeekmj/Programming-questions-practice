package com.program.part5;

import java.util.ArrayList;

public class string2 {
	public static void main(String[] args) {
		TreeNode A1 = new TreeNode(1);
		TreeNode A2 = new TreeNode(2);
		TreeNode A3 = new TreeNode(3);
		TreeNode A4 = new TreeNode(4);
		TreeNode A5 = new TreeNode(5);
		TreeNode A6 = new TreeNode(6);
		TreeNode A7 = new TreeNode(7);
		TreeNode A8 = new TreeNode(8);
		TreeNode A9 = new TreeNode(9);
		A1.left = A2;
		A2.left = A4;
		A4.left = A8;
		A2.right = A5;
		A5.right = A9;
		A1.right = A3;
		A3.left = A6;
		A3.right = A7;
		TreeNode B2 = new TreeNode(1);
		TreeNode B4 = new TreeNode(4);
		TreeNode B5 = new TreeNode(5);
		TreeNode B8 = new TreeNode(8);
		TreeNode B9 = new TreeNode(9);
		B2.left = B4;
		B4.left = B8;
		B2.right = B5;
		B5.right = B9;
		System.out.println(chkIdentical(A1,B2));
	}
    public static boolean chkIdentical(TreeNode A, TreeNode B) {
        ArrayList<TreeNode> arr1 = new ArrayList<TreeNode>();
        ArrayList<TreeNode> arr2 = new ArrayList<TreeNode>();
        preOrderRecur(A,arr1);
        preOrderRecur(B,arr2);
        int[] tn1 = new int[arr1.size()];
        int[] tn2 = new int[arr2.size()];
        for(int i = 0; i < tn1.length; i++){
        	tn1[i] = arr1.get(i).val;
        }
        for(int i = 0; i < tn2.length; i++){
        	tn2[i] = arr2.get(i).val;
        }
        int i = 0;
        int j = 0;
        boolean tn = false;
        while(i < tn1.length){
        	if(j < tn2.length && tn1[i] == tn2[j]){
        		while(j < tn2.length){
        			if(i >= tn1.length){
        				return false;
        			}
        			if(tn1[i] == tn2[j]){
        				tn = true;
        				i++;
        				j++;
        			}else{
        				j = 0;
        				break;
        			}
        		}
        	}
        	i++;
        }
    	return tn;
    }
    public static void preOrderRecur(TreeNode head,ArrayList<TreeNode> arr){
    	if(head == null){
    		return;
    	}
    	arr.add(head);
    	preOrderRecur(head.left,arr);
    	preOrderRecur(head.right,arr);
    }
    /*
     *     
	public boolean chkIdentical(TreeNode A, TreeNode B) {
        // write code here
        String t1Str = serialByPre(A);
        String t2Str = serialByPre(B);
        return t1Str.contains(t2Str);
    }
     private static String serialByPre(TreeNode head) {
        if(head == null){
            return "#!";
        }
          
        String res = head.val + "!";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }
     */
}
