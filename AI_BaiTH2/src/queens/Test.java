package queens;

public class Test {
	public static void main(String[] args) {
		Queens q = new Queens(4);
		System.out.print("dfs: ");
		q.dfs();
		System.out.print("bfs: ");
		q.bfs();
	}
}