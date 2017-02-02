package com.program.part5;

import java.util.ArrayList;

public class string2 {
	public static void main(String[] args) {
		TreeNode A1 = new TreeNode(1);
		TreeNode A2 = new TreeNode(2);
		TreeNode A3 = new TreeNode(3);
		TreeNode A4 = new TreeNode(4);
		TreeNode A5 = new TreeNode(5);
		TreeNode A6 = new TreeNode(6);
		TreeNode A7 = new TreeNode(7);
		TreeNode A8 = new TreeNode(8);
		TreeNode A9 = new TreeNode(9);
		A1.left = A2;
		A2.left = A4;
		A4.left = A8;
		A2.right = A5;
		A5.right = A9;
		A1.right = A3;
		A3.left = A6;
		A3.right = A7;
		TreeNode B2 = new TreeNode(2);
		TreeNode B4 = new TreeNode(4);
		TreeNode B5 = new TreeNode(5);
		TreeNode B8 = new TreeNode(8);
		TreeNode B9 = new TreeNode(9);
		B2.left = B4;
		B4.left = B8;
		B2.right = B5;
		B5.right = B9;
		System.out.println(chkIdentical(A1, B2));
		System.out.println(HasSubtree(A1, B2));
	}
	/**
	 * 
	 * @param A
	 * @param B
	 * @return
	 * chkIdentical为严格判断二叉树子树型方法
	 */
	public static boolean chkIdentical(TreeNode A, TreeNode B) {
		String t1Str = serialByPre(A);
		String t2Str = serialByPre(B);
		return t1Str.contains(t2Str);
	}

	private static String serialByPre(TreeNode head) {
		if (head == null) {
			return " ";
		}
		String res = head.val + "";
		res += serialByPre(head.left);
		res += serialByPre(head.right);
		return res;
	}
	/**
	 * 
	 * @param root1
	 * @param root2
	 * @return
	 * HasSubtree为判断二叉树子结构方法   只能按部就班
	 */
	public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
		if(root1 == null || root2 == null){
			return false;
		}
		return isSubTree(root1,root2) || HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
	}
	public static boolean isSubTree(TreeNode root1,TreeNode root2){
		if(root2 == null){
			return true;
		}
		if(root1 == null){
			return false;
		}
		if(root2.val == root1.val){
			return isSubTree(root1.left,root2.left) && isSubTree(root1.right,root2.right);
		}else{
			return false;
		}
	}

}
