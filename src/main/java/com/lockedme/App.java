package com.lockedme;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class App {

    static final String PROJECT_NAME = "LockedMe.com";
    static final String DEVELOPER_NAME = "Milind Jain";
    static final String ROOT_DIR = "main";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            showWelcomeScreen();
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    listFilesAscending();
                    break;
                case "2":
                    System.out.println("Business operations menu coming soon...");
                    break;
                case "3":
                    System.out.println("Exiting application. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input. Please enter 1, 2 or 3.\n");
            }
        }
    }

    private static void showWelcomeScreen() {
        System.out.println("=======================================");
        System.out.println("Welcome to " + PROJECT_NAME);
        System.out.println("Developed by: " + DEVELOPER_NAME);
        System.out.println("=======================================");
        System.out.println("Main Menu:");
        System.out.println("1. Display all files in ascending order");
        System.out.println("2. Business operations");
        System.out.println("3. Exit the application");
        System.out.println("=======================================\n");
    }

    private static void listFilesAscending() {
        File folder = new File(ROOT_DIR);
        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Directory does not exist: " + ROOT_DIR);
            return;
        }

        String[] files = folder.list();
        if (files == null || files.length == 0) {
            System.out.println("No files found in the directory.\n");
            return;
        }

        Arrays.sort(files, String.CASE_INSENSITIVE_ORDER);
        System.out.println("\nFiles in '" + ROOT_DIR + "' directory:");
        for (String file : files) {
            System.out.println("- " + file);
        }
        System.out.println(); // line break
    }
}
