public abstract class Character {
    
    int hp, con, stre, dex, inte, cha, wis, armor;
    String name;
    
    public boolean isAlive() {
        return hp > 0;
    }
    
    public int lowerHP(int damage) {
        hp -= damage - armor;
        return damage;
    }
    
    public abstract void attack(Monster m, int choice);
    
    public abstract String moveList();
    
    public String getName() {
        return name;
    }

}