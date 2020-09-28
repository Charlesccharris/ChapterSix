package chapter6;

import java.util.Scanner;

public class Homework6_5 {

	public static void displaysSortedNumbers(double num1, double num2, double num3) {
		double temp1 = num1;
		double temp2 = num2;
		double temp3 = num3;
		System.out.println(num1 + "," + num2 +", and" + num3 + "is " + temp1 + ", " + temp2 + ", and " + temp3);
		
		if(temp1 < temp2 && temp1 < temp3) {
			num1 = temp1;
			System.out.println("Box one");
			
			if(temp2 < temp3) {
				num2 = temp2;
				num3 = temp3;
			}
			else {
				num2 = temp3;
				num3 = temp2;
			}
		}
		else if(temp1 < temp2 && temp1 > temp3) {
			num2 = temp1;
			System.out.println("Box two");
			if(temp2 < temp3) {
				num3 = temp3;
				num1 = temp2;
			}
			else {
				num3 = temp2;
				num1 = temp3;
			}
		}
		else if(temp1 > temp2 && temp1 < temp3) {
			num2 = temp1;
			System.out.println("Box three");
			if(temp2 < temp3) {
				num1 = temp2;
				num3 = temp3;
			}
			else {
				num3 = temp2;
				num1 = temp3;
			}
		}
		else if(temp1 > temp2 && temp1 > temp3) {
			num3 = temp1;
			System.out.println("Box four");
			if(temp2 < temp3) {
				num1 = temp2;
				num2 = temp3;
			}
			else {
				num2 = temp2;
				num1 = temp3;
			}
		}
		System.out.println(temp1 + ", " + temp2 + ", and " + temp3 + " in ascending order is " +
		num1 + ", " + num2 + ", and " + num3);

	}
	public static void main(String[] args) {
		/*6.5 (Sort three numbers)
		 * Write a method with the following header to display three numbers in increasing order:
		 * public static void displaySortedNumbers( double num1, double num2, double num3)
		 * Write a test program that prompts the user to enter three numbers
		 * and invokes the method to display them in increasing order.*/
		double num1;
		double num2;
		double num3;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Type in a number: ");
		num1 = input.nextDouble();
		System.out.print("Type in a number: ");
		num2 = input.nextDouble();
		System.out.print("Type in a number: ");
		num3 = input.nextDouble();
		
		displaysSortedNumbers(num1, num2, num3);

		input.close();
	}

}
