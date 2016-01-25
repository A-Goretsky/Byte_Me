public class Barbarian extends Character{
    
    public Barbarian() {
        hp = 120;
        con = 10;
        stre = 10;
        dex = 10;
        inte = 10;
        wis = 10;
        cha = 10;
        armor = 5;
    }
    
    public String moveList() {
        String retStr = "";
        retStr += "\nWhich move would you like to use?\n";
        retStr += "\n1: Rage\n";
        retStr += "2: Power Attack\n";
        retStr += "3: Regenerate\n";
        retStr += "4: Body Slam\n";
        return retStr;
    }
    
    public void attack(Monster m, int choice) {
		System.out.println(choice);
		switch(choice) {
			case 1:
				rage();
				break;
			case 2:
				powerAttack(m);
				break;
			case 3:
				regen();
				break;
			case 4:
				bodySlam(m);
				break;
			default:
				System.out.println("That is not a choice.");
				break;
		}
    }
    
    public void rage() {
        stre = 20;
        armor = 2;
        System.out.println("You enter a bloodthirsty rage.");
    }
    
    public void powerAttack(Monster m) {
        int damage = m.lowerHP((int)(Math.random() * stre));
        System.out.println("You slam your weapon devastatingly into the " + m.getName() + " for " + damage + " damage!");
    }
    
    public void regen() {
        stre = 10;
        armor = 5;
        if (hp+10 > 120) {
            hp = 120;
        }
        else {
            hp += 10;
        }
        System.out.println("You relax your muscles, letting them recuperate much faster.");
    }
    
    public void bodySlam(Monster m) {
        int damage = m.lowerHP((int)(Math.random() * (stre+5)));
		System.out.println("PRINTING DAMAGE");
		System.out.println(damage);
        int damageTaken = lowerHP((int)((Math.random() * (stre+5))/3));
		System.out.println("PRINTING DAMAGE TAKEN");
		System.out.println(damageTaken);
		System.out.println("MONSTER HEALTH");
		System.out.println(m.hp);
		System.out.println("CHARACTER HEALTH");
		System.out.println(hp);
        System.out.println("You slam the full force of your body, weapons, and armor into the " + m.getName() + ", dealing " + damage + " damage as well as taking " + damageTaken + " yourself.");
    }
}