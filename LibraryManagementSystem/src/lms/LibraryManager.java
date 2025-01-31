package lms;

import java.sql.*;
import java.util.Scanner;

public class LibraryManager {

	private static final Scanner scanner = new Scanner(System.in);

	public static void addBook() {
		System.out.print("Enter book title: ");
		String title = scanner.nextLine();

		System.out.print("Enter book author: ");
		String author = scanner.nextLine();

		System.out.print("Enter book genre: ");
		String genre = scanner.nextLine();

		try (Connection conn = DatabaseManager.connect();
				PreparedStatement pstmt = conn
						.prepareStatement("INSERT INTO books (title, author, genre) VALUES (?, ?, ?)")) {

			pstmt.setString(1, title);
			pstmt.setString(2, author);
			pstmt.setString(3, genre);
			pstmt.executeUpdate();

			System.out.println("Book added successfully!");

		} catch (SQLException e) {
			System.err.println("Error adding book: " + e.getMessage());
		}
	}

	public static void displayBooks() {
		try (Connection conn = DatabaseManager.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM books")) {

			System.out.println("\nBooks in the Library:");
			System.out.println("----------------------------------------------------");
			while (rs.next()) {
				System.out.printf("ID: %d | Title: %s | Author: %s | Genre: %s | Available: %s\n", rs.getInt("id"),
						rs.getString("title"), rs.getString("author"), rs.getString("genre"),
						rs.getInt("available") == 1 ? "Yes" : "No");
			}
			System.out.println("----------------------------------------------------");

		} catch (SQLException e) {
			System.err.println("Error displaying books: " + e.getMessage());
		}
	}

}
