package com.calculator.Test;
import com.calculator.main.*;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Working a=new Working();
		while(true) {
		System.out.println("Select what do you want to do: \n1)Arithmatic Operation \n2)Squareroot \n3)Square \n4)Temprature Conversion \n5) Currency Conversion ");
		Scanner sc=new Scanner(System.in);
		int choice=sc.nextInt();
		switch (choice) {
		case 1: {
		a.performCalculations();
		continue;
		}
		case 2:{
			a.root();
			continue;
		}
		case 3:{
			a.expo();
			continue;
		}
		case 4:{
			a.temprature();
			continue;
		}
		case 5:{
			a.currency();
			continue;
		}
		default:
			System.err.println("You entered the wrong choice");
			continue;
			
		}
		
	}
	}
}
