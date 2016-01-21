public abstract class Monster {
    
    int hp, armor;
    String name;
    
    public boolean isAlive() {
        return hp > 0;
    }
    
    public int lowerHP(int damage) {
        hp -= damage - armor;
        return damage;
    }
    
    public abstract void attack(Character c);
    
    public String getName() {
        return name;
    }
    
}