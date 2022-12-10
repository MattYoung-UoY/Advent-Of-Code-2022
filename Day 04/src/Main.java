import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {

	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/input.txt")))) {
			System.out.println(reader.lines().mapToInt(s -> cleaningOverlap(s.split(",")[0], s.split(",")[1])).sum());
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	private static int cleaningOverlap(String elf1, String elf2) {
		
		int startElf1 = Integer.parseInt(elf1.split("-")[0]);
		int endElf1 = Integer.parseInt(elf1.split("-")[1]);
		
		int startElf2 = Integer.parseInt(elf2.split("-")[0]);
		int endElf2 = Integer.parseInt(elf2.split("-")[1]);
		
		if(startElf1 <= startElf2 && endElf1 >= endElf2) return 1;
		if(startElf2 <= startElf1 && endElf2 >= endElf1) return 1;
		
		return 0;
	}
	
}
