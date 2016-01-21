public class Skeleton extends Monster {
    
    public Skeleton() {
        hp = 10;
        armor = 5;
        name = "Skeleton";
    }
    
    public void attack(Character c) {
        int choice = (int)(Math.random() * 4);
        if (choice == 0) {
            boneFire(c);
        }
        else if (choice == 1) {
            spareRibs(c);
        }
        else if (choice == 2) {
            spareRibs(c);
        }
        else {
			lazyBones();
		}
    }
    
    public void boneFire(Character c) {
        int damage = c.lowerHP((int)(Math.random() * 15));
        System.out.println("The skeleton threw a flaming bone at " + c.getName() + " for " + damage + " damage!");
    }
    
    public void spareRibs(Character c) {
        int damage = c.lowerHP((int)(Math.random() * 10));
        System.out.println("The skeleton threw a spare bone at " + c.getName() + " for " + damage + " damage!");
    }
    
    public void boneToBeWild(Character c) {
        int damage = c.lowerHP((int)(Math.random() * 5));
        System.out.println("The skeleton charged maliciously at " + c.getName() + ", attacking for " + damage + " damage!");
    }
    
    public void lazyBones() {
        System.out.println("The skeleton stood around, and did nothing.");
    }
    
}