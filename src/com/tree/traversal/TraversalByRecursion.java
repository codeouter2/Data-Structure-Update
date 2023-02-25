package com.tree.traversal;
import com.representation.of.tree.in.java.SampleTree;
import com.tree.structure.Node;

// For All = T.C = O(n) and S.C = O(n)
public class TraversalByRecursion {

	public static void main(String[] args) {
		Node node = SampleTree.createNode();
		// DFS - Depth First Search
		preOrder(node);
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
	public static void preOrder(Node node) {
		if(node == null) {
			return;
		}
		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
	}
}
