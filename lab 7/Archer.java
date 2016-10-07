package ourlab7;

public class Archer extends Hero {

    // because of sword
    //private static final int BASE_ATTACK = 5;

    private int move;
    private int attackDamage;
    private static final String[] archerMoves = {"", "usaKaArrow", "longRangeAttack", "rapidFire", "rainOfPoisonArrows"};
    // because of armor
    //private static final int ARMOR = 5;

    public Archer(String name, int level) {
        //ang level na i-accept sa pag-initialize kay 5 lang
        super(name, 25, 5);
        setMoveDamageIncrease(10); //Archer has 10 more attack/move damage compared to Thief and Swordsman
    }

    public Archer(String name) {
        super(name, super.randInt(1, 150), super.randInt(1, 30));
        setMoveDamageIncrease(super.randInt(1, 20));
    }

    //mura ra siya'g nag-getAttackDamage so no need na i-implement ang getAttackDamage
    public int attack(){
        return attackDamage;
    }

    public void setAttackDamage(int chosenMove) {
        //I THINK SA PAG-INPUT NAKA SA USER SA MAIN FUNCTION MAG-CHECK KUNG ANG CHOSEN MOVE KAY DILI WITHIN [1, 4] AND
        //IF DILI EQUAL TO 0 ANG CHOSEN MOVE
        // if ( (chosenMove < 1) || (chosenMove > 4) ){
        //     throw new IllegalArgumentException("Choose a number between [1, 4] only")
        // } else{
        setNumTimesMoveCanbeUsed(chosenMove, getNumTimesMoveCanbeUsed(chosenMove) - 1);
        attackDamage = getMoveDamage(chosenMove);
        //}
        //return BASE_ATTACK + getLevel();
    }

    public int takeDamage(int damage) {
        //ALWAYS DAKO ANG MA-TAKE NGA DAMAGE SA ARCHER BY 10
        return super.takeDamage(damage + 10);
        //super calls RPGCharacter class in this case
    }

    public String toString(){
        return super.toString() + ';' + " AvailableMoves{" +
                archerMoves[1] + '=' + getNumTimesMoveCanbeUsed(1) + "(move1)" + ", " +
                archerMoves[2] + '=' + getNumTimesMoveCanbeUsed(2) + "(move2)" + ", " +
                archerMoves[3] + '=' + getNumTimesMoveCanbeUsed(3) + "(move3)" + ", " +
                archerMoves[4] + '=' + getNumTimesMoveCanbeUsed(4) + "(move4)" + "} }";
    }
}