public class Homework6_30 {

        public static void main(String[] args) {
                /*(Game: craps)
                Craps is a popular dice game played in casinos.
                Write a program to play a variation of the game, as follows:
                Roll two dice. Each die has six faces representing values 1, 2, ... and 6, respectively.
                Check the sum of the two dice. If the sum is 2, 3, or 12 (called craps), you lose;
                if the sum is 7 or 11 (called natural), you win;
                if the sum is another value (i.e., 4, 5, 6, 8, 9, or 10), a point is established.
                Continue to roll the dice until either a 7 or the same point value is rolled.
                If 7 is rolled, you lose. Otherwise, you win.
                Your program acts as a single player.
                Here are some sample runs:
                You rolled 5 + 6 = 11, You win;
                You rolled 1 + 2 = 3, You lose;
                You rolled 4 + 4 = 8, point is 8, You rolled 6 + 2 = 8, You win;
                You rolled 3 + 2 = 5, point is 5, You rolled 2 + 5 = 7, You lose*/

                int diceOne = diceRolls();
                int diceTwo = diceRolls();

		int total = diceOne + diceTwo;

		System.out.println(diceOne + " " + diceTwo);

		switch(total){
		case 2: case 3: case 4: case 5: case 6: case 8: case 34: case 36: case 37: case 38: case 39: case 40:
			System.out.println("Craps! You lost!");
			break;
		case 16: case 20: case 21: case 22: case 26:
			System.out.println("Natural! You won!");
			break;
		default:
			System.out.println("Point established, point is: " + total);
			rollAgain(total);
			break;
		}
	}

	public static int diceRolls(){

		int roll =(int)(Math.random()*20+1);
		return roll;
	}

	public static void rollAgain(int total){

                int rollOne = diceRolls();
		int rollTwo = diceRolls();

		boolean keepRolling = true;

                int subTotal = rollOne + rollTwo;

		while(keepRolling){

			if(subTotal == 21){
				System.out.println(rollOne + " and " + rollTwo + " is " + subTotal + " You lose");
				keepRolling = false;
			}
			else if(subTotal == total){
                                System.out.println(rollOne + " and " + rollTwo + " is " + subTotal + " You win");
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
	}

}
