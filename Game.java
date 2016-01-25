import java.io.*;
import java.util.ArrayList;
import cs1.Keyboard;

public class Game {
	
	private static int currentLine = -1;
	private static int currentRoom = 0;
	private static boolean inFight = false;
	private static ArrayList<String> story = new ArrayList<String>();
	private static ArrayList<String> storyTemp = new ArrayList<String>();
	private static int characterType;
	
	//every single story line will contain a 4 character precursor <room>,<line>,<battle>,---random battle chance<true or false>---
	//true or false corresponds to the inFight boolean.
	
	private static void interpreter(String input) {
		
		//This top if statement will never occur, can be removes as Battle.java
		//interprets all input when in a fight.
		//********************************
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
		//*********************************
		if ((!inFight) && input.equals("map")) {
			map();
			interpreter(Keyboard.readString());
		}
		if ((!inFight) && input.equals("log")) {
			log();
			interpreter(Keyboard.readString());
		}
		if ((!inFight) && input.equals("next")) {
			nextLine();
			interpreter(Keyboard.readString());
		}
		else {
			System.out.println("UNRECORGNIZED COMMAND:" + " **" + input + "** " + "Please try again.");
			interpreter(Keyboard.readString());
		}
	}
	
	private static void map() {
		System.out.println("Map function not yet implemented.");
		System.out.println("Passing Compiler");
		//Will use the currentLine and currentRoom to determine where to place character in map.
	}
	
	//Log method is complete.
	private static void log() {
		if (currentLine == 0) {
			System.out.println("You're at the beginning of the game. No need for the log.");
		}
		else {
			System.out.println("SHOWING STORY LOG");
			for (int x = 0; x < currentLine; x++) {
				System.out.println(story.get(x));
			}
			System.out.println("Reprinting current story line:");
			System.out.println(story.get(currentLine));
		}
	}
	
	public static void play() {
		String input = "";
		nextLine();
		input = Keyboard.readString();
		interpreter(input);
		nextLine();
		input = Keyboard.readString();
		interpreter(input);
		nextLine();
		input = Keyboard.readString();
		interpreter(input);
		/*Barbarian test1 = new Barbarian();
		Skeleton test2 = new Skeleton();
		String input;
		//input = Keyboard.readString();
		System.out.println(story);
		//System.out.println(input);
		System.out.println("running interpreter");
		//interpreter(input);
		Battle test = new Battle();
		test.Turn(test1, test2);*/
	}
	
	//Separate story method is complete.
	private static void separateStory() {
		String line = "";
		for (String lineTemp : storyTemp) {
			System.out.println(lineTemp);
			String[] temp = lineTemp.split("\\$");
			System.out.println(temp[5]);
			line = temp[5];
			story.add(line);
		}
	}
	
	private static void battleChance(int chance) {
		String input = "";
		System.out.println("Battle Chance Initiated");
		int x = (int) (Math.random() * 100);
		if (x < chance) {
			System.out.println("Battle is Possible");
		}
		else {
			System.out.println("Battle is not possible");
		}
		input = Keyboard.readString();
		interpreter(input);
	}
	
	private static void bossBattle() {
		String input = "";
		System.out.println("Boss Battle Initiated");
		input = Keyboard.readString();
		interpreter(input);
	}
	
	//Next Line method is complete.
	private static void nextLine() {
		currentLine++;
		String lineTemp = storyTemp.get(currentLine);
		String[] temp = lineTemp.split("\\$");
		currentRoom = Integer.parseInt(temp[1]);
		System.out.println(temp[5]);
		if (Boolean.parseBoolean(temp[2])) {
			if (Boolean.parseBoolean(temp[3])) {
				bossBattle();
			}
			else {
			battleChance(Integer.parseInt(temp[4]));
			}
		}
	}
	
	//Read File method is complete.
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
	
	//Main method is complete.
	public static void main(String[] args) {
		readFile();
		play();
	}
	
	//when enter new room, random chance of battle
	//when battle, Battle test = new Battle();
	//test.Turn(Barbarian, Skeleton);
	
	
}