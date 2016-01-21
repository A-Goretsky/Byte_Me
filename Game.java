import java.io.*;
import java.util.ArrayList;

public class Game {
	
	private static int currentLine = 0;
	private static int currentRoom = 0;
	private static boolean inFight = false;
	private static ArrayList story = new ArrayList();
	
<<<<<<< HEAD
	//every single story line will contain a 4 character precursor <room>,<line>,<battle>,---random battle chance<true or false>---
	//true or false corresponds to the inFight boolean.
=======
	//every single story line will contain a 2 character precursor <room>,<line>
>>>>>>> f9b03bca2d133449aba931e2c4be9cbe773bb852
	
	private static void interpreter(String input) {
		if (inFight) {
			switch(input) {
				//try switch method here
				case "map": 
					System.out.println("Access to map is not permitted during a battle.");
					break;
					//interpreter(CHANGE TO KEYBOARD input);
				case "log": 
					System.out.println("Access to the log is not permitted during a battle.");
					break;
					//interpreter(//CHANGE TO KEYBOARD input);
				default:
					//passing compiler
					//Battle.playerTurn(input);
			}
		}
		if ((!inFight) && input == "map") {
			map();
		}
		if ((!inFight) && input == "log") {
			log();
		}
	}
	
	private static void printLine(int line) {
		System.out.println("Passing Compiler");
	}
	
	private static void map() {
		System.out.println("Passing Compiler");
		//Will use the currentLine and currentRoom to determine where to place character in map.
	}
	
	private static void log() {
		System.out.println("Passing Compiler");
	}
	
	public static void play() {
		System.out.println(story);
	}
	
	private static void readFile() {
		String line = "";
		try {
			FileReader file = new FileReader("story.txt");
			BufferedReader bufferedFile = new BufferedReader(file);
			while ((line = bufferedFile.readLine()) != null) {
				story.add(line);
			}
		}
		catch (IOException e) {
			System.out.println("ERROR: Story file missing, or incorrect path.");
		}
	}
	
	public static void main(String[] args) {
		readFile();
		play();
	}
	
}