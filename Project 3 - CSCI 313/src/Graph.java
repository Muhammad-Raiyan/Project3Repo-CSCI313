
public class Graph {
	private int size;
	private int[][] nodes;
	private int[] nodeColor;

	/*
	 * 0 -> Red; 1 -> Green; 2 -> Blue; 3 -> Yellow;
	 */
	Graph(int s) {
		size = s;
		nodes = new int[size][size];
		nodeColor = new int[size];
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

		if(nd_pos == size) return true;
		
		for(int i = 0; i<4; i++){
			if (isSafe(nd_pos, i)) {
				nodeColor[nd_pos] = i;
				System.out.println("Node " + nd_pos + " --> " + clrIndex(nodeColor[nd_pos]));
				if (graphColor(nd_pos + 1))
					return true;
				nodeColor[nd_pos] = -1;
			}
			else{
				if(i == 3) System.out.println("\tBACKTRACK from node " + nd_pos);
				//System.out.println("not safe " + i);
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

	public void print() {
		System.out.println(getSize());
		for (int i = 0; i < getSize(); i++) {
			for (int j = 0; j < getSize(); j++) {
				System.out.print(nodes[i][j]);
			}
			System.out.println();
		}
	}
	
	public String clrIndex(int i){
		switch (i ) {
		case 0:
			return "Red";
		case 1:
			return "Green";
		case 2:
			return "Blue";
		case 3:
			return "Yellow";
		default:
			return "Failed to color";
		}
	}
	public void colorPrint() {
		System.out.println("FINAL SOLUTION: ");
		for (int i = 0; i < size; i++) {
			System.out.println("\tNode " + i + " is " + clrIndex(nodeColor[i]) );
		}
	}

}
