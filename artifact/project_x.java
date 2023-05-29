import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TerminalApp {
    private static final String FILE_PATH = "/usr/share/nginx/html/test.txt";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/db_name";
    private static final String DB_USER = "username";
    private static final String DB_PASSWORD = "password";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("> ");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                saveToFile(input);
                saveToDatabase(input);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("An error occurred while saving to the database: " + e.getMessage());
        }
    }

    private static void saveToFile(String input) throws IOException {
        try (FileWriter fileWriter = new FileWriter(FILE_PATH, true)) {
            fileWriter.write(input + "\n");
        }
    }

    private static void saveToDatabase(String input) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "INSERT INTO terminal_input (input_text) VALUES (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, input);
            preparedStatement.executeUpdate();
        }
    }
}

