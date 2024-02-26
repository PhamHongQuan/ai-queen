package BFS;

public class Test {
	public static void main(String[] args) {

		Node node10 = new Node(10);
		Node node20 = new Node(20);
		Node node30 = new Node(30);
		Node node40 = new Node(40);
		Node node50 = new Node(50);
		Node node60 = new Node(60);
		Node node70 = new Node(70);

		node10.addNeighbour(node30);
		node20.addNeighbour(node10);
		node20.addNeighbour(node30);
		node20.addNeighbour(node50);
		node20.addNeighbour(node60);
		node30.addNeighbour(node60);
		node40.addNeighbour(node10);
		node40.addNeighbour(node20);
		node50.addNeighbour(node70);
		node60.addNeighbour(node70);

		BFS bfsExample = new BFS();
//		bfsExample.bfsUsingQueue(node40, 70);
		
		DFS dfs = new DFS();
		dfs.dfsUsingStack(node40, 70);
	}
}
