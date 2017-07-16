package com.example.arithmetic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

class UndirectedGraphNode {
	int label;
	ArrayList<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
};

public class Solution {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return null;

		LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

		UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);

		queue.add(node);
		map.put(node, newHead);

		while (!queue.isEmpty()) {
			UndirectedGraphNode curr = queue.pop();
			ArrayList<UndirectedGraphNode> currNeighbors = curr.neighbors;

			for (UndirectedGraphNode aNeighbor : currNeighbors) {
				if (!map.containsKey(aNeighbor)) {
					UndirectedGraphNode copy = new UndirectedGraphNode(
							aNeighbor.label);
					map.put(aNeighbor, copy);
					map.get(curr).neighbors.add(copy);
					queue.add(aNeighbor);
				} else {
					map.get(curr).neighbors.add(map.get(aNeighbor));
				}
			}

		}
		return newHead;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		UndirectedGraphNode node = new UndirectedGraphNode(1000);
		node.neighbors = new ArrayList<UndirectedGraphNode>();
		node.neighbors.add(node);
		node.neighbors.add(node);
		node.neighbors.add(node);
		UndirectedGraphNode cloneGraph = solution.cloneGraph(node);
		System.out.println(cloneGraph.label);
		System.out.println(cloneGraph.neighbors);
		System.out.println(cloneGraph.neighbors.get(0).neighbors.get(0).label);
	}
}