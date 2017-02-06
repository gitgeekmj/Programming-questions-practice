package com.program.part6;

public class tree11 {
	/**
	 * 二叉树节点间最大距离
	 * @param args
	 */
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
		tree11 tr = new tree11();
		System.out.println(tr.findLongest(A3));
	}
    public int findLongest(TreeNode root) {
        int[] re = new int[1];
        return posOrder(root,re);
    }
    public int posOrder(TreeNode head,int[] record){
    	if(head == null){
    		record[0] = 0;
    		return 0;
    	}
    	int lMax = posOrder(head.left,record);
    	int maxfromLeft = record[0];
    	int rMax = posOrder(head.right,record);
    	int maxfromRight = record[0];
    	int curNodeMax = maxfromLeft + maxfromRight + 1;
    	record[0] = Math.max(maxfromLeft, maxfromRight) + 1;
    	return Math.max(Math.max(lMax, rMax), curNodeMax);
    }
}
