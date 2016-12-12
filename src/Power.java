
public class Power {
	private String name;
	private int damage,mana,xp,abilityLevel;
	private boolean abilityLearned;

	Power(String n, int d, int m, int x){
		name = n;
		damage = d;
		mana = m;
		xp = x;
		abilityLevel = 0;
		abilityLearned = false;
	}
	
	public String getName() {
		return name;
	}
	public int getDamage() {
		return damage;
	}
	public int getMana() {
		return mana;
	}
	public void learnAbility(){
		abilityLearned = true;
	}
	public boolean learned(){
		return abilityLearned;
	}
	public int getXp() {
		return xp;
	}
	public void levelUp(){
		if(abilityLearned==false){
			abilityLearned = true;
		}
		if(abilityLevel==4){
			System.out.println("Ability maxed out!");
			return;
		}
		abilityLevel++;
		if(abilityLevel==1){
			damage += 10;
			mana += 5;
		}
		if(abilityLevel==2){
			damage += 20;
			mana += 10;
		}
		if(abilityLevel==3){
			damage += 40;
			mana += 20;
		}if(abilityLevel==4){
			damage += 50;
			mana += 30;
		}
		System.out.println("Leveled UP ability: " +name);
		System.out.println("Damage: " +damage);
		System.out.println("Mana: " +mana);
	}
	
	public String toString(){
		String str = "";
		str = "Name: " +name +"\n" +"Level: " +abilityLevel +"\n" +"Ability Learned: " +abilityLearned +"\n" +"Damage: " +damage +"\n" +"Mana: " +mana; 
		return str;
	}
	
}
