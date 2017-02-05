package com.program.part6;

import java.util.LinkedList;

public class tree8 {
	/**
	 * 完全二叉树的判断
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode A1 = new TreeNode(1);
		TreeNode A2 = new TreeNode(2);
		TreeNode A3 = new TreeNode(3);
		TreeNode A4 = new TreeNode(4);
		TreeNode A5 = new TreeNode(5);
		TreeNode A6 = new TreeNode(6);
		A1.left = A2;
		A2.left = A3;
		A3.left = A4;
		A1.right = A5;
		A5.left = A6;
		tree8 tr = new tree8();
		System.out.println(tr.chk(A1));
	}
    public boolean chk(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode last = root;
        TreeNode nlast = null;
        boolean boo = true;
        queue.add(last);
        while(!queue.isEmpty()){
        	root = queue.poll();
        	if(root.left == null && root.right != null){
        		return boo = false;
        	}else if(root.left != null && root.right == null){
        		TreeNode temp = root;
        		while(root != null){
        			if(root.right != null){
        				return boo = false;
        			}
        			root = root.left;
        		}
        		root = temp;
        		queue.add(root.left);
        		nlast = root.left;
        	}else if(root.left != null && root.right != null){
        		queue.add(root.left);
        		queue.add(root.right);
        		nlast = root.right;
        	}
        	if(last == root){
        		last = nlast;
        	}
        }
        return boo;
    }
}
