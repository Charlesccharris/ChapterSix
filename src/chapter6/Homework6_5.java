import java.util.Scanner;

public class Homework6_5 {

	public static void main(String[] args) {
		/*6.5 (Sort three numbers)
		 * Write a method with the following header to display three numbers in increasing order:
		 * public static void displaySortedNumbers( double num1, double num2, double num3)
		 * Write a test program that prompts the user to enter three numbers
		 * and invokes the method to display them in increasing order.*/
		double num1;
		double num2;
		double num3;
		int choice = 0;
		char choose;

		Scanner input = new Scanner(System.in);

		System.out.print("Type in a number: ");
		num1 = input.nextDouble();
		System.out.print("Type in a number: ");
		num2 = input.nextDouble();
		System.out.print("Type in a number: ");
		num3 = input.nextDouble();

		System.out.print("Ascending or Descending: ");
		choose = input.next().charAt(0);

		choose = Character.toUpperCase(choose);

		if(choose == 'A')
			choice = 0;
		else if(choose == 'D')
			choice = 1;
		else{
			System.out.println("No go.");
			System.exit(1);
		}

		switch(choice){
		case 0:
                System.out.print(num1 + ", " + num2 + ", and " + num3 + " in ascending order is: ");
		displaysSortedNumbersUp(num1, num2, num3);
		break;

		case 1:
		System.out.print(num1 + ", " + num2 + ", and " + num3 + " in descending order is: ");
		displaysSortedNumbersDown(num1, num2, num3);
		break;

		default:
		System.out.println("Bye");
		}

		input.close();
	}

	public static void displaysSortedNumbersDown(double num1, double num2, double num3) {
                double temp1 = num1;
                double temp2 = num2;
                double temp3 = num3;

                if(temp1 > temp2 && temp1 > temp3)
                numberSorted5(temp1, temp2, temp3);

                else if(temp1 > temp2 && temp1 < temp3)
                numberSorted6(temp1, temp2, temp3);

                else if(temp1 < temp2 && temp1 > temp3)
                numberSorted7(temp1, temp2, temp3);

                else if(temp1 < temp2 && temp1 < temp3)
                numberSorted8(temp1, temp2, temp3);
	}

	public static void displaysSortedNumbersUp(double num1, double num2, double num3) {
		double temp1 = num1;
		double temp2 = num2;
		double temp3 = num3;

		if(temp1 < temp2 && temp1 < temp3)
		numberSorted1(temp1, temp2, temp3);

		else if(temp1 < temp2 && temp1 > temp3)
		numberSorted2(temp1, temp2, temp3);

		else if(temp1 > temp2 && temp1 < temp3)
		numberSorted3(temp1, temp2, temp3);

		else if(temp1 > temp2 && temp1 > temp3)
		numberSorted4(temp1, temp2, temp3);

	}
	public static void numberSorted1(double temp1, double temp2, double temp3){

		double num1;
		double num2;
		double num3;

      		num1 = temp1;
    		if(temp2 < temp3) {
	       		num2 = temp2;
       			num3 = temp3;
      		}
      		else {
      			num2 = temp3;
	      		num3 = temp2;
      		}

	      	System.out.println(num1 + ", " + num2 + ", and " + num3);
	}

	public static void numberSorted2(double temp1, double temp2, double temp3){

		double num1;
		double num2;
		double num3;

		num2 = temp1;

		if(temp2 < temp3) {
			num3 = temp3;
			num1 = temp2;
		}
		else {
			num3 = temp2;
			num1 = temp3;
		}

                System.out.println(num1 + ", " + num2 + ", and " + num3);
	}

	public static void numberSorted3(double temp1, double temp2, double temp3){
		double num1;
		double num2;
		double num3;

		num2 = temp1;

		if(temp2 < temp3) {
			num1 = temp2;
			num3 = temp3;
		}
		else {
			num3 = temp2;
			num1 = temp3;
		}

                System.out.println(num1 + ", " + num2 + ", and " + num3);
	}

	public static void numberSorted4(double temp1, double temp2, double temp3){
		double num1;
		double num2;
		double num3;

		num3 = temp1;

		if(temp2 < temp3) {
			num1 = temp2;
			num2 = temp3;
		}
		else {
			num2 = temp2;
			num1 = temp3;
		}

                System.out.println(num1 + ", " + num2 + ", and " + num3);
	}

        public static void numberSorted5(double temp1, double temp2, double temp3){

                double num1;
                double num2;
                double num3;

                num1 = temp1;

                if(temp2 > temp3) {
                        num2 = temp2;
                        num3 = temp3;
                }
                else {
                        num2 = temp3;
                        num3 = temp2;
                }

                System.out.println(num1 + ", " + num2 + ", and " + num3);
        }

        public static void numberSorted6(double temp1, double temp2, double temp3){

                double num1;
                double num2;
                double num3;

                num2 = temp1;

                if(temp2 > temp3) {
                        num3 = temp3;
                        num1 = temp2;
                }
                else {
                        num3 = temp2;
                        num1 = temp3;
                }

                System.out.println(num1 + ", " + num2 + ", and " + num3);
        }

        public static void numberSorted7(double temp1, double temp2, double temp3){
                double num1;
                double num2;
                double num3;

                num2 = temp1;

                if(temp2 > temp3) {
                        num1 = temp2;
                        num3 = temp3;
                }
                else {
                        num3 = temp2;
                        num1 = temp3;
                }

                System.out.println(num1 + ", " + num2 + ", and " + num3);
        }

        public static void numberSorted8(double temp1, double temp2, double temp3){
                double num1;
                double num2;
                double num3;

                num3 = temp1;

                if(temp2 > temp3) {
                        num1 = temp2;
                        num2 = temp3;
                }
                else {
                        num2 = temp2;
                        num1 = temp3;
                }

                System.out.println(num1 + ", " + num2 + ", and " + num3);
        }
}
