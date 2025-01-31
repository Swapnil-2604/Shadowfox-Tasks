package com.test;

import java.util.Scanner;

import com.manager.ContactManager;

 
public class Test {
	static ContactManager c=new ContactManager();
	public static void main(String[] args) {
		while(true) {	
		System.out.println("----- Main Menu ----- \n1)Add Contact \n2)View Contact \n3)Update Contact \n4)Delete Contact");
			Scanner sc=new Scanner(System.in);
			int choice=sc.nextInt();
			switch (choice) {
			case 1: {
				c.addcontacts();
				continue;
			}
			case 2:{
				c.viewContact();
				continue;
			}
			case 3:{
				c.updateContact();
				continue;
			}
			case 4:{
				c.deleteContact();
				continue;
			}
			default:
				System.err.println("You entered the wrong Choice! Please try it again");
				continue;
			}
	}
	}

}
