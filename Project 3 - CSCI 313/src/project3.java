import java.io.*;

public class project3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String line, temp_n;
		int num;
		Graph g;
		int[][] data;
		while ((temp_n = br.readLine()) != null) {
			g = new Graph(Integer.parseInt(temp_n));
			for (int i = 0; i < g.getSize(); i++) {
				line = br.readLine();
				g.insertNode(line, i);
			}
			//g.print();
			g.graphColor(0);
		}
		br.close();

	}
}
