package lms;

import java.util.Scanner;

public class Main {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		DatabaseManager.initializeDatabase();

		System.out.println("Welcome to the Library Management System!");
		int userId = -1;

		while (userId == -1) {
			System.out.println("\n1. Register");
			System.out.println("2. Login");
			System.out.print("Choose an option: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			if (choice == 1) {
				UserManager.registerUser();
			} else if (choice == 2) {
				userId = UserManager.loginUser();
			} else {
				System.out.println("Invalid choice.");
			}
		}

		boolean exit = false;
		while (!exit) {
			System.out.println("\n1. Add Book");
			System.out.println("2. Display Books");
			System.out.println("3. Exit");
			System.out.print("Choose an option: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1 -> LibraryManager.addBook();
			case 2 -> LibraryManager.displayBooks();
			case 3 -> exit = true;
			default -> System.out.println("Invalid choice.");
			}
		}

		System.out.println("Goodbye!");
	}

}
