package queens;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	public Node bfsUsingQueue(Node initial, int goal) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(initial);
		while (!queue.isEmpty()) {
			Node p = queue.poll();
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
					queue.offer(node);
				}
			}
		}
		System.out.println("No solution found.");
		return null;
	}
}