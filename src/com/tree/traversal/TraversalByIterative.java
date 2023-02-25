package com.tree.traversal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.representation.of.tree.in.java.SampleTree;
import com.tree.structure.Node;

// For All = T.C = O(n) and S.C = O(n)
public class TraversalByIterative {

	public static void main(String[] args) {
		Node node = SampleTree.createNode();
		// DFS - Depth First Search
		List<Integer> preorder = preOrder(node);
		for (Integer ele : preorder) {
			System.out.print(ele + " ");
		}
		System.out.println(" ");
		postOrder(node);
		System.out.println(" ");
		inOrder(node);
		System.out.println(" ");
	}
	
	// Left -> Root -> Right
	private static void inOrder(Node node) {
		if(node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.data + " ");
		inOrder(node.right);
	}

	// Left -> Right -> Root
	private static void postOrder(Node node) {
		if(node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data + " ");
	}

	// Root -> Left -> Right
	public static List<Integer> preOrder(Node node) {
		// Use Stack for storing node's 
		// Note : store first right then store left node in stack
		
		List<Integer> preOrder = new ArrayList<>();
		Stack<Node> stack = new Stack<>();
		stack.add(node);
		while(!stack.isEmpty()) {
			node = stack.pop();
			preOrder.add(node.data);
			if(node.right != null) {
				stack.push(node.right);
			}
			if(node.left != null) {
				stack.push(node.left);
			}
		}
		return preOrder;
	}
}
