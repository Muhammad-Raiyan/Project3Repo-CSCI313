import java.io.*;

public class project3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String line, temp_n;
		int num;
		
		int[][] data;
		while((temp_n = br.readLine())!= null){
			num = Integer.parseInt(temp_n);
			data = new int[num][num];
			int i = 0;
			while(num>0){
				line = br.readLine();
				String temp[] = line.split(" ");
				
				for(int j=0; j<temp.length; j++)
					data[i][j] = Integer.parseInt(temp[j]);
				i++;
				num--;
			}
			print(data);
		}
		br.close();
		
		
	}
	
	public static void print(int[][] arr){
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[i].length; j++){
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}

}
