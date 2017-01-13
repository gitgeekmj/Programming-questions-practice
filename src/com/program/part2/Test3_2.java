package com.program.part2;
/**
 * 
 * @author 杰
 * 打印二叉树的边界节点
 * 题目：给定一颗二叉树的头节点head，按照如下两种标准分别实现二叉树边界节点的逆时针打印
 * 标准一：
 * 1.头节点为边界节点。
 * 2.叶节点为边界节点。
 * 3.如果节点在其所在的层中是最左或最右的，那么也是边界节点。
 * 标准二：
 * 1.头节点为边界节点
 * 2.叶节点为边界节点
 * 3.树左边界延伸下去的路径为边界节点
 * 4.树右边届延伸下去的路径为边界节点
 * 要求：
 * 1.如果节点数为N，两种标准实现的时间复杂度要求都为O(N)，额外空间复杂度要求为O(h),
 * h为二叉树的高度。
 * 2.两种标准都要求逆时针顺序且不重复打印所有的边界节点
 */
public class Test3_2 {
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node9 = new Node(9);
		Node node10 = new Node(10);
		Node node11 = new Node(11);
		Node node12 = new Node(12);
		Node node13 = new Node(13);
		Node node14 = new Node(14);
		Node node15 = new Node(15);
		Node node16 = new Node(16);
		node1.left = node2;
		node1.right = node3;
		node2.right = node4;
		node4.left = node7;
		node4.right = node8;
		node8.right = node11;
		node11.left = node13;
		node11.right = node14;
		node3.left = node5;
		node3.right = node6;
		node5.left = node9;
		node5.right = node10;
		node9.left = node12;
		node12.left = node15;
		node12.right = node16;
		printEdge1(node1);
	}
	public static void printEdge1(Node head){
		if(head == null){
			return;
		}
		int height = getHeight(head,0);
		System.out.println("height= " + height);
		Node[][] edgeMap = new Node[height][2];
		setEdgeMap(head,0,edgeMap);
		//打印左边界
		for(int i = 0; i != edgeMap.length; i++){
			System.out.println(edgeMap[i][0].value + " ");
		}
		//打印既不是左边界，也不是右边界的叶子节点
		printLeafNotInMap(head, 0, edgeMap);
		//打印右边界，但不是左边界的节点
		for(int i = edgeMap.length - 1; i != -1; i--){
			if(edgeMap[i][0] != edgeMap[i][1]){
				System.out.println(edgeMap[i][1].value + " ");
			}
		}
		System.out.println();
	}

	private static int getHeight(Node h, int i) {
		if(h == null){
			return i;
		}
		return Math.max(getHeight(h.left, i + 1), getHeight(h.right, i + 1));
	}

	private static void setEdgeMap(Node h, int i, Node[][] edgeMap) {
		if(h == null){
			return;
		}
		edgeMap[i][0] = edgeMap[i][0] == null ? h : edgeMap[i][0];
		System.out.println("edgeMap["+i+"][0]="+edgeMap[i][0].value);
		edgeMap[i][1] = h;
		System.out.println("edgeMap["+i+"][1]="+edgeMap[i][1].value);
		setEdgeMap(h.left,i+1,edgeMap);
		setEdgeMap(h.right,i+1,edgeMap);
	}
	
	private static void printLeafNotInMap(Node h, int i, Node[][] m) {
		if(h == null){
			return;
		}
		if(h.left == null && h.right == null && h != m[i][0] && h != m[i][1]){
			System.out.println(h.value + " ");
		}
		printLeafNotInMap(h.left,i+1,m);
		printLeafNotInMap(h.right,i+1,m);
	}

}
