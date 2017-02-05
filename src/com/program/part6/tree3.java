package com.program.part6;

import java.util.ArrayList;
import java.util.LinkedList;

public class tree3 {
    public int[][] printTree(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> arr2 = new ArrayList<ArrayList<Integer>>();
        TreeNode last = root;
        TreeNode nlast = null;
        q.add(last);
        while(!q.isEmpty()){
        	root = q.poll();
        	arr1.add(root.val);
        	if(root.left != null){
        		q.add(root.left);
        		nlast = root.left;
        	}
        	if(root.right != null){
        		q.add(root.right);
        		nlast = root.right;
        	}
        	if(last == root){
        		last = nlast;
        		arr2.add(arr1);
        		arr1 = new ArrayList<Integer>();
        	}
        	
        }
        int[][] result = new int[arr2.size()][];
        for(int i = 0; i < arr2.size(); i++){
        	arr1 = arr2.get(i);
        	result[i] = new int[arr1.size()];
        	for(int j = 0; j < arr1.size(); j++){
        		result[i][j] = arr1.get(j);
        	}
        }
        return result;
    }
}
