package com.program.part6;

import java.util.ArrayList;

public class tree1 {
	public static void main(String[] args) {
		TreeNode A1 = new TreeNode(132);
		TreeNode A2 = new TreeNode(11);
		TreeNode A3 = new TreeNode(625);
		TreeNode A4 = new TreeNode(225);
		TreeNode A5 = new TreeNode(375);
		TreeNode A6 = new TreeNode(416);
		A1.left = A2;
		A2.left = A3;
		A2.right = A4;
		A1.right = A5;
		A5.left = A6;
		tree1 tr = new tree1();
		tr.convert(A1);
		
	}
    public int[][] convert(TreeNode root) {
    	ArrayList<Integer> len = new ArrayList<Integer>();
    	preOrder(root,len);
        int[][] i = new int[3][len.size()];
        popArray(i,len,0);
        len.clear();
        midOrder(root,len);
        popArray(i,len,1);
        len.clear();
        backOrder(root,len);
        popArray(i,len,2);
        return i;
    }
    public void popArray(int[][] in,ArrayList<Integer> s,int j){
    	for(int i = 0; i < s.size(); i++){
    		in[j][i] = s.get(i);
    	}
    }
    public void preOrder(TreeNode root,ArrayList<Integer> s){
    	if(root == null){
    		return;
    	}
    	s.add(root.val);
    	preOrder(root.left,s);
    	preOrder(root.right,s);
    	
    }
    public void midOrder(TreeNode root,ArrayList<Integer> s){
    	if(root == null){
    		return;
    	}
    	midOrder(root.left,s);
    	s.add(root.val);
    	midOrder(root.right,s);
    }
    public void backOrder(TreeNode root,ArrayList<Integer> s){
    	if(root == null){
    		return;
    	}
    	backOrder(root.left,s);
    	backOrder(root.right,s);
    	s.add(root.val);
    }
}
