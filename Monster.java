public abstract class Monster {
    
    int hp, armor;
    
    public static void attack();
    
    public static int lowerHP(int damage) {
        hp -= damage - armor;
        return damage;
    }
    
}