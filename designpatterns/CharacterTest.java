public class CharacterTest {
	public static void main(String[] args) {

		//characters with their respective weapons
		Character hero1 = new King();
		hero1.setWeapon(new KnifeBehavior());
		hero1.fight();

		Character hero2 = new Queen();
		hero2.setWeapon(new BowAndArrowBehavior());
		hero2.fight();

		Character hero3 = new Knight();
		hero3.setWeapon(new SwordBehavior());
		hero3.fight();

		Character hero4 = new Troll();
		hero4.setWeapon(new AxeBehavior());
		hero4.fight();

		//characters with different weapons
		Character ch1 = new Troll();
		ch1.setWeapon(new KnifeBehavior());
		ch1.fight();

		Character ch2 = new King();
		ch2.setWeapon(new SwordBehavior());
		ch2.fight();


	}
}