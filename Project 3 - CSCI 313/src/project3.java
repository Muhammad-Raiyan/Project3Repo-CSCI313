import java.io.*;

public class project3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String line, temp[];
		// String[] temp;
		int num = 0, i = 0;
		num = Integer.parseInt(br.readLine());
		int[][] data = new int[num][num];
		while ((line = br.readLine()) != null) {
			temp = line.split(" ");
			for (int j = 0; j < num; j++) {
				data[i][j] = Integer.parseInt(temp[j]);
				//System.out.println(i + " " + j + " " + data[i][j]);
			}

			++i;
			if (i == num) {
				if ((line = br.readLine()) == null)
					break;
				num = Integer.parseInt(line);
			}
		}

		for (int j = 0; j < num; j++) {
			for (int k = 0; k < num; k++) {
				System.out.println(data[j][k]);
			}
		}
		br.close();
	}

}
