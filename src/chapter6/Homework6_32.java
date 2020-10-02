import java.util.Scanner;

public class Homework6_32 {


	public static void main(String[] args) {
		/*6.32 (Game: chance of winning at craps)
		 *Revise Exercise 6.30 to run it 10,000 times and display the number of winning games.*/
          	Scanner input = new Scanner(System.in);

		int totalRounds;

		totalRounds = numberOfRounds(input);

		if(totalRounds <= 10)
			displayWithOutputs(totalRounds);
		else
			displayWithNoOutputs(totalRounds);
	}

	public static int numberOfRounds(Scanner input){

		char multiplier = 'n';
		int totalRounds;

		System.out.print("Enter a number of rolls to be multiplied (1-999): ");
		totalRounds = input.nextInt();

		if(totalRounds > 999 || totalRounds < 1){
			System.out.println("I told you to put in a number in the range of 1-999, it's not that hard to follow instructions.");
			System.exit(1);
		}

		System.out.println("\nNow enter a multiplier, (N)one, (T)housands, (M)illions: ");
		multiplier = input.next().charAt(0);
		multiplier = Character.toUpperCase(multiplier);

		if(multiplier == 'N')
			totalRounds *= 1;
		else if(multiplier == 'T')
			totalRounds *= 1_000;
		else if(multiplier == 'M')
			totalRounds *= 1_000_000;
		else{
			System.out.println("That's not a valid input");
			totalRounds *= 0;
			System.exit(1);
		}
		return totalRounds;
	}

	public static void displayWithOutputs(int totalRounds){

		int wins = 0;
		int losses = 0;
		int currentRound;
		int determine;

		for(currentRound = 1; currentRound <= totalRounds; currentRound++){
			int diceOne = diceRolls();
        	        int diceTwo = diceRolls();

			int total = diceOne + diceTwo;

			System.out.println(diceOne + " and " + diceTwo + " is " + total);

			switch(total){
			case 2: case 3: case 12:
				System.out.println("Craps! You lost!\n");
				losses++;
				break;
			case 7: case 11:
				System.out.println("Natural! You won!\n");
				wins++;
				break;
			default:
				System.out.println("Point established, point is: " + total);
				determine = rollAgainWithOutput(total);
					if(determine == 2)
						losses++;
					else if(determine == 3)
						wins++;
					else
						System.out.println("");
				break;
			}
		}

		System.out.println("You won " + wins + " times, and lost " + losses + " times");

	}

	public static void displayWithNoOutputs(int totalRounds){

		int wins = 0;
		int losses = 0;
		int currentRound;
		int determine;

		for(currentRound = 1; currentRound <= totalRounds; currentRound++){
			int diceOne = diceRolls();
        	        int diceTwo = diceRolls();

			int total = diceOne + diceTwo;

			switch(total){
			case 2: case 3: case 12:
				losses++;
				break;
			case 7: case 11:
				wins++;
				break;
			default:
				determine = rollAgainNoOutput(total);
					if(determine == 2)
						losses++;
					else if(determine == 3)
						wins++;
				break;
			}
		}

		System.out.println("You won " + wins + " times, and lost " + losses + " times");

	}

	public static int diceRolls(){

		int roll =(int)(Math.random()*6+1);
		return roll;
	}

	public static int rollAgainWithOutput(int total){

                int rollOne = diceRolls();
		int rollTwo = diceRolls();
		boolean keepRolling = true;
		int determine = 0;
                int subTotal = rollOne + rollTwo;

		while(keepRolling){

			if(subTotal == 7){
				System.out.println(rollOne + " and " + rollTwo + " is " + subTotal + " You lose\n");
				determine = 2;
				return determine;
			}
			else if(subTotal == total){
                                System.out.println(rollOne + " and " + rollTwo + " is " + subTotal + " You win\n");
				determine = 3;
				return determine;
			}
			else{
				System.out.println("Roll again");
	                	rollOne = diceRolls();
				rollTwo = diceRolls();
        	        	subTotal = rollOne + rollTwo;
                        	System.out.println(rollOne + " and " + rollTwo + " is " + subTotal);
				keepRolling = true;
			}
		}
	return determine;
	}

        public static int rollAgainNoOutput(int total){

                int rollOne = diceRolls();
                int rollTwo = diceRolls();
                boolean keepRolling = true;
                int determine = 0;
                int subTotal = rollOne + rollTwo;

                while(keepRolling){

                        if(subTotal == 7){
                                determine = 2;
                                return determine;
                        }
                        else if(subTotal == total){
                                determine = 3;
                                return determine;
                        }
                        else{
                                rollOne = diceRolls();
                                rollTwo = diceRolls();
                                subTotal = rollOne + rollTwo;
                                keepRolling = true;
                        }
                }
        return determine;
        }
}
