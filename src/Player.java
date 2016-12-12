import java.util.Scanner;
import java.util.Random;

public class Player {
	private String name;
	private int health,powers,mana,xp,wildCards;
	private Power[] pow;
	Scanner s = new Scanner(System.in);
	
	public Player(String n) {
		name = n;
		health = 100;
		mana = 250;
		wildCards = 4;
		powers = 4;
		xp = 0;
		pow = new Power[powers];
	}
	
	public int drinkPotion(){
		if(wildCards==0){
			System.out.println("Can't drink potion, you've reached the limit of your WildCards!");
			return 0;
		}
		wildCards--;
		Random r = new Random();
		int h = r.nextInt(100);
		if(health+h > 100){
			health = 100;
		}else{
			health += h;
		}
		return h;
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
	
	public void printPlayer(){
		System.out.println("Name: " +name);
		System.out.println("Health: " +health);
		System.out.println("Mana: " +mana);
		System.out.println("Powers");
		this.printPowers();
	}
	
	public void printPowers(){
		for(int i=0;i<powers;i++){
			System.out.println(pow[i].toString());
		}
	}
}
