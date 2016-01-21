public class Skeleton extends Character {
    
    public Skeleton() {
        hp = 10;
        armor = 5;
        name = "Skeleton";
    }
    
    public String attack(Character c) {
        int choice = (int)(Math.random() * 4);
        if (choice == 0) {
            return boneFire(c);
        }
        else if (choice == 1) {
            return spareRibs(c);
        }
        else if (choice == 2) {
            return spareRibs(c);
        }
        return lazyBones();
    }
    
    public String boneFire(Character c) {
        int damage = c.lowerHP((int)(Math.random() * 15));
        return "The skeleton threw a flaming bone at " + c.getName() + " for " + damage + " damage!"
    }
    
    public String spareRibs(Character c) {
        int damage = c.lowerHP((int)(Math.random() * 10));
        return "The skeleton threw a spare bone at " + c.getName() + " for " + damage + " damage!"
    }
    
    public String boneToBeWild(Character c) {
        int damage = c.lowerHP((int)(Math.random() * 5));
        return "The skeleton charged maliciously at " + c.getName() + ", attacking for " + damage + " damage!"
    }
    
    public String lazyBones() {
        return "The skeleton stood around, and did nothing."
    }
    
}