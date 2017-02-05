package com.program.part6;

public class tree04 {
    public String toString(TreeNode root) {
    	if(root == null){
    		return "#!";
    	}
    	String str = root.val + "!";
    	str += toString(root.left);
    	str += toString(root.right);
    	return str;
    }
}
