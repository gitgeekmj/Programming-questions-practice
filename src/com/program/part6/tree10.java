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
		A3.left = A2;
		A2.left = A1;
		A2.right = A4;
		A3.right = A6;
		A6.left = A5;
		tree10 tr = new tree10();
		System.out.println(tr.findError(A3));
	}
    public int[] findError(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int[] num = new int[2];
        int j = 1;
        int temp = 0;
        midOrder(root,arr);
        for(int i = 0; i < arr.size() - 1; i++){
        	if(arr.get(i) > arr.get(i+1)){
        		if(j == 1){
        			num[1] = arr.get(i);
        			temp = i;
        		}
        		if(j == 2){
        			num[0] = arr.get(i+1);
        		}
        		j++;
        	}
        }
        if(j == 2){
        	num[0] = arr.get(temp+1);
        }
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
