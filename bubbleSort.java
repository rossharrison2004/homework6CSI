import java.io.*;
import java.util.*;

public class bubbleSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bubble Sort Menu:");
            System.out.println("1. Generate and save a random array");
            System.out.println("2. Read an array, sort it, and save the sorted array");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                generateAndSaveRandomArray();
            } else if (choice == 2) {
                readSortSaveArray();
            } else if (choice == 3) {
                System.out.println("Exiting the program.");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    public static void generateAndSaveRandomArray() {
        int arrayLength = 10; // You can change this to the desired length
        int[] randomArray = new int[arrayLength];
        Random rand = new Random();

        for (int i = 0; i < arrayLength; i++) {
            randomArray[i] = rand.nextInt(101); // Generate random integers between 0 and 100
        }

        saveArrayToFile(randomArray, "random_array.txt");
        System.out.println("Random array has been generated and saved in 'random_array.txt'.");
    }

    public static void readSortSaveArray() {
        int[] unsortedArray = readArrayFromFile("unsorted_array.txt");
        bubbleSort(unsortedArray);
        saveArrayToFile(unsortedArray, "sorted_array.txt");
        System.out.println("Unsorted array has been sorted and saved in 'sorted_array.txt'.");
    }

    public static void saveArrayToFile(int[] array, String filename) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (int num : array) {
                writer.println(num);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public static int[] readArrayFromFile(String filename) {
        List<Integer> arrayList = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextInt()) {
                arrayList.add(scanner.nextInt());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }

        int[] array = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            array[i] = arrayList.get(i);
        }

        return array;
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }
}
