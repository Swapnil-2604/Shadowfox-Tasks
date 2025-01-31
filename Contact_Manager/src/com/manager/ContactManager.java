package com.manager;

import java.util.ArrayList;
import java.util.Scanner;

import com.info.*;

public class ContactManager {
	ArrayList<Contact> contacts = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	public void addcontacts() {
		System.out.println("Enter the name");
		String name = sc.next();
		System.out.println("Enter the phone number");
		int phone = sc.nextInt();
		System.out.println("Enter the Email id");
		String mail = sc.next();
		contacts.add(new Contact(name, phone, mail));
		System.out.println("Your information saved succesfully");
	}

	public void viewContact() {
		if (contacts.isEmpty()) {
			System.out.println("No Contacts in your List");
		} else {
			for (int i = 0; i < contacts.size(); i++) {
				System.out.println((i + 1) + " . " + contacts.get(i));
			}
		}

	}

	public void updateContact() {
		System.out.println("Enter the phone number to update");
		int phoneno = sc.nextInt();
		for (Contact contact : contacts) {
			if (contact.getPhoneno() == phoneno)
				while (true) {
					System.out.println("Do you want to change the name \n1).Yes \t2).No");
					String choice = sc.next();

					if (choice.equalsIgnoreCase("Yes") || choice.equals("1")) {
						System.out.println("Enter the new name");
						String name = sc.next();
						contact.setName(name);
						System.out.println("Name updated Sucessfully");
						break;
					} else if (choice.equalsIgnoreCase("No") || choice.equals("2")) {
						break;
					} else {
						System.err.println("Enter the correct choice");
						continue;
					}
				}
			while (true) {
				System.out.println("Do you want to change the Phoneno \n1).Yes \t2).No");
				String choice = sc.next();

				if (choice.equalsIgnoreCase("Yes")) {
					System.out.println("Enter the new Phoneno");
					int phone = sc.nextInt();
					contact.setPhoneno(phoneno);
					System.out.println("Phone no updated Sucessfully");

					break;
				} else if (choice.equalsIgnoreCase("No")) {
					break;
				} else {
					System.err.println("Enter the correct choice");
					continue;
				}
			}
			while (true) {
				System.out.println("Do you want to change the email \n1).Yes \t2).No");
				String choice = sc.next();

				if (choice.equalsIgnoreCase("Yes")) {
					System.out.println("Enter the new email");
					String mail = sc.next();
					contact.setEmail(mail);
					System.out.println("Email updated Sucessfully");

					break;
				} else if (choice.equalsIgnoreCase("No")) {
					break;
				} else {
					System.err.println("Enter the correct choice");
					continue;
				}
			}

		}

	}

	public void deleteContact() {
		System.out.println("Enter the phone no");
		int phoneno = sc.nextInt();
		for (Contact contact : contacts) {
			if (contact.getPhoneno() == phoneno) {
				contacts.remove(contact);
				System.out.println("Contact deleted succesfully");
			} else {
				System.out.println("No Contact found with " + phoneno);
			}

		}
	}
}
