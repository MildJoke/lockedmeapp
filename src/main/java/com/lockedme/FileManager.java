// FileManager.java
package com.lockedme;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileManager {
    private static final String VAULT_PATH = "main";

    public static void displayFiles() {
        File folder = new File(VAULT_PATH);
        String[] files = folder.list();

        if (files == null || files.length == 0) {
            System.out.println("📭 Your vault is currently empty.\n");
        } else {
            Arrays.sort(files);
            System.out.println("📂 Files in your vault (alphabetically):");
            for (String file : files) {
                System.out.println(" - " + file);
            }
            System.out.println();
        }
    }

    public static void addFile(String fileName) {
        try {
            File newFile = new File(VAULT_PATH + File.separator + fileName);
            boolean created = newFile.createNewFile();
            if (created) {
                System.out.println("✅ File '" + fileName + "' added to the vault.");
                System.out.println("🕒 Timestamp: " + java.time.LocalDateTime.now());
            } else {
                System.out.println("⚠️ File already exists in the vault.");
            }
        } catch (IOException e) {
            System.out.println("❌ Error creating file: " + e.getMessage());
        }
    }

    public static void deleteFile(String fileName) {
        File fileToDelete = new File(VAULT_PATH + File.separator + fileName);
        if (fileToDelete.exists()) {
            if (fileToDelete.delete()) {
                System.out.println("🗑️ File '" + fileName + "' was successfully deleted.");
            } else {
                System.out.println("❌ Could not delete the file. Please try again.");
            }
        } else {
            System.out.println("🚫 File Not Found: '" + fileName + "'");
        }
    }

    public static void searchFile(String fileName) {
        File folder = new File(VAULT_PATH);
        String[] files = folder.list();

        if (files != null && Arrays.asList(files).contains(fileName)) {
            System.out.println("🔎 File found: '" + fileName + "'");
        } else {
            System.out.println("❌ File not found in the vault.");
        }
    }
}
