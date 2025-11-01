import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentReader {
  public static void main(String[] args) {
    ArrayList<Student> students = new ArrayList<>();

    try {

      File file = new File("students.txt");
      Scanner scanner = new Scanner(file);

      int lineNumber = 1;
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();

        String[] parts = line.trim().split("\\s+");

        if (parts.length == 4) {
          String firstName = parts[0];
          String lastName = parts[1];
          String studentID = parts[2];
          String email = parts[3];

          Student student = new Student(firstName, lastName, studentID, email);
          students.add(student);
        } else {
          System.out.println("Line " + lineNumber + " has incorrect format: " + line);
        }

        lineNumber++;
      }

      scanner.close();

      System.out.println("=== Student List ===");
      for (int i = 0; i < students.size(); i++) {
        System.out.println((i + 1) + ". " + students.get(i));
      }

    } catch (FileNotFoundException e) {
      System.out.println("Error: students.txt file not found.");
    }
  }
}