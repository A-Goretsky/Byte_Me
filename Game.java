import java.io.*;
import java.util.ArrayList;
import cs1.Keyboard;

public class Game {
	
	private static int currentLine = 0;
	private static int currentRoom = 0;
	private static boolean inFight = false;
	private static ArrayList<String> story = new ArrayList<String>();
	private static ArrayList<String> storyTemp = new ArrayList<String>();
	private static int characterType;
	
	//every single story line will contain a 4 character precursor <room>,<line>,<battle>,---random battle chance<true or false>---
	//true or false corresponds to the inFight boolean.
	
	private static void interpreter(String input) {
		if (inFight) {
			switch(input) {
				//try switch method here
				case "map": 
					System.out.println("Access to map is not permitted during a battle.");
					interpreter(Keyboard.readString());
					break;
				case "log": 
					System.out.println("Access to the log is not permitted during a battle.");
					interpreter(Keyboard.readString());
					break;
				default:
					//passing compiler
					//Battle.playerTurn(input);
			}
		}
		if ((!inFight) && input.equals("map")) {
			map();
		}
		if ((!inFight) && input.equals("log")) {
			log();
		}
		System.out.println("failed all test cases");
	}
	
	private static void printLine(int line) {
		System.out.println("Passing Compiler");
	}
	
	private static void map() {
		System.out.println("Map function not yet implemented.");
		System.out.println("Passing Compiler");
		//Will use the currentLine and currentRoom to determine where to place character in map.
	}
	
	private static void log() {
		System.out.println("Log function not yet implemented.");
		for (String line : story) {
			System.out.println(line);
		}
		System.out.println("Passing Compiler LOG");
	}
	
	public static void play() {
		Barbarian test1 = new Barbarian();
		Skeleton test2 = new Skeleton();
		String input;
		//input = Keyboard.readString();
		System.out.println(story);
		//System.out.println(input);
		System.out.println("running interpreter");
		//interpreter(input);
		Battle test = new Battle();
		test.Turn(test1, test2);
	}
	
	private static void separateStory() {
		String line = "";
		for (String lineTemp : storyTemp) {
			System.out.println(lineTemp);
			String[] temp = lineTemp.split("\\$");
			line = temp[3];
			story.add(line);
		}
	}
	
	private static void readFile() {
		String line = "";
		try {
			FileReader file = new FileReader("story.txt");
			BufferedReader bufferedFile = new BufferedReader(file);
			while ((line = bufferedFile.readLine()) != null) {
				storyTemp.add(line);
			}
			separateStory();
		}
		catch (IOException e) {
			System.out.println("ERROR: Story file missing, or incorrect path.");
		}
	}
	
	public static void main(String[] args) {
		readFile();
		play();
	}
	
	//when enter new room, random chance of battle
	//when battle, Battle test = new Battle();
	//test.Turn(Barbarian, Skeleton);
	
	
}