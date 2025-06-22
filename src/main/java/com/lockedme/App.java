package com.lockedme;

import java.io.File;
import java.util.Scanner;

public class App {

    static final String BASE_PATH = "main"; // You can change this path as needed

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
                    displayFiles();
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

    public static void displayFiles() {
        File folder = new File(BASE_PATH);
        File[] files = folder.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("No files found in directory.");
        } else {
            System.out.println("Files in directory:");
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("→ " + file.getName());
                }
            }
        }
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
                    addFile(scanner);
                    break;
                case 2:
                    deleteFile(scanner);
                    break;
                case 3:
                    searchFile(scanner);
                    break;
                case 4:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }

        } while (op != 4);
    }

    public static void addFile(Scanner scanner) {
        System.out.print("Enter file name to add: ");
        String fileName = scanner.nextLine();
        File file = new File(BASE_PATH + "/" + fileName);

        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while adding the file.");
        }
    }

    public static void deleteFile(Scanner scanner) {
        System.out.print("Enter file name to delete: ");
        String fileName = scanner.nextLine();
        File file = new File(BASE_PATH + "/" + fileName);

        if (file.delete()) {
            System.out.println("File deleted successfully.");
        } else {
            System.out.println("File not found or could not be deleted.");
        }
    }

    public static void searchFile(Scanner scanner) {
        System.out.print("Enter file name to search: ");
        String fileName = scanner.nextLine();
        File file = new File(BASE_PATH + "/" + fileName);

        if (file.exists()) {
            System.out.println("File found: " + file.getAbsolutePath());
        } else {
            System.out.println("File not found.");
        }
    }
}
