public abstract class Character {
    
    int hp, con, str, dex, int, cha, wis, armor;
    
    public static int lowerHP(int damage) {
        hp -= damage - armor;
        return damage;
    }

}