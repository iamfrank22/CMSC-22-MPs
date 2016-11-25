public abstract class Character{
	public WeaponBehavior weapon;

	public void setWeapon(WeaponBehavior w){
		this.weapon = w;
	}

	public abstract void fight();

	public void useWeapon(){
		weapon.useWeapon();
	}
}