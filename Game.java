import java.io.*;
import java.util.ArrayList;

public class Game {
	
	private int currentLine;
	private int currentRoom;
	private int currentBattle;
	private boolean inFight = false;
	private ArrayList story = new ArrayList();
	
	//every single story line will contain a 4 character precursor <room>,<line>,<battle>,<true or false>
	//true or false corresponds to the inFight boolean.
	
	private static interpreter(String input) {
		if (inFight) {
			if (input == "map" || input == "log") {
				//try switch method here
				System.out.println("Access to map is not permitted during a battle.");
				System.out.println("Access to the log is not permitted during a battle.");
				interpreter(input);
			}
			else {
				Battle.playerTurn(input);
			}
		}
		if ((!inFight) && input == "map") {
			map();
		}
		if ((!inFight) && input == "log") {
			log();
		}
	}
	
	private static printLine(int line) {
		System.out.println("Passing Compiler");
	}
	
	private static map() {
		System.out.println("Passing Compiler");
		//Will use the currentLine and currentRoom to determine where to place character in map.
	}
	
	public static play() {
		System.out.println("Passing Compiler");
		
	}
	
	private static readFile() {
		try {
			FileReader file = new FileReader(story.txt);
			BufferedReader bufferedFile = new BufferedReader(file);
			while (bufferFile.readline() != null) {
				story.add(bufferFile.readLine());
			}
		}
		catch (IOException e) {
			System.out.println("ERROR: Story file missing, or incorrect path.");
	}
	
	public static void main(String[] args) {
		readFile();
		play();
	}
	
}