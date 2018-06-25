import java.util.Scanner;


public class Main {
	static Scanner s;
	public static void main(String args[]){
		s = new Scanner(System.in);
		Player[] pls = new Player[2];
		char choice;
		int n; //temporary variable
		
		pls[0] = new Player("Ash");
		pls[1] = new Player("LAW");
		
		pls[0].setPower(0, "Sadist", 10, 5, 20);
		pls[0].setPower(1, "Heartbreak", 15, 10, 25);
		pls[0].setPower(2, "Blood Rite", 20, 15, 30);
		pls[0].setPower(3, "Rupture", 25, 20, 35);
		
		pls[1].setPower(0, "Hand Of God", 15, 10, 25);
		pls[1].setPower(1, "Chain Frost", 20, 15, 30);
		pls[1].setPower(2, "Shackle", 25, 20, 35);
		pls[1].setPower(3, "Amplify Damage", 30, 25, 40);
		
		System.out.print("Enter the ability that you want to learn first for " +pls[0].getName() +" (1/2/3): ");
		n = s.next().charAt(0) - 49;
		pls[0].getPow()[n].learnAbility();
		
		System.out.print("Enter the ability that you want to learn first for " +pls[1].getName() +" (1/2/3): ");
		n = s.next().charAt(0) - 49;
		pls[1].getPow()[n].learnAbility();
		
		System.out.println("---------------------------------IOTA THE GAME----------------------------------");
		System.out.println("by Akash");
		System.out.println();
		System.out.println("Enter\na: to attack\nd: to drink potion\np: print player info\no: to print powers of the player\nq: to quit");
		while(true){
			System.out.print("Enter your choice: ");
			choice = s.next().charAt(0);
			switch(choice){
			case 'a':
				System.out.print("Enter the player which you want to attack from and to (e.g 1 2): ");
				String str = s.next();
				str += s.next();
				int from,to;
				from = str.charAt(0) - 49;
				to = str.charAt(1) - 49;
				System.out.print("Enter the power you want to use to attack(1/2/3/4): ");
				n = s.next().charAt(0) - 49;
				pls[from].attack(pls[to], n);
				if(pls[to].checkDead()==true){
					System.out.println(pls[to].getName() +" is dead!");
					System.out.println("--------------------------------GAME OVER------------------------------");
				}else if(pls[to].getHealth()<=20){
					System.out.print(pls[to].getName() +"'s health is low, do you want to drink the potion(y/n): ");
					choice  = s.next().charAt(0);
					if(choice=='y'){
						n = pls[to].drinkPotion();
						System.out.println(pls[to].getName() +"'s health restored: " +n);
					}
				}
				break;
			case 'd':
				System.out.print("Enter the player which wants to drink the potion(1/2): ");
				n = s.next().charAt(0) - 49;
				int h = pls[n].drinkPotion();
				System.out.println(pls[n] +"'s health restored: " +h);
				break;
			case 'p':
				System.out.print("Enter the player number to print info(1/2): ");
				n = s.next().charAt(0) - 49;
				System.out.println("----------------PLAYER INFO----------------");
				pls[n].printPlayer();
				break;
			case 'o':
				System.out.print("Enter the player number to print the powers(1/2): ");
				n = s.next().charAt(0) - 49;
				pls[n].printPowers();
				break;
			case 'q':
				System.out.println("THANK YOU FOR PLAYING IOTA");
				return;	
			}
		}
		// waiting for despacito 2
	}
}
