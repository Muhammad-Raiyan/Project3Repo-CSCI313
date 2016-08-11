
public class Graph {
	private int size;
	private int[][] nodes;
	private int[] nodeColor;
	private boolean backtrack;

	/*
	 * 0 -> Red; 1 -> Green; 2 -> Blue; 3 -> Yellow;
	 */
	Graph(int s) {
		size = s;
		nodes = new int[size][size];
		nodeColor = new int[size];
		backtrack = false;
	}

	public void insertNode(String s, int pos) {
		if (pos >= size)
			throw new RuntimeException("Invalid insertion position");
		String temp[] = s.split(" ");
		for (int i = 0; i < size; i++) {
			nodes[pos][i] = Integer.parseInt(temp[i]);
			nodeColor[i] = -5;
		}
	}

	public int getSize() {
		return size;
	}

	public boolean graphColor(int nd_pos) {

		if (nd_pos == size)
			return true;

		for (int i = 0; i < 4; i++) {
			if (isSafe(nd_pos, i)) {
				backtrack = false;
				nodeColor[nd_pos] = i;
				if (graphColor(nd_pos + 1))
					return true;
				nodeColor[nd_pos] = -1;
			} else {
				if (i == 3 && backtrack == false) {
					System.out.println("\tBACKTRACK from node " + nd_pos);
					System.out.println("Configuration so far:");
					colorPrint(nd_pos + 1);
					backtrack = true;
				}
			}
		}
		return false;
	}

	public boolean isSafe(int nd_pos, int color) {

		for (int i = 0; i < size; i++) {
			if (nodes[nd_pos][i] == 1 && nodeColor[i] == color)
				return false;
		}
		return true;
	}

	public String clrIndex(int key) {
		switch (key % 4) {
		case 0:
			return "is Red";
		case 1:
			return "is Green";
		case 2:
			return "is Blue";
		case 3:
			return "is Yellow";
		default:
			return "Failed to color, initiate backtrack";
		}
	}

	public void colorPrint(int till) {
		for (int i = 0; i < till; i++) {
			System.out.println("Node " + i + " " + clrIndex(nodeColor[i]));
		}
	}

}
