import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws IOException {
        Note note = new Note();
        Search search = new Search();

        /*Asks for path to folder that contains file*/
        System.out.println("Please enter path to folder containing .txt files:");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        scanner.close();
        note.readFiles(path);
        note.getNotesFromFiles();

        System.out.println("Please select how you want to view your notes: ");
        System.out.println("A. Display all notes with mentions (ex: @, #)" +
                "\nB. Display all notes, organized by mention (ex @, #" +
                "\nC. Display all searched keywords" +
                "\nD. Search notes for a keyword as plaintext and mention" +
                "\nE. Search all notes for keyword" +
                "\nF. Search all notes for keyword as a mention" +
                "\nG. Dispaly all notes by occurence of search word");
        Scanner scanner1 = new Scanner(System.in);
        String sortChoice = scanner1.nextLine();
        sortChoice.toLowerCase();
        scanner.close();

        if (sortChoice == "a") {
            //show all notes with mentions
        }
        if (sortChoice == "b") {
            //show all notes organized by mention
        }
        if (sortChoice == "c") {
            //show all searched keywords
        }
        else {
            search.searchBy(sortChoice);
        }
    }
}

