package ourlab7;

public class Thief extends Hero {

    private int move;
    private int attackDamage;
    private static final String[] thiefMoves = {"", "ilad", "dunggab", "specialSagpa", "LifeKawat"};

    public Thief(String name, int level) {
        super(name, 10, 5);
        setMoveDamage(8); //Thief has the lowest hp and attack damage
    }

    //mura ra siya'g nag-getAttackDamage so no need na i-implement ang getAttackDamage
    public int attack(){
        return attackDamage;
    }

    public void setAttackDamage(int chosenMove) {
        attackDamage = getMoveDamage(chosenMove);
    }

    public int takeDamage(int damage) {
        //no. of damage na matake sa Thief kay 3
        return super.takeDamage(damage + 3);
        //super calls RPGCharacter class in this case
    }

    public String toString(){
        return toString() + ';' + " AvailableMoves{" +
                thiefMoves[1] + '=' + getNumTimesMoveCanbeUsed(1) + ", " +
                thiefMoves[2] + '=' + getNumTimesMoveCanbeUsed(2) + ", " +
                thiefMoves[3] + '=' + getNumTimesMoveCanbeUsed(3) + ", " +
                thiefMoves[4] + '=' + getNumTimesMoveCanbeUsed(4) + "} }";
    }
}