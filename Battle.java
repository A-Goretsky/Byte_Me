import cs1.Keyboard;

public class Battle {
    
    int turnCounter = 0;
    
    public void playerTurn(Character c, Monster m) {
        int choice;
        System.out.println(c.moveList());
        System.out.print("Selection: ");
        choice = Keyboard.readInt();
        c.attack(m, choice);
    }
    
    public void Turn(Character c, Monster m) {
        playerTurn(c, m);
        if (!(m.isAlive())) {
            System.out.println("You have defeated the monster!");
            return;
        }
        m.attack(c);
        if (!(c.isAlive())) {
            System.out.println("You were slain by the monster.");
			return;
        }
        turnCounter += 1;
        Turn(c, m);
    }
    
}