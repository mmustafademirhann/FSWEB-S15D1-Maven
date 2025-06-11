package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {

    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n0 - Çıkış | 1 - Ekle | 2 - Sil");
            System.out.print("Seçiminiz: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // newline temizliği

            switch (choice) {
                case 0 -> running = false;
                case 1 -> {
                    System.out.print("Eklemek istediğiniz ürünleri girin (virgülle ayırabilirsiniz): ");
                    String input = scanner.nextLine();
                    addItems(input);
                    printSorted();
                }
                case 2 -> {
                    System.out.print("Silmek istediğiniz ürünleri girin (virgülle ayırabilirsiniz): ");
                    String input = scanner.nextLine();
                    removeItems(input);
                    printSorted();
                }
                default -> System.out.println("Geçersiz seçim.");
            }
        }

        scanner.close();
    }

    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmed = item.trim();
            if (!checkItemIsInList(trimmed)) {
                groceryList.add(trimmed);
            }
        }
        Collections.sort(groceryList); // Listeyi ekledikten sonra sırala
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            groceryList.remove(item.trim());
        }
        Collections.sort(groceryList); // Sildikten sonra da sırala
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        Collections.sort(groceryList); // Listenin kendisini sırala
        System.out.println("Siralli Liste: " + groceryList);
    }


}
