package com.program.part6;

import java.util.ArrayList;

public class tree6 {
	/**
	 * 搜索二叉树判断实现
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode A1 = new TreeNode(4);
		TreeNode A2 = new TreeNode(2);
		TreeNode A3 = new TreeNode(1);
		TreeNode A4 = new TreeNode(3);
		TreeNode A5 = new TreeNode(6);
		TreeNode A6 = new TreeNode(5);
		A1.left = A2;
		A2.left = A3;
		A2.right = A4;
		A1.right = A5;
		A5.left = A6;
		tree6 tr = new tree6();
		System.out.println(tr.chk(A1));
	}
    public boolean chk(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        midOrder(root,arr);
        boolean boo = true;
        for(int i = 0 ; i < arr.size()-1 ; i++){
        	if(arr.get(i) > arr.get(i+1)){
        		boo = false;
        		break;
        	}
        }
        return boo;
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
