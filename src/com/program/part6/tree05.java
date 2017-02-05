package com.program.part6;

public class tree05 {
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
		tree05 tr = new tree05();
		System.out.println(tr.check(A1));
	}
    public boolean check(TreeNode root) {
        boolean[] boo = new boolean[1];
        boo[0] = true;
        getHeight(root,0,boo);
        return boo[0];
    }
    public int getHeight(TreeNode root,int level,boolean[] boo){
    	if(root == null){
    		return level;
    	}
    	int lH = getHeight(root.left,level + 1,boo);
    	if(!boo[0]){
    		return level;
    	}
    	int rH = getHeight(root.right,level + 1,boo);
    	if(!boo[0]){
    		return level;
    	}
    	if(Math.abs(rH-lH) > 1){
    		boo[0] = false;
    	}
    	return Math.max(rH, lH);
    }
}
