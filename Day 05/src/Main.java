import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/input.txt")))) {
			
			String line = reader.readLine();
			
			/*
			 * Number of characters on a line is given by 3n+n-1=c
			 * Rearranging for n gives n=(c+1)/4
			 */
			int numStacks = (line.length()+1)/4;
			
			List<Stack<Character>> stacks = new ArrayList<Stack<Character>>();
			
			for(int i = 0; i < numStacks; i++) {
				stacks.add(new Stack<Character>());
				if(line.charAt((4*i)+1) != ' ') stacks.get(i).push(line.charAt((4*i)+1));
			}
			
			while(!isNumeric(Character.toString((line=reader.readLine()).charAt(1)))) {
				for(int i = 0; i < numStacks; i++)
					if(line.charAt((4*i)+1) != ' ')
						stacks.get(i).push(line.charAt((4*i)+1));
			}
			
			for(Stack<Character> stack : stacks) {
				List<Character> temp = new ArrayList<>();
				while(stack.size() > 0) temp.add(stack.pop());
				for(Character c : temp) stack.push(c);
			}
			
			for(Stack<Character> stack : stacks) System.out.println(stack);

			line = reader.readLine();
			if(!line.isEmpty()) throw new IllegalArgumentException();
			
			ArrayList<String> instructions = new ArrayList<>();
			
			while((line=reader.readLine()) != null) instructions.add(line);

			//cratemover9000(new ArrayList<Stack<Character>>(stacks), new ArrayList<String>(instructions));
			cratemover9001(stacks, instructions);
			
		}catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
	}
	
	private static void cratemover9000(List<Stack<Character>> stacks, List<String> instructions){
		System.out.println("\nStarting CrateMover 9000:\n---------------------------------------------------------------------------------------");
		
		for(String instruction: instructions) {
			String temp = instruction;
			temp = temp.replaceAll("move ", "");
			temp = temp.replaceAll("from ", "");
			temp = temp.replaceAll("to ", "");
			String[] parts = temp.split(" ");
			for(int i = 0; i < Integer.parseInt(parts[0]); i++) {
				stacks.get(Integer.parseInt(parts[2])-1).push(stacks.get(Integer.parseInt(parts[1])-1).pop());
			}
		}
		
		for(Stack<Character> stack : stacks) System.out.println(stack);
		System.out.println();
		for(Stack<Character> stack : stacks) System.out.print(stack.peek());
		System.out.println();
	}
	
	private static void cratemover9001(List<Stack<Character>> stacks, List<String> instructions){
		System.out.println("\nStarting CrateMover 9001:\n---------------------------------------------------------------------------------------");
		
		for(String instruction: instructions) {
			String temp = instruction;
			temp = temp.replaceAll("move ", "");
			temp = temp.replaceAll("from ", "");
			temp = temp.replaceAll("to ", "");
			String[] parts = temp.split(" ");
			Stack<Character> movingCrates = new Stack<>();
			for(int i = 0; i < Integer.parseInt(parts[0]); i++) {
				movingCrates.push(stacks.get(Integer.parseInt(parts[1])-1).pop());
			}
			for(int i = 0; i < Integer.parseInt(parts[0]); i++) {
				stacks.get(Integer.parseInt(parts[2])-1).push(movingCrates.pop());
			}
		}
		
		for(Stack<Character> stack : stacks) System.out.println(stack);
		System.out.println();
		for(Stack<Character> stack : stacks) System.out.print(stack.peek());
		System.out.println();
	}
	
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
}
