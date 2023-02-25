package com.tree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.representation.of.tree.in.java.SampleTree;
import com.tree.structure.Node;

//For All = T.C = O(n) and S.C = O(n)
public class LevelOrderTraversal {

	public static void main(String[] args) {
		Node node = SampleTree.createNode();
		// BFS - Breadth First Search
		List<List<Integer>> print = levelOrder(node);
		for (List<Integer> list : print) {
			System.out.print(list + " ");
		}
	}
	
	private static List<List<Integer>> levelOrder(Node node) {
		
		// Maintain two structure - Queue & ArrayList
		// Queue is for storing node's data if it exists
		// ArrayList is for storing level wise nodes together
		
		Queue<Node> queue = new LinkedList<>();
		List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
		if(node == null)
			return wrapList;
		queue.offer(node);
		while(!queue.isEmpty()) {
			int levelNum = queue.size();
			List<Integer> subList = new ArrayList<>();
			for(int i=0;i<levelNum;i++) {
				if(queue.peek().left != null) {
					queue.offer(queue.peek().left);
				}
				if(queue.peek().right != null) {
					queue.offer(queue.peek().right);
				}
				subList.add(queue.poll().data);
			}
			wrapList.add(subList);
		}
		return wrapList;
	}

}
