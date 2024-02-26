package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	public void bfsUsingQueue(Node initial, int goal) {
		Queue<Node> queue = new LinkedList<>();
		initial.setVisited(true);
		queue.offer(initial);
		while (!queue.isEmpty()) {
			Node p = queue.poll();
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
						queue.offer(p.neighbours.get(i));
					}
				}
			}
		}
	}

}
