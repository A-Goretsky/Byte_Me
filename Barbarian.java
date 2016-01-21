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
        if (choice == 1) {
            rage();
        }
        else if (choice == 2) {
            powerAttack(m);
        }
        else if (choice == 3) {
            regen();
        }
        else if (choice == 4) {
            bodySlam(m);
        }
        else {
            System.out.println("That is not a choice.");
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
        int damageTaken = m.lowerHP((int)(Math.random() * (stre+5)/3));
        System.out.println("You slam the full force of your body, weapons, and armor into the " + m.getName() + ", dealing " + damage + " damage as well as taking " + damageTaken + " yourself.");
    }
}