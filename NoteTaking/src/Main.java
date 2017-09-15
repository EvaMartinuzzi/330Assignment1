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
        String sortChoice = scanner.nextLine();
        sortChoice.toLowerCase();
        //ask for search terms
        System.out.println(sortChoice);
        System.out.println("What are you searching for?");
        String keyword = scanner.nextLine();
        search.searchBy(keyword,sortChoice);

    }
}

