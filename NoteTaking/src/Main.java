import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws IOException {
        Note note = new Note();

        /*Asks for path to folder that contains file*/
        System.out.println("Please enter path to folder containing .txt files:");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        scanner.close();
        note.readFiles(path);

    }
}
