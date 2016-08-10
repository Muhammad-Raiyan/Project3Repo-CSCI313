
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

	public void graphColor(int nd_pos) {

		if (nd_pos  == size) {
			System.out.println("Solved");
			//return;
		}

		for (int i = 0; i < 4; i++) {
			if (isSafe(nd_pos, i)) {
				nodeColor[nd_pos] = i;
				System.out.println(nd_pos + " was colored " + clrIndex(i));
				if (nd_pos + 1 < size)
					graphColor(nd_pos + 1);
				else {
					System.out.println("Final color combination is ");
					i = 4;
					colorPrint();
					return;
				}
			}
		}

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
		switch (nodeColor[i]) {
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
		for (int i = 0; i < size; i++) {
			System.out.println("node " + i + " is " + clrIndex(i));
			/*switch (nodeColor[i]) {
			case 0:
				System.out.println("Red");
				break;
			case 1:
				System.out.println("Green");
				break;
			case 2:
				System.out.println("Blue");
				break;
			case 3:
				System.out.println("Yellow");
				break;
			}*/
		}
	}

}
