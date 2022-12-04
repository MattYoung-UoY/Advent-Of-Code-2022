import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		String[] lines;
		try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/input.txt")))) {
			lines = reader.lines().toArray(String[] :: new);
			System.out.println(Arrays.stream(lines).mapToInt(s -> itemPriority(findOverlapItem(s))).sum());
			String[][] groups = new String[lines.length/3][3];
			for(int i = 0; i < lines.length; i+=3) {
				groups[i/3][0] = lines[i];
				groups[i/3][1] = lines[i+1];
				groups[i/3][2] = lines[i+2];
			}
			System.out.println(Arrays.stream(groups).mapToInt(s_arr -> itemPriority(groupBadge(s_arr))).sum());
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	private static char groupBadge(String[] group) {
		for(char item: group[0].toCharArray()) {
			if(group[1].indexOf(item) != -1 && group[2].indexOf(item) != -1) return item;
		}
		throw new IllegalArgumentException("Groups must contain at least one of the same item");
	}
	
	private static char findOverlapItem(String bag) {
		String comp1, comp2;
		comp1 = bag.substring(0, bag.length()/2);
		comp2 = bag.substring(bag.length()/2);
		for(int i = 0; i < comp1.length(); i++) {
			for(int j = 0; j < comp2.length(); j++) {
				if (comp1.charAt(i) == comp2.charAt(j)) return comp1.charAt(i);
			}
		}
		throw new IllegalArgumentException("Compartments must contain duplicate elements:\nComp1: " + comp1
				+ "\nComp2: " + comp2);
	}
	
	private static int itemPriority(char item) {
		if(item >= 'A' && item <= 'Z') {
			return ((int) item - 'A' + 1 + 26);
		}
		return ((int) item - 'a' + 1);
	}
	
}
