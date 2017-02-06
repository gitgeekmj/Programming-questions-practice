package com.program.part6;

import java.util.ArrayList;
import java.util.Stack;

public class tree12 {
	/**
	 * 找最大搜索二叉子树
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode A0 = new TreeNode(0);
		TreeNode A1 = new TreeNode(1);
		TreeNode A2 = new TreeNode(2);
		TreeNode A3 = new TreeNode(3);
		TreeNode A4 = new TreeNode(4);
		TreeNode A5 = new TreeNode(5);
		TreeNode A6 = new TreeNode(6);
		TreeNode A16 = new TreeNode(16);
		TreeNode A20 = new TreeNode(20);
		TreeNode A10 = new TreeNode(10);
		TreeNode A11 = new TreeNode(11);
		TreeNode A12 = new TreeNode(12);
		TreeNode A13 = new TreeNode(13);
		TreeNode A14 = new TreeNode(14);
		TreeNode A15 = new TreeNode(15);
		A6.left = A1;
		A1.left = A0;
		A1.right = A3;
		A6.right = A12;
		A12.left = A10;
		A12.right = A13;
		A10.left = A4;
		A10.right = A14;
		A4.left = A2;
		A4.right = A5;
		A14.left = A11;
		A14.right = A15;
		A13.left = A20;
		A13.right = A16;
		tree12 tr = new tree12();
		System.out.println(tr.getMax(A6));
	}
    public TreeNode getMax(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.add(root);
        TreeNode goal = null;
        int max = 0;
        while(!s.isEmpty()){
        	root = s.pop();
        	midOrder(root,arr);
        	boolean boo = tree(arr);
        	if(arr.size() > max && boo){
        		max = arr.size();
        		goal = root;
        		arr.clear();
        	}else{
        		arr.clear();
        	}
        	if(root.left != null){
        		s.push(root.left);
        	}
        	if(root.right != null){
        		s.push(root.right);
        	}
        }
        return goal;
    }
    public boolean tree(ArrayList<Integer> arr){
    	for(int i = 0; i < arr.size()-1; i++){
    		if(arr.get(i) > arr.get(i+1)){
    			return false;
    		}
    	}
    	return true;
    }
    public void midOrder(TreeNode root,ArrayList<Integer> arr){
    	if(root == null){
    		return;
    	}
    	midOrder(root.left,arr);
    	arr.add(root.val);
    	midOrder(root.right,arr);
    }
    public TreeNode getMax2(TreeNode root){
    	int[] record = new int[3];
    	return posOrder(root,record);
    }
    public TreeNode posOrder(TreeNode root,int[] record){
    	if(root == null){
    		record[0] = 0;
    		record[1] = 0;
    		record[2] = 0;
    		return null;
    	}
    	int value = root.val;
    	TreeNode left = root.left;
    	TreeNode right = root.right;
    	TreeNode lBst = posOrder(root.left,record);
    	int lSize = record[0];
    	int lMax = record[1];
    	int lMin = record[2];
    	TreeNode rBst = posOrder(root.right,record);
    	int rSize = record[0];
    	int rMax = record[1];
    	int rMin = record[2];
    	record[1] = Math.max(rMax, value);
    	record[2] = Math.min(lMin, value);
    	if(left == lBst && right == rBst && lMax < value && value < rMin){
    		record[0] = lSize + rSize + 1;
    		return root;
    	}
    	record[0] = Math.max(lSize, rSize);
    	return lSize > rSize ? lBst : rBst;
    }
}
