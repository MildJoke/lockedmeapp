package com.lockedme;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("=== Welcome to LockedMe App ===");
        System.out.println("Developer: Milind Jain");

        do {
            System.out.println("\nMain Menu:");
            System.out.println("1. Display all files");
            System.out.println("2. File operations (Add, Delete, Search)");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    FileManager.displayFiles();
                    break;
                case 2:
                    showFileOperations(scanner);
                    break;
                case 3:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }

        } while (choice != 3);

        scanner.close();
    }

    public static void showFileOperations(Scanner scanner) {
        int op;
        do {
            System.out.println("\nFile Operations:");
            System.out.println("1. Add a file");
            System.out.println("2. Delete a file");
            System.out.println("3. Search a file");
            System.out.println("4. Go back to Main Menu");
            System.out.print("Enter your option: ");
            op = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (op) {
                case 1:
                    System.out.print("Enter file name to add: ");
                    FileManager.addFile(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Enter file name to delete: ");
                    FileManager.deleteFile(scanner.nextLine());
                    break;
                case 3:
                    System.out.print("Enter file name to search: ");
                    FileManager.searchFile(scanner.nextLine());
                    break;
                case 4:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }

        } while (op != 4);
    }
}
