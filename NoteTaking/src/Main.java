import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static String path;

    public static void main(String[] args) throws IOException {
        List<String> keywordArray = new ArrayList<String>();
        options(keywordArray);
    }

    public static void options(List<String> keywordArray) throws IOException {
        Note note = new Note();
        Search search = new Search();

        /*Asks for path to folder that contains file*/
        System.out.println("Please enter path to folder containing .txt files:");
        System.out.println("    Example: C:\\Users\\Name\\Documents\\NotesFolder");
        Scanner scanner = new Scanner(System.in);
        path = scanner.nextLine();

        System.out.println();
        System.out.println("Please select how you want to view your notes: ");
        System.out.println("A. Display all notes with mentions (ex: @, #)" +
                "\nB. Display all notes, organized by mention" +
                "\nC. Display all notes and their keywords" +
                "\nD. Display all notes, organized by keyword" +
                "\nE. Search all notes for a mention or a keyword" +
                "\nF. Dispaly all notes by number of references to other notes" +
                "\nG. Exit");
        String sortChoice = scanner.nextLine();
        sortChoice = sortChoice.toLowerCase();

        //either exits or brings user to their report
        if (sortChoice.equals("g")) {
            System.exit(1);
        } else {
            String keyword = "";
            search.setMap();
            search.searchBy(sortChoice);
        }
    }
}

