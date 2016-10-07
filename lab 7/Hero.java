package ourlab7;


import java.util.Random;

public abstract class Hero extends RPGCharacter {
    private int level;
    //amounts of damage from moves 1-4; data of this array should be accessed starting at index 1
    private int[] movesDamage = { 0, 2, 3, 5, 10 };
    private int[] numTimesMovesCanbeUsed = { 0, 20, 15, 10, 1};
    private Random rand;

    public Hero(String name, int hp, int level) {
        super(name, hp);
        this.level = level;
    }


    // getters and setters
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setMoveDamageIncrease( int moveDamageIncrease ){
        if ( moveDamageIncrease < 0 ){
            throw new IllegalArgumentException("Can't increase a move's damage by a negative number!");
        }

        movesDamage[1] += moveDamageIncrease;
        movesDamage[2] += moveDamageIncrease;
        movesDamage[3] += moveDamageIncrease;
        movesDamage[4] += moveDamageIncrease;
    }

    public void setMoveDamageIncrease( int chosenMove, int moveDamageIncrease ){
        if ( moveDamageIncrease < 0 ){
            throw new IllegalArgumentException("Can't increase a move's damage by a negative number!");
        }

        movesDamage[chosenMove] += moveDamageIncrease;
    }

    public int getMoveDamage(int chosenMove){
        return movesDamage[chosenMove];
    }

    public void setNumTimesMoveCanbeUsed(int chosenMove, int numOfTimesThisMoveCanBeUsedNow ){
        numTimesMovesCanbeUsed[chosenMove] = numOfTimesThisMoveCanBeUsedNow;
    }

    public int getNumTimesMoveCanbeUsed(int chosenMove){
        return numTimesMovesCanbeUsed[chosenMove];
    }

    // inclusive random integer
    public int randInt(int min, int max) {
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
}