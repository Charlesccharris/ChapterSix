import java.util.Scanner;

class Betting{
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);
		int money = 100;
		int diceOne;
		int diceTwo;
		int total;
		int bet;
		char wantToWin;
		char determine = ' ';

		while(money > 0){

			wantToContinue(money, input);
			bet = bettingAmount(money, input);
			wantToWin = betFor(input);

			diceOne = diceRolls();
                	diceTwo = diceRolls();

                	total = diceOne + diceTwo;

                	System.out.println(diceOne + " and " + diceTwo + " is " + total);

                	switch(total){
                	case 2: case 3: case 4: case 5: case 6: case 8: case 34: case 36: case 37: case 38: case 39: case 40:
                        	System.out.println("Craps! You lost!\n");
				determine = 'L';
				money = getBettingResults(wantToWin, determine, money, bet);
                        	break;
                	case 16: case 20: case 21: case 22: case 26:
                        	System.out.println("Natural! You won!\n");
				determine = 'W';
				money = getBettingResults(wantToWin, determine, money, bet);
                        	break;
                	default:
                        	System.out.println("Point established, point is: " + total);
                        	money = rollAgain(total, money, bet, determine, wantToWin);
                        	break;
			}
                }

		System.out.println("You went bust, try to manage your money better next time.");
        }

	public static void wantToContinue(int money, Scanner input){
		char askBetting = ' ';

		System.out.println("You have $" + money + ", do you want to keep betting?");
		askBetting = input.next().charAt(0);
		askBetting = Character.toUpperCase(askBetting);

		if(askBetting == 'N'){
			finalMoney(money);
			System.exit(1);
		}
		else if(askBetting != 'Y' && askBetting != 'N'){
			System.out.println("That's not a valid answer.");
			System.exit(1);
		}

	}

	public static int bettingAmount(int money, Scanner input){

		int bet;

		System.out.print("Enter bet : ");
		bet = input.nextInt();

		if(bet > money){
			System.out.println("You don't have that much money, so the bet will be all your money.");
			bet = money;
		}
		return bet;
	}

	public static char betFor(Scanner input){
		char betForAnswer = ' ';

		System.out.println("Do you want to bet for or against? (F) or (A)?");
		betForAnswer = input.next().charAt(0);
		betForAnswer = Character.toUpperCase(betForAnswer);

		return betForAnswer;
	}

        public static int diceRolls(){

                int roll =(int)(Math.random()*20+1);
                return roll;
        }

        public static int rollAgain(int total, int money, int bet, char determine, char wantToWin){

                int rollOne = diceRolls();
                int rollTwo = diceRolls();

                boolean keepRolling = true;

                int subTotal = rollOne + rollTwo;

                while(keepRolling){

                        if(subTotal == 21){
                                System.out.println(rollOne + " and " + rollTwo + " is " + subTotal + " You lose.\n");
				determine = 'L';
				money = getBettingResults(wantToWin, determine, money, bet);
                                keepRolling = false;
                        }
                        else if(subTotal == total){
                                System.out.println(rollOne + " and " + rollTwo + " is " + subTotal + " You win.\n");
				determine = 'W';

				money = getBettingResults(wantToWin, determine, money, bet);
                                keepRolling = false;
                        }
                        else{
	                        System.out.println("Roll again");
        	                rollOne = diceRolls();
                	        rollTwo = diceRolls();
	                        subTotal = rollOne + rollTwo;
        	                System.out.println(rollOne + " and " + rollTwo + " is " + subTotal);
                        }
                }

		return money;
        }

	public static int getBettingResults(char wantToWin, char determine, int money, int bet){

		if(wantToWin == 'F' && determine == 'W'){
			System.out.println("You won the round, and the bet.\n");
			money += bet;
		}
		else if(wantToWin == 'F' && determine == 'L'){
			System.out.println("You lost the round, and the bet.\n");
			money -= bet;
		}
		else if(wantToWin == 'A' && determine == 'W'){
			System.out.println("You won the round, but lost the bet.\n");
			money -= bet;
		}
		else if(wantToWin == 'A' && determine == 'L'){
			System.out.println("You lost the round, but won the bet.\n");
			money += bet;
		}

		return money;
	}

	public static void finalMoney(int money){

		System.out.print("You are leaving with $" + money);

		if(money > 100)
			System.out.println(". Congratulations! You came out on top!");
		else if(money < 100)
			System.out.println(". Too bad, better luck next time.");
		else if(money == 100)
			System.out.println(". You broke even.");

	}

}



