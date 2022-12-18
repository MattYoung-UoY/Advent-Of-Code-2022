import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {

	public static void main(String[] args) {
		int allDiffReq = 14;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/input.txt")))) {
			String input = reader.readLine();
			
			if(allDiff(input.substring(0, allDiffReq))) {
				System.out.println(allDiffReq);
				System.exit(0);
			}
			
			for(int i = allDiffReq; i < input.length(); i++) {
				if(allDiff(input.substring(i-allDiffReq+1, i+1))) {
					System.out.println(i+1 + ": " + input.substring(i-allDiffReq+1, i+1));
					System.exit(0);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	private static boolean allDiff(String chars) {
		if(chars.length() == 1) return true;
		else {
			char first = chars.charAt(0);
			String others = chars.substring(1);
			if(others.indexOf(first) != -1) return false;
			else return allDiff(others);
		}
	}
	
}
