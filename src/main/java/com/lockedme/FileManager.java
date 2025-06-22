package com.lockedme;

import java.io.File;
import java.util.Arrays;

public class FileManager {

    private static final String BASE_PATH = "main";

    public static void displayFiles() {
        File folder = new File(BASE_PATH);
        File[] files = folder.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("No files found in directory.");
            return;
        }

        Arrays.sort(files); // Sorting in ascending order
        System.out.println("Files in directory:");
        for (File file : files) {
            if (file.isFile()) {
                System.out.println("→ " + file.getName());
            }
        }
    }

    public static void addFile(String fileName) {
        File file = new File(BASE_PATH + "/" + fileName);

        try {
            if (file.createNewFile()) {
                System.out.println("✅ File created: " + file.getName());
            } else {
                System.out.println("⚠️ File already exists.");
            }
        } catch (Exception e) {
            System.out.println("❌ Error while adding file: " + e.getMessage());
        }
    }

    public static void deleteFile(String fileName) {
        File file = new File(BASE_PATH + "/" + fileName);
        if (file.delete()) {
            System.out.println("✅ File deleted.");
        } else {
            System.out.println("❌ File not found or couldn't be deleted.");
        }
    }

    public static void searchFile(String fileName) {
        File file = new File(BASE_PATH + "/" + fileName);
        if (file.exists()) {
            System.out.println("✅ File found: " + file.getAbsolutePath());
        } else {
            System.out.println("❌ File not found.");
        }
    }
}
