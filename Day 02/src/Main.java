import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {

	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/input.txt")))) {
			System.out.println(reader.lines().mapToInt(s -> playRoundPt2(s.split(" ")[0], s.split(" ")[1])).sum());
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	private static int playRoundPt1(String oppMove, String myMove) {
		int score = 0;

		switch (myMove) {
		case "X":
			score += 1;

			switch (oppMove) {
			case "A":
				score += 3;
				break;
			case "C":
				score += 6;
			}

			break;
		case "Y":
			score += 2;

			switch (oppMove) {
			case "B":
				score += 3;
				break;
			case "A":
				score += 6;
			}

			break;
		case "Z":
			score += 3;

			switch (oppMove) {
			case "C":
				score += 3;
				break;
			case "B":
				score += 6;
			}

		}
		
		return score;
	}

	private static int playRoundPt2(String oppMove, String myMove) {
		int score = 0;

		switch (myMove) {
		// Lose
		case "X":
			switch (oppMove) {
			case "A":
				score += 3;
				break;
			case "B":
				score += 1;
				break;
			case "C":
				score += 2;
			}
			break;
		// Tie
		case "Y":
			score += 3;
			switch (oppMove) {
			case "A":
				score += 1;
				break;
			case "B":
				score += 2;
				break;
			case "C":
				score += 3;
			}
			break;
		// Win
		case "Z":
			score += 6;
			switch (oppMove) {
			case "A":
				score += 2;
				break;
			case "B":
				score += 3;
				break;
			case "C":
				score += 1;
			}
		}

		return score;
	}

}
