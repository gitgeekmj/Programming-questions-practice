package com.program.part6;

import java.util.ArrayList;

public class tree10 {
	public static void main(String[] args) {
		TreeNode A1 = new TreeNode(1);
		TreeNode A2 = new TreeNode(2);
		TreeNode A3 = new TreeNode(3);
		TreeNode A4 = new TreeNode(4);
		TreeNode A5 = new TreeNode(5);
		TreeNode A6 = new TreeNode(6);
		A4.left = A2;
		A2.left = A6;
		A2.right = A3;
		A4.right = A1;
		A1.left = A5;
		tree10 tr = new tree10();
		System.out.println(tr.findError(A4));
	}
    public int[] findError(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int[] num = new int[2];
        int j = 0;
        midOrder(root,arr);
        for(int i = 0; i < arr.size() - 1; i++){
        	if(arr.get(i) > arr.get(i+1)){
        		num[1] = arr.get(i+1);
        		if(j == 0){
        			num[0] = arr.get(i);
        		}
        		j++;
        	}
        }
        int temp = num[0];
        num[0] = num[1];
        num[1] = temp;
        return num;
    }
    public void midOrder(TreeNode root,ArrayList<Integer> arr){
    	if(root == null){
    		return;
    	}
    	midOrder(root.left,arr);
    	arr.add(root.val);
    	midOrder(root.right,arr);
    }
}
