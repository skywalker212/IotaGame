import java.util.Scanner;

public class Player {
	private String name;
	private int health,powers,mana,xp;
	private Power[] pow;
	Scanner s = new Scanner(System.in);
	
	public Player(String n,int h,int m) {
		name = n;
		health = h;
		mana = m;
		powers = 4;
		xp = 0;
		pow = new Power[powers];
	}
	
	public void drinkPotion(int h){
		if(health+h > 100){
			health = 100;
		}else{
			health += h;
		}
	}
	
	public int attack(Player pl,int p){
		if(pow[p].learned()==false){
			System.out.println("Can't attack,ability not learned!");
			return 0;
		}
		if(mana<pow[p].getMana()){
			System.out.println("Can't attack, not enough mana!");
			return 0;
		}
		int exp = pow[p].getXp();
		xp += exp;
		int damage = pow[p].getDamage();
		mana -= pow[p].getMana();
		System.out.println(name +"Attacked " +pl.getName() +" using power " +pow[p].getName());
		System.out.println("Mana Remaining: " +mana);
		System.out.println("Damage Done: " +damage);
		if(xp==50 || xp==100 || xp==150 || xp>=200){
			System.out.println("Which ability you want to level up (1/2/3/4): ");
			int n = s.nextInt();
			pow[n].levelUp();
		}
		return damage;
	}
	
	public void levelUp(int p){
		pow[p].levelUp();
	}

	public String getName() {
		return name;
	}

	public int getHealth() {
		return health;
	}

	public int getMana() {
		return mana;
	}

	public int getXp() {
		return xp;
	}
	
	public void setPower(int n, String na, int d, int ma, int x){
		pow[n] = new Power(na, d, ma, x);
	}
	public Power[] getPow() {
		return pow;
	}
	public void getDamage(int d){
		health -= d;
	}
	public boolean checkDead(){
		if(health<=0) return true;
		else return false;
	}
}
