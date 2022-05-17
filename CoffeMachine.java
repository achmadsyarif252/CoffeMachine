package machine;
import java.util.Scanner;

public class CoffeeMachine {
	int money = 550;
	int water = 400;
	int milk = 540;
	int coffeBean = 120;
	int cup = 9;

	int requiredWater = 0;
	int requiredMilk = 0;
	int requiredCoffeBean = 0;
	Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		CoffeeMachine cfMachine3 = new CoffeeMachine();
		cfMachine3.mainMenu();
	}

	void mainMenu() {
		boolean exit = false;
		Scanner sc = new Scanner(System.in);
		while (!exit) {
			System.out.println("Write action (buy,fill,take,remaining,exit)");
			String input = sc.nextLine();
			switch (input) {
			case "take":
				take();
				break;
			case "fill":
				fill();
				break;
			case "buy":
				buy();
				break;
			case "remaining":
				printCurrentState();
				break;
			case "exit":
				exit = true;
				break;
			default:
				System.out.println("Write action (buy,fill,or take)!!");
				break;

			}

			System.out.println("");
		}
	}

	void printCurrentState() {
		System.out.println("The coffe machine has: ");
		System.out.println(water + " ml of water");
		System.out.println(milk + " ml of milk");
		System.out.println(coffeBean + " g of coffe beans");
		System.out.println(cup + " dispossable cups");
		System.out.println(money + " of money");
	}

	void take() {
		System.out.println("I gave you " + money);
		money -= money;
	}

	void fill() {
		System.out.println("Write how many ml of water you want to add:");
		int waterInput = scanner.nextInt();
		scanner.nextLine();
		water += waterInput;
		System.out.println("Write how many ml of milk you want to add:");
		int milkInput = scanner.nextInt();
		scanner.nextLine();
		milk += milkInput;
		System.out.println("Write how many grams of coffee beans you want to add");
		int coffeInput = scanner.nextInt();
		scanner.nextLine();
		coffeBean += coffeInput;
		System.out.println("Write how many disposable cups of coffee you want to add:");
		int cupInput = scanner.nextInt();
		scanner.nextLine();
		cup += cupInput;
	}

	void buy() {
		System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
		String input = scanner.nextLine();
		int requiredWater = 0;
		int requiredMilk = 0;
		int requiredCoffeBean = 0;
		int requiredMoney = 0;
		boolean isBack = false;

		switch (input) {
		case "1":
			requiredWater = 250;
			requiredCoffeBean = 16;
			requiredMilk = 0;
			requiredMoney = 4;
			break;
		case "2":
			requiredWater = 350;
			requiredMilk = 75;
			requiredCoffeBean = 20;
			requiredMoney = 7;
			break;
		case "3":
			requiredWater = 200;
			requiredMilk = 100;
			requiredCoffeBean = 12;
			requiredMoney = 6;
			break;
		case "back":
			isBack = true;
			break;

		default:
			System.out.println("Choose from 1 to 3 or back to main menu");
			break;
		}

		if (isBack == false) {
			boolean isWaterAvailable = (water - requiredWater) >= 0;
			boolean isMilkAvailable = (milk - requiredMilk) >= 0;
			boolean isCoffeBeanAvailable = (coffeBean - requiredCoffeBean) >= 0;
			String pesan = "";
			String waterMsg = "";
			String milkMsg = "";
			String coffeBeanMsg = "";
			if (!isWaterAvailable) {
				waterMsg = "water ";
			}
			if (!isMilkAvailable) {
				milkMsg = " milk";
			}
			if (!isCoffeBeanAvailable) {
				coffeBeanMsg = "coffe bean";
			}

			if (isWaterAvailable && isMilkAvailable && isCoffeBeanAvailable) {
				pesan = "I have enough resources, making you a coffee";
				water -= requiredWater;
				coffeBean -= requiredCoffeBean;
				milk -= requiredMilk;
				cup -= 1;
				money += requiredMoney;
			} else {
				pesan = "sorry, not eneough " + waterMsg + milkMsg + coffeBeanMsg;
			}
			System.out.println(pesan);

		}

	}
}
