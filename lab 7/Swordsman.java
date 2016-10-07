package ourlab7;

public class Swordsman extends Hero {

    // because of sword
    private static final int BASE_ATTACK = 5;
    // because of armor
    private static final int ARMOR = 5;

    public Swordsman(String name, int level) {
        // a swordsman will have +ARMOR for HP because of ARMOR
        super(name, level + ARMOR, level);
    }

    public Swordsman(String name) {
        // a swordsman will have +ARMOR for HP because of ARMOR
        //super(name, level + ARMOR, level);
        super(name, 100, 20);
        setMoveDamageIncrease(15);
    }

    public int attack() {

        return BASE_ATTACK + getLevel();
    }

    public int takeDamage(int damage) {
        // reduce damage because of armor!!! oh yeah!
        damage -= ARMOR;
        // set new hp
        return super.takeDamage(damage);
    }
}