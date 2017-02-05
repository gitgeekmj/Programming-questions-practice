package com.program.part6;

import java.util.ArrayList;
import java.util.Stack;

public class tree02 {
    public int[][] convert(TreeNode root) {
    	ArrayList<Integer> arr = new ArrayList<Integer>();
    	if(root != null){
    		Stack<TreeNode> st = new Stack<TreeNode>();
    		st.push(root);
    		while(!st.isEmpty()){
    			root = st.pop();
    			arr.add(root.val);
    			if(root.right != null){
    				st.push(root.right);
    			}
    			if(root.left != null){
    				st.push(root.left);
    			}
    		}
    	}
    	int[][] a = new int[3][arr.size()];
    	for(int i = 0; i < arr.size(); i++){
    		a[0][i] = arr.get(i);
    	}
    	return a;
    }
}
