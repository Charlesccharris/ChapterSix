package chapter6;

public class Homework6_32 {

	public static void main(String[] args) {
		/*6.32 (Game: chance of winning at craps)
		 *Revise Exercise 6.30 to run it 10,000 times and display the number of winning games.*/
          	int currentRound = 1;
		int wins = 0;
		int losses = 0;
		For(currentRound < 10_000, currentRound = 1, currentRound++){
			int diceOne = diceRolls();
        	        int diceTwo = diceRolls();

			int total = diceOne + diceTwo;

			System.out.println(diceOne + " " + diceTwo);

			switch(total){
			case 2: case 3: case 12:
				System.out.println("Craps! You lost!");
				losses++;
				break;
			case 7: case 11:
				System.out.println("Natural! You won!");
				wins++;
				break;
			default:
				System.out.println("Point established, point is: " + total);
				rollAgain(total);
					if(won)
						wins++;
					else
						losses++;
				break;
			}
		}
	}

	public static int diceRolls(){

		int roll =(int)(Math.random()*6+1);
		return roll;
	}

	public static void rollAgain(int total){

                int rollOne = diceRolls();
		int rollTwo = diceRolls();

		boolean keepRolling = true;
		int wonOrLost;
                int subTotal = rollOne + rollTwo;

		while(keepRolling){

			if(subTotal == 7){
				System.out.println(rollOne + " and " + rollTwo + " is " + subTotal + " You lose");
				wonOrLost = 1;
				keepRolling = false;
			}
			else if(subTotal == total){
                                System.out.println(rollOne + " and " + rollTwo + " is " + subTotal + " You win");
				wonOrLost = 0;
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
		return wonOrLost;
	}
	}

}
