package ourlab7;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RPG {

    private Random rand;

    // constructor
    public RPG() {
        this.rand = new Random();
    }

    // generate a random monster name..
    public String getRandomMonsterName() {
        String[] adjectives = {"Green", "Slimy", "Bloody", "Smelly"};
        String[] monsters = {"Ogre", "Elf", "Giant", "Teacher"};
        List<String> adjs = Arrays.asList(adjectives);
        List<String> mons = Arrays.asList(monsters);

        return adjs.get(randInt(0, adjs.size() - 1)) + " " + mons.get(randInt(0, mons.size() - 1));
    }

    // inclusive random integer
    public int randInt(int min, int max) {
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    // coin toss --> no need na ni later on
    public boolean coinToss() {
        return randInt(0, 1) == 1 ? true : false;
    }

    // pause the game for awhile for dramatic effect!
    public void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    // duel two characters, one as attacker, one as defender
    // returns true if someone is killed
    public boolean duel(RPGCharacter attacker, RPGCharacter defender) {
        Scanner sc = new Scanner(System.in);

        //System.out.println(attacker);
        System.out.print("Choose a move (1=move1, 2=move2, 3=move3, 4=move4): ");
        int move = sc.nextInt();

        while (move != 1 && move != 2 & move != 3 && move!= 4){

            System.out.println("Number invalid! Choose again.");
            System.out.println(attacker);
            System.out.print("Choose a move (1=move1, 2=move2, 3=move3, 4=move4): ");
            move = sc.nextInt();
        }

        if( ((Hero)attacker).getNumTimesMoveCanbeUsed(move) <= 0 ){
            while (((Hero)attacker).getNumTimesMoveCanbeUsed(move) <= 0){
                System.out.println("\nNo available moves for that!! Choose again.");
                System.out.println(attacker);
                System.out.print("Choose a move (1=move1, 2=move2, 3=move3, 4=move4): ");
                move = sc.nextInt();
            }
        }

        attacker.setAttackDamage(move);
        int damage = attacker.attack();
        System.out.println("--> " + attacker.getName() + " ATK " + defender.getName());
        sleep(2000);

        //if (coinToss()) {
            int remHp = defender.takeDamage(damage);
            if (remHp <= 0) {
                System.out.printf("--> %s killed %s!\n", attacker.getName(), defender.getName());
                return true;
            }
        // } else {
        //     System.out.println("--> MISSED!");
        // }
        return false;
    }


    // game...
    /*public static void main(String[] args) {

        RPG rpg = new RPG();
        RPGCharacter hero = new Swordsman("nico", 30); // TODO take parameters as input via STDIN
        RPGCharacter monster = new Monster(rpg.getRandomMonsterName(), rpg.randInt(1, 100), rpg.randInt(1, 100));

        System.out.println("====== GAME START =====");
        System.out.printf("%s\n%s\n", hero, monster);

        // fight! for version 1, hero will always attack first.
        int count = 0;
        while (true) {
            System.out.println("== round " + ++count);
            // hero's turn
            boolean monsterIsDead = rpg.duel(hero, monster);
            if (monsterIsDead) break;

            // monster's turn
            boolean heroIsDead = rpg.duel(monster, hero);
            if (heroIsDead) break;

            //calls toString() of the class
            System.out.printf("%s\n%s\n", hero, monster);
        }

        System.out.printf("%s\n%s\n", hero, monster);
    }*/

    public static void main(String[] args){
        RPG rpg = new RPG();
        Scanner sc = new Scanner(System.in);

        System.out.println("~~~~~ HEROES ARE SUMMONED ~~~~~");
        System.out.print("Are you ready to play? (1=yes, 2=no): ");
        int x = sc.nextInt();

        //continue to scan until x is valid (1 or 2)
        while ( x != 1 && x != 2 ){
            System.out.println("Number invalid! Try again\n");
            System.out.print("Are you ready to play? (1=yes, 2=no): ");
            x = sc.nextInt();
        }

        if ( x == 1 ){
            System.out.print("Choose (1=single player, 2=2 players): ");
            int y = sc.nextInt();

            //continue to scan until y is valid
            while ( y != 1 && y != 2 ){
                System.out.println("Number invalid! Choose again!\n");
                System.out.print("Choose (1=single player, 2=2 players): ");
                y = sc.nextInt();
            }

            if ( y == 1 ){
                //ONE-PLAYER NI DIRI AGAINST MONSTER

            } else{
                //y == 2
                String player1 = "";
                String player2 = "";
                RPGCharacter playerOne = new Archer("dummyVal");
                RPGCharacter playerTwo = new Swordsman("dummyVal");

                //SCANS INFORMATION FOR PLAYER 1
                System.out.println("Player 1, choose your Hero:");
                System.out.print("\t(1=Swordsman, 2=Thief, 3=Archer): ");
                int z = sc.nextInt();

                //continue to scan until z is valid
                while ( z != 1 && z != 2 && z != 3 ){
                    System.out.println("Number invalid! Choose again!\n");
                    System.out.print("\t(1=Swordsman, 2=Thief, 3=Archer): ");
                    z = sc.nextInt();
                }

                System.out.print("Player 1, provide a name for your Hero: ");
                player1 = sc.next();

                if ( z == 1 ){
                    //level 5 is the base level
                    playerOne = new Swordsman(player1);
                } else if ( z == 2 ){
                    //playerOne = new Thief(player1);
                } else {
                    //if z == 3
                    playerOne = new Archer(player1);
                }


                //SCANS INFORMATION FOR PLAYER 2
                System.out.println("Player 2, choose your Hero:");
                System.out.print("\t(1=Swordsman, 2=Thief, 3=Archer): ");
                int a = sc.nextInt();

                //continue to scan until z is valid
                while ( a != 1 && a != 2 && a != 3 ){
                    System.out.println("Number invalid! Choose again!\n");
                    System.out.print("\t(1=Swordsman, 2=Thief, 3=Archer): ");
                    a = sc.nextInt();
                }

                System.out.print("Player 2, provide a name for your Hero: ");
                player2 = sc.next();

                if ( a == 1 ){
                    //level 5 is the base level
                    playerTwo = new Swordsman(player2);
                } else if ( a == 2 ){
                    //playerTwo = new Thief(player2);
                } else {
                    //if a == 3
                    playerTwo = new Archer(player2);
                }

                System.out.println("====== GAME START =====\n");
                //System.out.printf("%s\n%s\n", playerOne, playerTwo);

                // fight! for version 1, hero will always attack first.
                int count = 0;
                while (true) {
                    System.out.println("== round " + ++count);
                    // Player 1 turn

                    System.out.println("It's your turn, " + playerOne.getName());
                    System.out.printf("%s\n", playerOne);
                    boolean player1IsDead = rpg.duel(playerOne, playerTwo);
                    //System.out.println("\nDAMAGE INFLICTED IS " + playerOne.attack() + "hp !!!");
                    if (player1IsDead){
                        System.out.println("Player 2 wins!!");
                        break;
                    }

                    // Player 2 turn
                    System.out.println("It's your turn, " + playerTwo.getName());
                    System.out.printf("%s\n", playerTwo);
                    boolean player2IsDead = rpg.duel(playerTwo, playerOne);
                    // System.out.println("\nDAMAGE INFLICTED IS " + playerTwo.attack() + "hp !!!\n");
                    if (player2IsDead){
                        System.out.println("Player 1 wins!!");
                        break;
                    }

                    //calls toString() of the class
                    // System.out.printf("%s\n%s\n", playerOne, playerTwo);
                }
            } //inner if-else
        } //if (x == 1)
    }
}