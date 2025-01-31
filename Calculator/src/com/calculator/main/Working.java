package com.calculator.main;

import java.util.Scanner;

public class Working {
	Scanner sc = new Scanner(System.in);

	public void performCalculations() {
		System.out.println("Enter the first number:");
		double num1 = sc.nextDouble();

		double result = num1;
		String continueCalculation = null;

		do {

			System.out.println("Enter the other number:");
			double num2 = sc.nextDouble();

			System.out.println("Choose an operation: +, -, *, /");
			char operation = sc.next().charAt(0);

			switch (operation) {
			case '+':
				result += num2;
				break;
			case '-':
				result -= num2;
				break;
			case '*':
				result = result * num2;
				break;
			case '/':
				if (num2 != 0) {
					result = result / num2;
				} else {
					System.out.println("Error: Division by zero is not allowed.");
					continue;
				}
				break;
			default:
				System.out.println("Invalid operation. Please try again.");
				continue;
			}

			System.out.println("The result of is = " + result);
			System.out.println("Do you want to continue calculation? (yes/no)");
			continueCalculation = sc.next();
		} while (continueCalculation.equalsIgnoreCase("yes"));
	}

	public void root() {
		String continueCalculation;
		do {
			System.out.println("Enter the number to find the square root");
			double no = sc.nextDouble();
			double result = Math.sqrt(no);
			System.out.println("The square root of the number is :" + result);
			System.out.println("Do you want to perform another calculation? (yes/no)");
			continueCalculation = sc.next();
		} while (continueCalculation.equalsIgnoreCase("yes"));
	}

	public void expo() {
		String continueCalculation;
		do {
			System.out.println("Enter the number to find square");
			double no = sc.nextDouble();
			double result = no * no;
			System.out.println("The square of the number is :" + result);
			System.out.println("Do you want to perform another calculation? (yes/no)");
			continueCalculation = sc.next();
		} while (continueCalculation.equalsIgnoreCase("yes"));
	}

	public void temprature() {
		String continueCalculation = null;
		do {
			System.out.println(
					"Select the conversion which you want to convert \n1) Celsius to Fahrenheit \n2) Fahrenheit to Celsius ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter your temprature in Celsius");
				double temp1 = sc.nextDouble();
				double result = (temp1 * 1.8) + 32;
				System.out.println(temp1 + " Celsius to Fahrenheit = " + result);
				System.out.println("Do you want to perform another calculation? (yes/no)");
				continueCalculation = sc.next();

			}
			case 2: {
				System.out.println("Enter your temprature in Fahrenheit");
				double temp1 = sc.nextDouble();
				double result = (temp1 * 1.8) + 32;
				System.out.println(temp1 + " Fahrenheit to Celsius = " + result);
				System.out.println("Do you want to perform another calculation? (yes/no)");
				continueCalculation = sc.next();
			}
			default:
				System.out.println("Invalid operation. Please try again.");
				continue;
			}
		} while (continueCalculation.equalsIgnoreCase("yes"));
	}

	public void currency() {
		String continueCalculation = null;
		double indianruppee = 0.0116;
		double usdollar = 86.1677;
		do {
			System.out.println("Select the conversion which you want to do \n1) IND to USD \n2)USD to INR ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter the value");
				double inr = sc.nextDouble();
				double result = inr * usdollar;
				System.out.println("coversion of " + inr + " INR to USD is: " + result);
				System.out.println("Do you want to perform another calculation? (yes/no)");
				continueCalculation = sc.next();
			}
			case 2: {
				System.out.println("Enter the value");
				double usd = sc.nextDouble();
				double result = usd * indianruppee;
				System.out.println("coversion of " + usd + " USD to INR is: " + result);
				System.out.println("Do you want to perform another calculation? (yes/no)");
				continueCalculation = sc.next();
			}
			default:
				System.out.println("Invalid operation. Please try again.");
				continue;
			}
		} while (continueCalculation.equalsIgnoreCase("yes"));

	}

}