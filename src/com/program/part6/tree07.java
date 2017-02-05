package com.program.part6;

public class tree07 {
	/**
	 * 满二叉树判断
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode A1 = new TreeNode(1);
		TreeNode A2 = new TreeNode(2);
		TreeNode A3 = new TreeNode(3);
		TreeNode A4 = new TreeNode(4);
		TreeNode A5 = new TreeNode(5);
		TreeNode A6 = new TreeNode(6);
		TreeNode A7 = new TreeNode(7);
		A1.left = A2;
		A2.left = A3;
		A2.right = A4;
		A1.right = A5;
		A5.left = A6;
		A5.right = A7;
		tree07 tr = new tree07();
		System.out.println(tr.chk(A1));
	}
    public boolean chk(TreeNode root) {
        boolean[] boo = new boolean[1];
        boo[0] = true;
        midOrder(root,boo);
        return boo[0];
    }
    public void midOrder(TreeNode root,boolean[] boo){
    	if(root.left == null && root.right == null){
    		return;
    	}else if(root.left != null && root.right != null){
    		midOrder(root.left,boo);
    		midOrder(root.right,boo);
    	}else{
    		boo[0] = false;
    		return;
    	}
    }
}
