// App.java
package com.lockedme;

import java.io.File;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Ensure the "main" vault directory exists
        File vaultDir = new File("main");
        if (!vaultDir.exists()) {
            vaultDir.mkdir();
            System.out.println("📂 'main' vault folder created.");
        }

        // Authenticate user before proceeding
        if (!authenticate(scanner)) {
            return;
        }

        System.out.println("====================================");
        System.out.println("🔐 Welcome to VAULT KEEPER CLI 🔐");
        System.out.println("Developer: Milind Jain");
        System.out.println("Securely manage your digital vault");
        System.out.println("====================================\n");

        int choice;
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. 📁 Show files in your vault");
            System.out.println("2. ⚙️ Vault operations (Add/Delete/Search)");
            System.out.println("3. ❌ Exit the Vault");
            System.out.print("Your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        FileManager.displayFiles();
                        break;
                    case 2:
                        vaultOperations();
                        break;
                    case 3:
                        System.out.println("👋 Exiting the vault. Stay safe!");
                        return;
                    default:
                        System.out.println("⚠️ Invalid choice. Please try again.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Please enter a valid number.\n");
            }
        }
    }

    private static boolean authenticate(Scanner scanner) {
        String correctPassword = "vault123";
        System.out.print("🔑 Enter Vault Password: ");
        String input = scanner.nextLine();
        if (input.equals(correctPassword)) {
            System.out.println("✅ Access granted.\n");
            return true;
        } else {
            System.out.println("❌ Incorrect password. Access denied.");
            return false;
        }
    }

    private static void vaultOperations() {
        while (true) {
            System.out.println("\n--- Vault Operations Menu ---");
            System.out.println("1. ➕ Add a file to the vault");
            System.out.println("2. 🗑️ Delete a file from the vault");
            System.out.println("3. 🔍 Search for a file in the vault");
            System.out.println("4. 🔙 Return to main menu");
            System.out.print("Your choice: ");

            try {
                int subChoice = Integer.parseInt(scanner.nextLine());
                switch (subChoice) {
                    case 1:
                        System.out.print("Enter file name to add: ");
                        FileManager.addFile(scanner.nextLine());
                        break;
                    case 2:
                        System.out.print("Enter file name to delete: ");
                        String fileName = scanner.nextLine();
                        System.out.print("Are you sure you want to delete '" + fileName + "'? (yes/no): ");
                        String confirm = scanner.nextLine().toLowerCase();
                        if (confirm.equals("yes")) {
                            FileManager.deleteFile(fileName);
                        } else {
                            System.out.println("❎ Deletion cancelled.");
                        }
                        break;
                    case 3:
                        System.out.print("Enter file name to search: ");
                        FileManager.searchFile(scanner.nextLine());
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("⚠️ Invalid option. Try again.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Please enter a valid number.\n");
            }
        }
    }
}