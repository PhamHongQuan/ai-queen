package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFS {
	public void dfsUsingStack(Node initial, int goal) {
		Stack<Node> stack = new Stack<>();
		initial.setVisited(true);
		stack.push(initial);
		while (!stack.isEmpty()) {
			Node p = stack.pop();
			for (int i = 0; i < p.neighbours.size(); i++) {
				if (!p.neighbours.get(i).isVisited()) {
					p.neighbours.get(i).setVisited(true);
					p.neighbours.get(i).setParent(p);
					Node node = p.neighbours.get(i);
					if (node.getState() == goal) {
						String s = "";
						while (node != initial) {
							s = node.state + " " + s;
							node = node.parent;
						}
						System.out.println("Path: " + initial.state + " " + s);
						return;
					} else {
						stack.push(p.neighbours.get(i));
					}
				}
			}
		}
	}

}
