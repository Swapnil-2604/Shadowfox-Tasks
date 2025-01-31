package lms;

import java.sql.*;
import java.util.Scanner;

public class UserManager {
	private static final Scanner scanner = new Scanner(System.in);

	public static void registerUser() {
		System.out.print("Enter username: ");
		String username = scanner.nextLine();

		System.out.print("Enter password: ");
		String password = scanner.nextLine();

		try (Connection conn = DatabaseManager.connect();
				PreparedStatement pstmt = conn
						.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)")) {

			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.executeUpdate();

			System.out.println("User registered successfully!");

		} catch (SQLException e) {
			System.err.println("Error registering user: " + e.getMessage());
		}
	}

	public static int loginUser() {
		System.out.print("Enter username: ");
		String username = scanner.nextLine();

		System.out.print("Enter password: ");
		String password = scanner.nextLine();

		try (Connection conn = DatabaseManager.connect();
				PreparedStatement pstmt = conn
						.prepareStatement("SELECT id FROM users WHERE username = ? AND password = ?")) {

			pstmt.setString(1, username);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("Login successful!");
				return rs.getInt("id");
			} else {
				System.out.println("Invalid credentials.");
			}

		} catch (SQLException e) {
			System.err.println("Error during login: " + e.getMessage());
		}
		return -1;
	}
}
