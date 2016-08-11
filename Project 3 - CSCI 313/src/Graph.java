
public class Graph {
	private int size; // number of nodes in the graph
	private int[][] nodes; // adjacent matrix for the graph
	private int[] nodeColor; // stores color assignment for each node
	private boolean backtrack; // keeps track of backtrack

	/*
	 * 0 -> Red; 1 -> Green; 2 -> Blue; 3 -> Yellow;
	 */

	// Constructor
	Graph(int s) {
		size = s;
		nodes = new int[size][size];
		nodeColor = new int[size];
		backtrack = false;
	}

	/**
	 * takes a string, splits it and store the numbers in the array. also
	 * initialize all the color to -5 which is sentinel value
	 * 
	 * @param s
	 *            a string containing all the adjacencies of a node
	 * @param pos
	 *            the node number
	 */
	public void insertNode(String s, int pos) {
		if (pos >= size)
			throw new RuntimeException("Invalid insertion position");
		String temp[] = s.split(" ");
		for (int i = 0; i < size; i++) {
			nodes[pos][i] = Integer.parseInt(temp[i]);
			nodeColor[i] = -5; // guard value
		}
	}

	/**
	 * @return int the size of the graph
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Colors a node, recursively calls the next node to be colored and if
	 * coloring failed, backtrack and reassign color.
	 * 
	 * @param nd_pos
	 *            the node that needs coloring
	 * @return boolean true if coloring successful; false if coloring failed
	 */
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
					System.out.println("BACKTRACK from node " + nd_pos);
					System.out.println("Configuration so far:");
					colorPrint(nd_pos + 1);
					backtrack = true;
				}
			}
		}
		return false;
	}

	/**
	 * 
	 * @param nd_pos
	 *            the node that needs to be checked
	 * @param color
	 *            the color that needs to be checked
	 * @return boolean true if color is safe to assign; false if not safe to
	 *         color
	 */
	public boolean isSafe(int nd_pos, int color) {

		for (int i = 0; i < size; i++) {
			if (nodes[nd_pos][i] == 1 && nodeColor[i] == color)
				return false;
		}
		return true;
	}

	/**
	 * @param key
	 *            check key against the color
	 * @return String the color
	 */
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
			return "Failed to color, initialization point of backtrack";
		}
	}

	/**
	 * The colored representation of the graph
	 * 
	 * @param till
	 *            the node till which needs to be printed
	 */
	public void colorPrint(int till) {
		for (int i = 0; i < till; i++) {
			System.out.println("Node " + i + " " + clrIndex(nodeColor[i]));
		}
	}

}
