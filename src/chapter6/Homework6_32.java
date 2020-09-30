public class Homework6_32 {


	public static void main(String[] args) {
		/*6.32 (Game: chance of winning at craps)
		 *Revise Exercise 6.30 to run it 10,000 times and display the number of winning games.*/
          	int currentRound = 1;
		int wins = 0;
		int losses = 0;
		int determine = 0;

		for(currentRound = 1; currentRound <= 10_000; currentRound++){
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
				determine = rollAgain(total);
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

	public static int diceRolls(){

		int roll =(int)(Math.random()*6+1);
		return roll;
	}

	public static int rollAgain(int total){

                int rollOne = diceRolls();
		int rollTwo = diceRolls();
		boolean keepRolling = true;
		int determine = 0;
                int subTotal = rollOne + rollTwo;

		while(keepRolling){

			if(subTotal == 7){
				System.out.println(rollOne + " and " + rollTwo + " is " + subTotal + " You lose");
				determine = 2;
				return determine;
			}
			else if(subTotal == total){
                                System.out.println(rollOne + " and " + rollTwo + " is " + subTotal + " You win");
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
}
