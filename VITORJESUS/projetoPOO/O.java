import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CreateCsvFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of columns from the user
        System.out.print("Enter the number of columns: ");
        int numColumns = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        // Get the column names from the user
        String[] columnNames = new String[numColumns];
        System.out.println("Enter the column names:");
        for (int i = 0; i < numColumns; i++) {
            System.out.print("Column " + (i + 1) + ": ");
            columnNames[i] = scanner.nextLine();
        }

        // Get the number of rows from the user
        System.out.print("Enter the number of rows: ");
        int numRows = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        // Get the data for each row from the user
        String[][] data = new String[numRows][numColumns];
        for (int i = 0; i < numRows; i++) {
            System.out.println("Enter the data for row " + (i + 1) + ":");
            for (int j = 0; j < numColumns; j++) {
                System.out.print(columnNames[j] + ": ");
                data[i][j] = scanner.nextLine();
            }
        }

        // Create a CSV writer
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.csv"))) {
            // Write the column names to the CSV file
            for (int i = 0; i < numColumns; i++) {
                writer.write(columnNames[i]);
                if (i < numColumns - 1) {
                    writer.write(",");
                }
            }
            writer.newLine();

            // Write the data to the CSV file
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numColumns; j++) {
                    writer.write(data[i][j]);
                    if (j < numColumns - 1) {
                        writer.write(",");
                    }
                }
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to CSV file: " + e.getMessage());
        }

        System.out.println("CSV file created successfully!");
    }
}