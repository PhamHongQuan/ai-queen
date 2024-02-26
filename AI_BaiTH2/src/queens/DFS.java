package queens;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFS {

	public Node dfsUsingStack(Node initial, int goal) {
		Stack<Node> stack = new Stack<>();
		stack.push(initial);
		while (!stack.isEmpty()) {
			Node p = stack.pop();
			for (int i = 0; i < p.getNeighbours().size(); i++) {
				Node node = p.getNeighbours().get(i);
				p.addNeighbour(node);
				if (node.getState().size() == goal) {
					String s = "";
					while (node != null) {
						p.addNeighbour(node);
						s = node.getState() + " " + s;
						node = node.getParent();
					}
					System.out.println("Path: " + s);
					return node;
				} else {
					stack.push(node);
				}
			}
		}
		System.out.println("No solution found.");
		return null;
	}

}
