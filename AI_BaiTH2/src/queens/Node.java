package queens;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private int n;
	private List<Integer> state;
	private List<Node> neighbours;
	private Node parent;

	public Node(int n) {
		this.n = n;
		this.state = new ArrayList<>();
		this.neighbours = new ArrayList<>();
	}

	public Node(int n, List<Integer> state) {
		this.n = n;
		this.state = state;
		this.neighbours = new ArrayList<>();
	}

	// add neighbour
	public void addNeighbour(Node neighbourNode) {
		this.neighbours.add(neighbourNode);
	}

	public int getN() {
		return n;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public void setN(int n) {
		this.n = n;
	}

	public List<Integer> getState() {
		return state;
	}

	public void setState(List<Integer> state) {
		this.state = state;
	}

	public void setNeighbours(List<Node> neighbours) {
		this.neighbours = neighbours;
	}

	public boolean isValid(List<Integer> state) {
		int last = state.get(state.size() - 1);
		if (state.size() == 1) {
			return true;
		} else if (state.size() > 1) {
			for (int i = 0; i < state.size() - 1; i++) {
				// kiểm tra xung đột hàng ngang
				if (state.get(i) == last) {
					return false;
				}
				// kiểm tra xung đột đường chéo
				if (Math.abs(i - (state.size() - 1)) == Math.abs(state.get(i) - last)) {
					return false;
				}
			}
			// kiểm tra xung đột queen đầu với queen cuối
			if (Math.abs(state.get(0) - last) == state.size() - 1) {
				return false;
			}
		}
		return true;
	}

	private List<Integer> place(int x) {
		List<Integer> newState = new ArrayList<>(state);
		newState.add(x);
		if (isValid(newState)) {
			return newState;
		} else {
			return null;
		}
	}

	public List<Node> getNeighbours() {
		List<Node> neighbours = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			List<Integer> newState = place(i);
			if (newState != null) {
				Node neighbourNode = new Node(n, newState);
				neighbours.add(neighbourNode);
			}
		}
		return neighbours;
	}
}