import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {

	public static void main(String[] args) {
		String[] input = null;
		try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/input.txt")))){
			input = reader.lines().toArray(String[]::new);
		}catch(Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		int max1 = 0, max2 = 0, max3 = 0;
		
		int currentElfTotal = 0;
		for(String line : input) {
			
			if(line.equals("")) {
				
				if(currentElfTotal > max1) {
					max3 = max2;
					max2 = max1;
					max1 = currentElfTotal;
				}else if(currentElfTotal > max2) {
					max3 = max2;
					max2 = currentElfTotal;
				}else if(currentElfTotal > max3) {
					max3 = currentElfTotal;
				}
				
				currentElfTotal = 0;
				continue;
			}
			
			currentElfTotal += Integer.parseInt(line);
		}
		
		if(currentElfTotal > max1) {
			max1 = currentElfTotal;
		}else if(currentElfTotal > max2) {
			max2 = currentElfTotal;
		}else if(currentElfTotal > max3) {
			max3 = currentElfTotal;
		}
		
		System.out.println("Max 1: " + max1 + "\n"
						+ "Max 2: " + max2 + "\n"
						+ "Max 3: " + max3 + "\n\n"
						+ "Total: " + (max1 + max2 + max3));
		
	}
	
}
