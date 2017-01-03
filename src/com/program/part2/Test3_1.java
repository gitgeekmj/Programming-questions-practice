package com.program.part2;

import java.util.Stack;

/**
 * 
 * @author 杰
 * 分别用递归和非递归方式实现二叉树先序、中序和后序遍历
 * 题目：用递归和非递归方式，分别按照二叉树先序、中序和后序打印所有的节点。我们约定：先序遍历顺序为根、左、右；
 * 中序遍历顺序为左、根、右；后序遍历顺序为左、右、根
 */

public class Test3_1 {
	/*
	 * 用递归方式实现三种遍历是基础
	 */
	public void preOrderRecur(Node head){
		if(head == null){
			return;
		}
		System.out.println(head.value + " ");
		preOrderRecur(head.left);
		preOrderRecur(head.right);
	}
	public void inOrderRecur(Node head){
		if(head == null){
			return;
		}
		inOrderRecur(head.left);
		System.out.println(head.value + "　");
		inOrderRecur(head.right);
	}
	public void posOrderRecur(Node head){
		if(head == null){
			return;
		}
		posOrderRecur(head.left);
		posOrderRecur(head.right);
		System.out.println(head.value + " ");
	}
	/*
	 * 用递归方法解决的问题都能用非递归的方法实现。这是因为递归方法无非就是利用函数栈
	 * 来保存信息，如果用自己申请的数据结构来代替函数栈，也可以实现相同的功能
	 */
	/**
	 * 用非递归的方式实现二叉树的先序遍历
	 * 思路：
	 * 1.申请一个新栈，记为stack。然后将头节点head压入stack
	 * 2.从stack中弹出栈顶节点，记为cur，然后打印cur节点的值，再将cur的右孩子
	 * （如果不为空的话）压入stack中，最后将cur的左孩子（不为空的话）压入stack。
	 * 3.不断重复步骤2，直到stack为空，全部过程结束。
	 */
	public void preOrderUnRecur(Node head){
		System.out.println("pre-order: ");
		Stack<Node> stack = new Stack<Node>();
		if(head != null){
			stack.push(head);
			while(!stack.isEmpty()){
				head = stack.pop();
				System.out.println(head.value + " ");
				if(head.right != null){
					stack.push(head.right);
				}
				if(head.left != null){
					stack.push(head.left);
				}
			}
		}
		System.out.println();
	}
	/**
	 * 
	 * @param head
	 * 中序遍历
	 */
	public void inOrderUnrecur(Node head){
		System.out.println("in-order: ");
		Stack<Node> stack = new Stack<Node>();
		if(head != null){
			while(!stack.isEmpty() || head != null){
				if(head != null){
					stack.push(head);
					head = head.left;
				}else{
					head = stack.pop();
					System.out.println(head.value + " ");
					head = head.right;
				}
			}
		}
	}
	/**
	 * 
	 * @param head
	 * 后序遍历较为麻烦
	 * 方法一借助两个栈来实现，栈s1和栈s2
	 * 思路：每颗子树的头节点都最先从s1中弹出，然后把该节点的孩子节点按照先左再右的
	 * 顺序压入s1，那么从s1弹出的顺序就是先右再左，所以从s1中弹出的顺序就是中、右、左
	 * 然后s2重新收集的过程就是把s1的弹出顺序逆序，所以s2从栈顶到栈底的顺序就变成了
	 * 左、右、中。
	 */
	public void posOrderUnRecur1(Node head){
		System.out.println("pos-order: ");
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		if(head != null){
			s1.push(head);
			while(!s1.isEmpty()){
				head = s1.pop();
				s2.push(head);
				if(head.left != null){
					s1.push(head.left);
				}
				if(head.right != null){
					s1.push(head.right);
				}
			}
			while(!s2.isEmpty()){
				System.out.println(s2.pop().value + " ");
			}
		}
		System.out.println();
	}
	public void posOrderUnRecur2(Node head){
		System.out.println("pos-order");
		Stack<Node> stack = new Stack<Node>();
		if(head != null){
			stack.push(head);
			Node c = null;
			while(!stack.isEmpty()){
				c = stack.peek();
				if(c.left != null && head != c.left && head != c.right){
					stack.push(c.left);
				}else if(c.right != null && head != c.right){
					stack.push(c.right);
				}else{
					System.out.println(stack.pop().value + " ");
					head = c;
				}
			}
		}
		System.out.println();
	}
}
