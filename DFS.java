import java.util.Stack;

public class DFS {
	
	public static void main(String[] args) {
		//search through the graph and find an element
		int[][] adjMatrix = new int[6][6];
		adjMatrix[4][1] = 1;
		adjMatrix[1][2] = 1;
		adjMatrix[1][3] = 1;
		adjMatrix[2][3] = 1;
		adjMatrix[3][5] = 1;
		adjMatrix[1][4] = 1;
		adjMatrix[2][1] = 1;
		adjMatrix[3][1] = 1;
		adjMatrix[3][2] = 1;
		adjMatrix[5][3] = 1;
		dfs(adjMatrix);
	}
	
	public static void dfs(int[][] adjMatrix) {
		boolean[][] visited = new boolean[6][6];
		for (int x = 0; x < 6; x++) {
			for (int y = 0; y < 5; y++) {
				visited[x][y] = false;
			}
		}
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(4);
		while (!stack.isEmpty()) {
			int current = stack.peek();
			int next = 0;
			boolean noChild = true;
			for (int x = 1; x < 6; x++) {
				if ((adjMatrix[current][x] == 1 || adjMatrix[x][current] == 1) && (visited[current][x] == false || visited[x][current] == false)) {
					next = x;
					noChild = false;
				}
			}
			if (!noChild) {
				visited[current][next] = true;
				visited[next][current] = true;
				stack.push(next);
				System.out.println(next);
			}
			else {
				stack.pop();
			}
		}
	}
}
