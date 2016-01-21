public abstract class Character {
    
    int hp, con, str, dex, int, cha, wis, armor;
    String name;
    
    public boolean isAlive() {
        return hp > 0;
    }
    
    public int lowerHP(int damage) {
        hp -= damage - armor;
        return damage;
    }
    
    public String attack(Monster m);
    
    public String moveList();
    
    public String getName() {
        return name;
    }

}