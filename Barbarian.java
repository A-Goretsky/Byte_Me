public class Barbarian {
    
    public Barbarian() {
        hp = 120;
        con = 10;
        str = 10;
        dex = 10;
        int = 10;
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
    
    public String attack(Monster m, int choice) {
        if (choice == 1) {
            return rage();
        }
        else if (choice == 2) {
            return powerAttack(m);
        }
        else if (choice == 3) {
            return regen();
        }
        else if (choice == 4) {
            return bodySlam(m);
        }
        else {
            return "That is not a choice."
        }
    }
    
    public String rage() {
        str = 20;
        armor = 2;
        "You enter a bloodthirsty rage."
    }
    
    public String powerAttack(Monster m) {
        int damage = m.lowerHP((int)(Math.random() * str));
        "You slam your weapon devastatingly into the " + m.getName() + " for " + damage + " damage!"
    }
    
    public String regen() {
        str = 10;
        armor = 5;
        if (hp+10 > 120) {
            hp = 120;
        }
        else {
            hp += 10;
        }
        "You relax your muscles, letting them recuperate much faster."
    }
    
    public String bodySlam() {
        int damage = m.lowerHP((int)(Math.random() * (str+5));
        int damageTaken = m.lowerHP((int)(Math.random() * (str+5)/3));
        "You slam the full force of your body, weapons, and armor into the " + m.getName() + ", dealing " + damage + " damage as well as taking " + damageTaken + " yourself."
    }
}