import java.io.*;

public class project3 {

	public static void main(String[] args) throws IOException {
		if (args.length == 0) // check for file name in command line argument
			System.out.println("No file specified");
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String line, temp_n;
		int num = 0;
		Graph g;
		while ((temp_n = br.readLine()) != null) {
			System.out.println("Graph #" + ++num);
			g = new Graph(Integer.parseInt(temp_n));
			for (int i = 0; i < g.getSize(); i++) {
				line = br.readLine();
				g.insertNode(line, i);
			}
			if (g.graphColor(0)) {
				System.out.println("\tFINAL CONFIGARATION: ");
				g.colorPrint(g.getSize());
				System.out.println("Graph coloring successful\n");
			}
		}
		br.close();

	}
}
